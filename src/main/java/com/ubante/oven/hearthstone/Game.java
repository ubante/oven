package com.ubante.oven.hearthstone;

/**
 * Created by J on 10/18/2015.
 */
public class Game {
  Player winner;
  Player loser;
  Player playerA;
  Player playerB;

  Game(Player p1, Player p2) {
    playerA = p1;
    playerB = p2;
  }

  public Player getWinner() {
    return winner;
  }

  public void play() {
    if (playerA.getEloRating() > playerB.getEloRating()) {
      winner = playerA;
      loser = playerB;
    } else {
      winner = playerB;
      loser = playerA;
    }
    winner.increaseEloRating(loser.eloRating);
    loser.decreaseEloRating(winner.eloRating);
    System.out.printf("%s played %s and the winner is %s\n", playerA.playerName, playerB.playerName,
        winner.playerName);
  }

}
