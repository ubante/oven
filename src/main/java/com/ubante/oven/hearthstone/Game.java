package com.ubante.oven.hearthstone;

/**
 * Created by J on 10/18/2015.
 */
public class Game {
  Player winner;
  Player loser;
  Player playerA;
  String statusStartPlayerA;
  String statusFinishPlayerA;
  Player playerB;
  String statusStartPlayerB;
  String statusFinishPlayerB;
  int gameNumber;

  Game(Player p1, Player p2, int number) {
    playerA = p1;
    playerB = p2;
    gameNumber = number;
    statusStartPlayerA = playerA.getShortArenaStatus();
    statusStartPlayerB = playerB.getShortArenaStatus();
    System.out.printf(toString());
  }

  public String toString() {
    return String.format("Game #%d created: %s vs %s\n", gameNumber, playerA.playerName, playerB.playerName);
  }

  public Player getWinner() {
    return winner;
  }

  public int getGameNumber() {
    return gameNumber;
  }

//  public void setGameNumber(int gameNumber) {
//    this.gameNumber = gameNumber;
//  }

  public void play() {

    int randomFactor = ((int) Math.random() * 5) - 2; // range of -2..2
    if ((playerA.getStarRating() + randomFactor) > playerB.getStarRating()) {
      winner = playerA;
      loser = playerB;
    } else {
      winner = playerB;
      loser = playerA;
    }

    winner.increaseEloRating(loser.eloRating);
    loser.decreaseEloRating(winner.eloRating);
    System.out.printf("Game #%d: %s played %s and the winner is %s\n", gameNumber, playerA.playerName, playerB.playerName,
        winner.playerName);
    statusFinishPlayerA = playerA.getShortArenaStatus();
    statusFinishPlayerB = playerB.getShortArenaStatus();
  }

  Player getOpponent(Player p) {
    if (playerA.equals(p)) {
      return playerB;
    } else {
      return playerA;
    }
  }

}
