package com.ubante.oven.hearthstone;

import java.util.ArrayList;
import java.util.Hashtable;

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
  static ArrayList<String> completionRecord = new ArrayList<>();
  static Hashtable<Integer, Integer> wins = new Hashtable();

  ArenaTournament(IndependentPlayer p) { player = p; }

  void conclude() {
    isConcluded = true;
    completionRecord.add(getRecord());
    if (wins.containsKey(winCount)) {
      wins.put(winCount, wins.get(winCount) + 1);
    } else {
      wins.put(winCount, 1);
    }
  }

  public static Hashtable<Integer, Integer> getWins() {
    return wins;
  }

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
      conclude();
    }
  }

  String getRecord() {
    return String.format("[%d:%d-%d-%d]", starRanking, winCount, lossCount, gamesPlayed);
  }

  static String getCompletionRecord() {
    String results = null;


    for (String record : completionRecord) {
      results += record + "\n";
    }


    return results;
  }
}
