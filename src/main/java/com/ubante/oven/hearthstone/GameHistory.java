package com.ubante.oven.hearthstone;

import java.util.ArrayList;

/**
 * Created by J on 10/26/2015.
 */
public class GameHistory {
  private ArrayList<Game> gameHistory = new ArrayList<>();
  public ArrayList<Player> players = new ArrayList<>();

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
    ArrayList<Player> players = new ArrayList<>();

    for (Game g: gameHistory) {
      System.out.printf("Game #%d: %s vs %s --> %s wins\n", g.gameNumber, g.statusStartPlayerA, g.statusStartPlayerB,
          g.winner.playerName);
//      System.out.printf("Game #%d: %s beat %s\n", g.gameNumber, g.winner.playerName, g.loser.playerName);
      if (! players.contains(g.winner)) {
        players.add(g.winner);
      }
      if (! players.contains(g.loser)) {
        players.add(g.loser);
      }
    }
  }
}
