package com.ubante.oven.hearthstone;

import java.util.concurrent.BlockingQueue;

/**
 * Created by J on 10/18/2015.
 */
public class IndependentPlayer implements Runnable {
  double eloRating;
  String playerName;
  ArenaTournament arenaTournament = null;
  int maxSeconds = 20;
  BlockingQueue<Game> queue;

  public IndependentPlayer(String name) {
    this(1000, name);
  }

  public IndependentPlayer(int rating, String name) {
    eloRating = rating;
    playerName = name;
  }

  public void setQueue(BlockingQueue<Game> queue) {
    this.queue = queue;
  }

  void pprint(String s) {
    System.out.printf("Thread %s: %s\n", playerName, s);
  }

  @Override
  public void run() {
    pprint("beginning");
    arenaTournament = ArenaTournament.joinTournament(this);

    for (int i=1; i<=5; i++) {
      int ms = (int) (Math.random() * 1000 * maxSeconds);

      pprint(String.format("entering game #%d in %d ms", i, ms));
      try {
        Thread.sleep(ms);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }

      try {
        queue.take();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

}

