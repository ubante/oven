package com.ubante.oven.hearthstone.ladder;

import com.ubante.oven.hearthstone.common.Game;
import com.ubante.oven.hearthstone.common.Player;

import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * We will simulate a full season of ladder.
 */
public class SeasonSimulator {
  int playerCount;
  ArrayList<Player> players = new ArrayList<>();
  private BlockingQueue<Game> gameQueue = new ArrayBlockingQueue<>(10);
  private BlockingQueue<Player> playerQueue = new ArrayBlockingQueue<>(1000);


  SeasonSimulator(int count) {
    playerCount = count;

    for (int i=1; i<=playerCount; i++) {
      String name = "lp" + i;
      LadderPlayer lp = new LadderPlayer(name);
      lp.setGameQueue(gameQueue);
      lp.setPlayerQueue(playerQueue);
      players.add(lp);
    }
  }

  void begin(int pollDelay) {
  }

  public static void main(String[] args) {
    int playerCount = 5;
    int pollDelay = 60; // in seconds

    System.out.printf("Starting %d player threads.\n\n", playerCount);

    SeasonSimulator ss = new SeasonSimulator(playerCount);
    ss.begin(pollDelay);
  }
}
