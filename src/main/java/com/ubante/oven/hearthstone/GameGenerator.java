package com.ubante.oven.hearthstone;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * Created by J on 11/7/2015.
 */
public class GameGenerator implements Runnable {
  private BlockingQueue<Game> gameQueue;
  private BlockingQueue<IndependentPlayer> playerQueue;
  ArrayList<IndependentPlayer> knownPlayers = new ArrayList<>();
  int pollDelay;

  GameGenerator(int delay) {
    pollDelay = delay;
  }

  void setGameQueue(BlockingQueue<Game> q) {
    gameQueue = q;
  }

  public void setPlayerQueue(BlockingQueue<IndependentPlayer> playerQueue) {
    this.playerQueue = playerQueue;
  }

  void pprint(String s) {
    System.out.printf("Thread %4s: %s\n", "GG", s);
  }

  Game makeGame(IndependentPlayer p1, IndependentPlayer p2) {
    Game g = new Game();
    g.setPlayer1(p1);
    g.setPlayer2(p2);
    g.setLoser(p1);
    g.setWinner(p2);

    return g;
  }

  void printSummary(int loop) {
    pprint("");
    pprint("Summary: loop " + loop);

    Hashtable<Integer, Integer> wins = ArenaTournament.getWins();
    Enumeration<Integer> Keys = wins.keys();
    while (Keys.hasMoreElements()) {
      Integer v = Keys.nextElement();
      pprint(String.format("%2d win -> %3d occurences", v,
              wins.get(v)));
    }
  }

  @Override
  public void run() {
    int loopCounter = 0;
    Boolean keepLooking = true;

    while (keepLooking) {
      loopCounter++;
//      pprint("Looking to create a game");
      IndependentPlayer p1 = null;
      IndependentPlayer p2 = null;
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

  void start() {
    pprint("Starting the game generator.");
    Thread t = new Thread(this, "GG");
    t.start();
  }
}
