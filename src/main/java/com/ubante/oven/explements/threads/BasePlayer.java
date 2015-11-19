package com.ubante.oven.explements.threads;

import java.util.concurrent.BlockingQueue;

/**
 * Created by J on 11/18/2015.
 */
public class BasePlayer implements Runnable {
  String name;
  public BlockingQueue<BasePlayer> playerQueue;

  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setPlayerQueue(BlockingQueue<BasePlayer> playerQueue) {
    this.playerQueue = playerQueue;
  }

  @Override
  public void run() {
    System.out.println("Inside BasePlayer.run().");
  }
}
