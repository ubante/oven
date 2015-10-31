package com.ubante.oven.hearthstone;

import java.util.ArrayList;

/**
 * Created by J on 10/26/2015.
 */
public class GameHistory {
  private ArrayList<Game> gameHistory = new ArrayList<>();
  public ArrayList<Player> players = new ArrayList<>();
  Player self;

  public void setSelf(Player self) {
    this.self = self;
  }

  public void add(Game g) {
    gameHistory.add(g);

    if (! players.contains(g.winner)) {
      players.add(g.winner);
    }
    if (! players.contains(g.loser)) {
      players.add(g.loser);
    }
  }

  public void printHistory() {
    print(false);
  }

  public void printMyHistory() {
    print(true);
  }

  public void print(boolean includeMe) {
    ArrayList<Player> players = new ArrayList<>();
    String upsetString = "";

    for (Game g: gameHistory) {
      // includeMe is set when the caller is a player and wants to know if a game was an upset victory
      if (includeMe) {
//        if (g.winner.eloRating < g.loser.eloRating) {
//          upsetString = String.format(" (upset) %4.0f beat %4.0f", g.winner.eloRating, g.loser.eloRating);
//        }
        if (g.winner.starRating < g.loser.starRating) {
          upsetString = String.format(" (upset) %d beat %d", g.winner.starRating, g.loser.starRating);
        }
      }

//      System.out.printf("Game #%d: %s vs %s --> %s wins%s\n", g.gameNumber, g.statusStartPlayerA, g.statusStartPlayerB,
//          g.winner.playerName, upsetString);

      // maybe this is better; we want:
      // Winner(record) beat Loser(record [upset]
      // the trick is we have to find the record of the Winner and Loser at the time of the game
      if (g.winner.equals(g.playerA)) {
        System.out.printf("Game #%d: %8s beat %s %s\n", g.gameNumber, g.statusStartPlayerA, g.statusStartPlayerB,
            upsetString);
      } else {
        System.out.printf("Game #%d: %8s beat %s %s\n", g.gameNumber, g.statusStartPlayerB, g.statusStartPlayerA,
            upsetString);
      }

      // not sure if the below is necessary anymore
      if (! players.contains(g.winner)) {
        players.add(g.winner);
      }
      if (! players.contains(g.loser)) {
        players.add(g.loser);
      }
    }
  }
}
