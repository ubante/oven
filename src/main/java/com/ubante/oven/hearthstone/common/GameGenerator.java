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
  public BlockingQueue<Game> gameQueue;
  public BlockingQueue<Player> playerQueue;
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

  // This should be overriden by subclass.
  @Override
  public void run() {
    System.out.println("You are in the base Game Generator run method.  Something is wrong.");
  }

  public void start() {
    pprint("Starting the game generator.");
    Thread t = new Thread(this, "GG");
    t.start();
  }
}
