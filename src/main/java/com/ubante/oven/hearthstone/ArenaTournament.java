package com.ubante.oven.hearthstone;

/**
 * Created by J on 11/5/2015.
 */
public class ArenaTournament {
  public IndependentPlayer player;
  public int winCount = 0;
  public int lossCount = 0;
  public int gamesPlayed = 0;
  public int starRanking = 0;
  Boolean lastGameWin = false;
  Boolean isConcluded = false;

  ArenaTournament(IndependentPlayer p) { player = p; }

  void addGame(Game g){
    gamesPlayed++;

    if (g.winner.equals(player)) {
      winCount++;

      // Account for win streaks
      if (lastGameWin) {
        starRanking = starRanking + 2;
      } else {
        starRanking++;
      }
      lastGameWin = true;
    }
    else {
      lossCount++;
      if (starRanking > 0) { starRanking--; }
      lastGameWin = false;
    }

    if ((lossCount == 3) || (winCount == 12)) {
      isConcluded = true;
    }
  }

  String getRecord() {
    return String.format("[%d:%d-%d-%d]", starRanking, winCount, lossCount, gamesPlayed);
  }

}
