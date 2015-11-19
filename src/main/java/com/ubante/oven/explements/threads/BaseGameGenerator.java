package com.ubante.oven.explements.threads;

import java.util.concurrent.BlockingQueue;

/**
 * Created by J on 11/18/2015.
 */
public class BaseGameGenerator implements Runnable {
  public BlockingQueue<BaseGameGenerator> gameQueue;
  public BlockingQueue<BasePlayer> playerQueue;

  public void setGameQueue(BlockingQueue<BaseGameGenerator> gameQueue) {
    this.gameQueue = gameQueue;
  }

  public void setPlayerQueue(BlockingQueue<BasePlayer> playerQueue) {
    this.playerQueue = playerQueue;
  }

  @Override
  public void run() {
    System.out.println("Inside BaseGameGenerator.run().");
  }
}
