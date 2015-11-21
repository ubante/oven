package com.ubante.oven.hearthstone.ladder;

import com.ubante.oven.hearthstone.common.Game;
import com.ubante.oven.hearthstone.common.Player;

import java.util.concurrent.BlockingQueue;

/**
 * This is a dude that lurvs the ladder.
 */
public class LadderPlayer extends Player {
  int starCount = 0;
  int maxSleepSeconds = 20;
  int gameCounter = 0;
  int winStreak = 0;
  int gamesToPlay;

  public LadderPlayer(String s) {
    playerName = s;
  }

  public void setStarCount(int starCount) {
    this.starCount = starCount;
  }

  public void setGamesToPlay(int gamesToPlay) {
    this.gamesToPlay = gamesToPlay;
  }

  public int getRank() {
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

    // 100 games should be enough for a season
    for (int i=1; i<100; i++) {
      // play a game
      gameCounter++;
      pprint(String.format("entering game #%d", gameCounter));
      try {
        playerQueue.put(this);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }

      Game g = null;
      try {
        g = gameQueue.take();
      } catch (InterruptedException e) {
        e.printStackTrace();
        pprint("Problems so quitting");
        return;
      }

      // do something with the game
      if (g.getLoser().equals(this)) {
        if (starCount > 0) {
          starCount--;
        }
        winStreak = 0;
      } else {
        if ( winStreak >= 2) {
          starCount += 2;
        } else {
          starCount++;
        }
        winStreak++;
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
}
