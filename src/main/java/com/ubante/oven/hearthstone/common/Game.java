package com.ubante.oven.hearthstone.common;

/**
 * Created by J on 11/7/2015.
 */
public class Game {
  Player player1;
  Player player2;
  Player winner;
  Player loser;

  public Game() {}

  public void setPlayer1(Player player1) {
    this.player1 = player1;
  }

  public void setPlayer2(Player player2) {
    this.player2 = player2;
  }

  public Player getWinner() {
    return winner;
  }

  public Player getLoser() {
    return loser;
  }

  public void setWinner(Player winner) {
    this.winner = winner;
  }

  public void setLoser(Player loser) {
    this.loser = loser;
  }
}

