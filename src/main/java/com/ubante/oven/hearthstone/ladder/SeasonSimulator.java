package com.ubante.oven.hearthstone.ladder;

import com.ubante.oven.hearthstone.common.Game;
import com.ubante.oven.hearthstone.common.Player;

import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * We will simulate a full season of ladder.
 */
public class SeasonSimulator implements Runnable {
  int playerCount;
  ArrayList<LadderPlayer> players = new ArrayList<>();
  private BlockingQueue<Game> gameQueue = new ArrayBlockingQueue<>(10);
  private BlockingQueue<Player> playerQueue = new ArrayBlockingQueue<>(1000);
  private static boolean isSeasonOver = false;

  SeasonSimulator(int count) {
    this(count, 123);
  }

  SeasonSimulator(int count, int gamesToPlay) {
    playerCount = count;

    for (int i=1; i<=playerCount; i++) {
      String name = "lp" + i;
      LadderPlayer lp = new LadderPlayer(name);
      lp.setGamesToPlay(gamesToPlay);
      lp.setGameQueue(gameQueue);
      lp.setPlayerQueue(playerQueue);
      players.add(lp);
    }
  }

  /**
   * This method will validate LadderPlayer.getRank()
   * With  94 stars, you have are rank 1.
   * With  95 stars, you have are rank 0.
   */
  void checkStarConversion() {
    LadderPlayer lp = new LadderPlayer("test");

    for (int i=0; i<100; i++) {
      lp.setStarCount(i);
      int rank = lp.getRank();
      System.out.printf("With %3d stars, you have are rank %d", i, rank);
      if (lp.isLegend()) {
        System.out.println(" and a legend.");
      } else {
        System.out.println(".");
      }

    }
  }

  public static boolean isSeasonOver() {
    return isSeasonOver;
  }

  /**
   * This thread simulates a month of real-time.
   */
  @Override
  public void run() {
    isSeasonOver = true;
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
//    int playerCount = 6; int gamesToPlay = 2;
    int playerCount = 20; int gamesToPlay = 50;
//    int playerCount = 200; int gamesToPlay = 500;
    int pollDelay = 60; // in seconds

    System.out.printf("Starting %d player threads with each playing %d games.\n\n", playerCount, gamesToPlay);
    SeasonSimulator ss = new SeasonSimulator(playerCount, gamesToPlay);
//    ss.checkStarConversion();
    ss.begin(pollDelay);
  }
}
