package com.ubante.oven.hearthstone.ladder;

import com.ubante.oven.hearthstone.common.Player;

import java.util.concurrent.BlockingQueue;

/**
 * This is a dude that lurvs the ladder.
 */
public class LadderPlayer extends Player {
  int starCount = 0;
  int maxSleepSeconds = 20;
  int gameCounter = 0;

  public LadderPlayer(String s) {
    playerName = s;
  }

  public void setStarCount(int starCount) {
    this.starCount = starCount;
  }

  int getRank() {
    int invertedRank = 0;

    if (starCount <= 10) { // Rank 21-25
      invertedRank = starCount/2;
    } else if ( starCount <=25 ) { // Rank 16-20
      invertedRank = (starCount-10)/3 + 5;
    } else if ( starCount <=45 ) { // Rank 11-15
      invertedRank = (starCount-25)/4 + 10;
    } else { // Rank 1-10
      invertedRank = (starCount-45)/5 + 15;
    }

    return 25 - invertedRank;
  }

  public void setPlayerQueue(BlockingQueue<Player> pq) {
    playerQueue = pq;
  }

  @Override
  public void run() {
    pprint("Starting the ladder player thread.");

    // play a game
    gameCounter++;
    pprint(String.format("entering game #%d", gameCounter));
    try {
      playerQueue.put(this);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    // recover from all the mental strain
    int ms = (int) (Math.random() * 1000 * maxSleepSeconds);
    try {
      Thread.sleep(ms);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
