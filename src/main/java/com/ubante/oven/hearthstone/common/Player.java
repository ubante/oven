package com.ubante.oven.hearthstone.common;

import java.util.concurrent.BlockingQueue;

/**
 * This is a base class that simulates a Player thread.  It should be subclassed.
 */
public class Player implements Runnable {
  public double eloRating;
  public String playerName;
  public BlockingQueue<Game> gameQueue;
  public BlockingQueue<Player> playerQueue;

  public Player() {}

  public Player(String name) {
    this(1000, name);
  }

  public Player(int rating, String name) {
    eloRating = rating;
    playerName = name;
  }

  public void setGameQueue(BlockingQueue<Game> gameQueue) {
    this.gameQueue = gameQueue;
  }

  public void setPlayerQueue(BlockingQueue<Player> playerQueue) {
    this.playerQueue = playerQueue;
  }

  public void pprint(String s) {
    System.out.printf("Thread %4s: %s\n", playerName, s);
  }

  @Override
  public void run() {
    System.out.println("You are in the base Player run method.  Something is wrong.");
  }

}

