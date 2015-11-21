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
  ArrayList<LadderPlayer> players = new ArrayList<>();
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

  /**
   * This method will validate  LadderPlayer.getRank()
   */
  void checkStarConversion() {
    LadderPlayer lp = new LadderPlayer("test");

    for (int i=0; i<96; i++) {
      lp.setStarCount(i);
      int rank = lp.getRank();
      System.out.printf("With %3d stars, you have are rank %d.\n", i, rank);
    }
  }

  void begin(int pollDelay) {
    LadderGameGenerator lgg = new LadderGameGenerator(pollDelay);
    lgg.setGameQueue(gameQueue);
    lgg.setPlayerQueue(playerQueue);
    lgg.start();

    for (LadderPlayer lp: players) {
      new Thread(lp, lp.playerName).start();
    }
  }

  public static void main(String[] args) {
    int playerCount = 5;
//    int pollDelay = 6; // in seconds
    int pollDelay = 60; // in seconds

    System.out.printf("Starting %d player threads.\n\n", playerCount);

    SeasonSimulator ss = new SeasonSimulator(playerCount);
//    ss.checkStarConversion();
    ss.begin(pollDelay);
  }
}
