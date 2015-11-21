package com.ubante.oven.hearthstone.common;

import java.util.concurrent.BlockingQueue;

/**
 * This base class only does what is common to all Games.  Do not put makeGame() in here since it is too different
 * between the different game formats.
 *
 * This will be extended in the arena and ladder packages.  Caveat emptor.
 */
public class GameGenerator implements Runnable {
  public BlockingQueue<Game> gameQueue;
  public BlockingQueue<Player> playerQueue;
  public int pollDelay;

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

  public void pprint(String s) {
    System.out.printf("Thread %4s: %s\n", "GG", s);
  }

  // This should be overriden by subclass.
  @Override
  public void run() {
    System.out.println("You are in the base Game Generator run method.  Something is wrong.");
  }

}
