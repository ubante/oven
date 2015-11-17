package com.ubante.oven.hearthstone.common;

import com.ubante.oven.hearthstone.arena.ArenaTournament;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * This thread creates the games and decides their winner.  Players put themselves into the playerQueue, this thread
 * will block until there are two players and creates a game, decides the winner and puts the game into the gameQueue
 * for the players to find.  Eventually, all the threads will finish.
 *
 * This will be extended in the arena and ladder packages.  Caveat emptor.
 */
public class GameGenerator implements Runnable {
  private BlockingQueue<Game> gameQueue;
  private BlockingQueue<Player> playerQueue;
  ArrayList<Player> knownPlayers = new ArrayList<>();
  int pollDelay;

  public GameGenerator() {}

  public GameGenerator(int delay) {
    pollDelay = delay;
  }

  public void setGameQueue(BlockingQueue<Game> q) {
    gameQueue = q;
  }

  public void setPlayerQueue(BlockingQueue<Player> playerQueue) {
    this.playerQueue = playerQueue;
  }

  void pprint(String s) {
    System.out.printf("Thread %4s: %s\n", "GG", s);
  }

  Game makeGame(Player p1, Player p2) {
    Game g = new Game();
    g.setPlayer1(p1);
    g.setPlayer2(p2);

    // Decide on the winner
    // Give the player with a better record a greater chance of winning.
    // [ lower / (lower + higher) ]^2
    Player strongerPlayer;
    Player weakerPlayer;

    if ( p1.arenaTournament.getWinCount() > p2.arenaTournament.getWinCount()) {
      strongerPlayer = p1;
      weakerPlayer = p2;
    } else {
      strongerPlayer = p2;
      weakerPlayer = p1;
    }

    Integer strongerWins = strongerPlayer.arenaTournament.getWinCount();
    Integer weakerWins = weakerPlayer.arenaTournament.getWinCount();
    Random r = new Random();
    Float roll = r.nextFloat();

    // handle the case of a zero denominator
    Float ratio;
    if ((weakerWins+strongerWins) == 0) {
      ratio = 0.0f;
    } else {
      ratio = (float) ( weakerWins / (weakerWins+strongerWins) );
    }

    if ( roll > Math.pow(ratio, 2)) {
      g.setWinner(strongerPlayer);
      g.setLoser(weakerPlayer);
    } else {
      g.setWinner(weakerPlayer);
      g.setLoser(strongerPlayer);
    }

    return g;
  }

  void printSummary(int loop) {
    pprint("");
    pprint("Summary: loop " + loop);

    Hashtable<Integer, Integer> wins = ArenaTournament.getWins();
    Enumeration<Integer> Keys = wins.keys();
    while (Keys.hasMoreElements()) {
      Integer v = Keys.nextElement();
      pprint(String.format("%2d win -> %3d occurrences (%4.1f%% of %d players)", v,
              wins.get(v), (float) 100*wins.get(v)/knownPlayers.size(), knownPlayers.size()));
    }
  }

  @Override
  public void run() {
    int loopCounter = 0;
    Boolean keepLooking = true;

    while (keepLooking) {
      loopCounter++;
//      pprint("Looking to create a game");
      Player p1 = null;
      Player p2 = null;
      try {
        /**
         * If we find one person in queue, then wait a while for a second person.  Otherwise, we're done.
         */
        p1 = playerQueue.poll(pollDelay, TimeUnit.SECONDS);
        if (p1 == null) {
          keepLooking = false;
          pprint("Exiting because there is no one in queue.");
          continue;
        }
        p2 = playerQueue.poll(pollDelay, TimeUnit.SECONDS);
        if (p2 == null) {
          keepLooking = false;
          pprint("Exiting because there has been just one player in queue for " + pollDelay + " seconds");
          continue;
        }
      } catch (InterruptedException e) {
        e.printStackTrace();
      }

      if (! knownPlayers.contains(p1)) { knownPlayers.add(p1); }
      if (! knownPlayers.contains(p2)) { knownPlayers.add(p2); }

      try {
        Game g = makeGame(p1, p2);
        gameQueue.put(g);
        gameQueue.put(g);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }

      int divisor = knownPlayers.size();
      if (5*loopCounter/divisor*divisor == 5*loopCounter) {
        printSummary(loopCounter);
      }
    }

    // final summary
    pprint("");
    pprint("");
    pprint("----- FINAL -----");
    printSummary(loopCounter);
  }

  public void start() {
    pprint("Starting the game generator.");
    Thread t = new Thread(this, "GG");
    t.start();
  }
}
