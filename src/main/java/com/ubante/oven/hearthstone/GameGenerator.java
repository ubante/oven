package com.ubante.oven.hearthstone;

import java.util.concurrent.BlockingQueue;

/**
 * Created by J on 11/7/2015.
 */
public class GameGenerator implements Runnable {
  private BlockingQueue<Game> queue;

  void setQueue(BlockingQueue<Game> q) {
    queue = q;
  }

  void pprint(String s) {
    System.out.printf("Thread GG: %s\n", s);
  }

  @Override
  public void run() {

    while (true) {
      pprint("Looking to create a game");

      try {
        queue.put(new Game());
      } catch (InterruptedException e) {
        e.printStackTrace();
      }

      try {
        Thread.sleep(250); // milliseconds
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  void start() {
    pprint("Starting the game generator.");
    Thread t = new Thread(this, "GG");
    t.start();
  }
}
