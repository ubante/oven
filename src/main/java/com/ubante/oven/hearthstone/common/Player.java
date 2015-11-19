package com.ubante.oven.hearthstone.common;

import com.ubante.oven.hearthstone.arena.ArenaTournament;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * This is a thread that simulates a Player.
 */
public class Player implements Runnable {
  double eloRating;
  public String playerName;
  public ArenaTournament arenaTournament = null;
  public int maxSeconds = 20;
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

  void pprint(String s) {
    System.out.printf("Thread %4s: %s\n", playerName, s);
  }

  @Override
  public void run() {
    System.out.println("You are in the base Player run method.  Something is wrong.");
  }

}

