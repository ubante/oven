package com.ubante.oven.hearthstone.ladder;

import com.ubante.oven.hearthstone.common.Game;
import com.ubante.oven.hearthstone.common.Player;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * This is a dude that lurvs the ladder.
 */
public class LadderPlayer extends Player {
  int starCount = 0;
  int maxSleepSeconds = 10;
  int gameCounter = 0;
  int winStreak = 0;
  int gamesToPlay;
  int starsToLegend = 95;
  int waitForGameIntervalSeconds = 30;

  public LadderPlayer(String s) {
    playerName = s;
  }

  public void setStarCount(int stars) {
    starCount = stars;
    if (starCount > starsToLegend ) {
      starCount = starsToLegend;
    }
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

  public boolean isLegend() {
    boolean isLegend;

    if (starCount == starsToLegend) { isLegend = true; }
    else { isLegend = false; }

    return isLegend;
  }

  public void setPlayerQueue(BlockingQueue<Player> pq) {
    playerQueue = pq;
  }

  @Override
  public void run() {
    pprint("Starting the ladder player thread.");

    // 100 games should be enough for a season
    for (int i=1; i<=gamesToPlay; i++) {

      if (SeasonSimulator.isSeasonOver()) {
        pprint("season has ended before I finished all my games");
        break;
      }

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
//        g = gameQueue.take();
        g = gameQueue.poll(waitForGameIntervalSeconds, TimeUnit.SECONDS);
        if (g == null) {
          pprint("Waiting too long for a game; done for the season.");
          return;
        }
      } catch (InterruptedException e) {
        e.printStackTrace();
        pprint("Problems so quitting");
        return;
      }

      // At 95 stars, you are a legend and can no longer lose stars or rank
      if (isLegend() == false) {
        if (g.getLoser().equals(this)) {
          if (starCount > 0) {
            starCount--;
          }
          winStreak = 0;
        } else {
          // At ranks 1-5, win streaks do not earn additional stars.
          if (winStreak >= 2 && getRank() > 5) {
            starCount += 2;
          } else {
            starCount++;
          }
          winStreak++;
        }
      }

      // recover from all the mental strain
      int ms = (int) (Math.random() * 1000 * maxSleepSeconds);
      try {
        Thread.sleep(ms);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }

    pprint("done for the season");
  }
}
