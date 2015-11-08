package com.ubante.oven.hearthstone;

import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;

/**
 * Created by J on 11/7/2015.
 */
public class GameGenerator implements Runnable {
  private BlockingQueue<Game> gameQueue;
  private BlockingQueue<IndependentPlayer> playerQueue;
  ArrayList<IndependentPlayer> knownPlayers = new ArrayList<>();

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

  @Override
  public void run() {
    int loopCounter = 0;

    while (true) {
      loopCounter++;
      pprint("Looking to create a game");
      IndependentPlayer p1 = null;
      IndependentPlayer p2 = null;
      try {
        p1 = playerQueue.take();
        p2 = playerQueue.take();

        if (! knownPlayers.contains(p1)) { knownPlayers.add(p1); }
        if (! knownPlayers.contains(p2)) { knownPlayers.add(p2); }

      } catch (InterruptedException e) {
        e.printStackTrace();
      }

      try {
        Game g = makeGame(p1, p2);
        gameQueue.put(g);
        gameQueue.put(g);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }

      int divisor = knownPlayers.size();
      if (5*loopCounter/divisor*divisor == 5*loopCounter) {
        pprint("");
        pprint("Summary: loop " + loopCounter);
        pprint("");
      }
    }
  }

  void start() {
    pprint("Starting the game generator.");
    Thread t = new Thread(this, "GG");
    t.start();
  }
}
