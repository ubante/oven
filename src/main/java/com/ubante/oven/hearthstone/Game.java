package com.ubante.oven.hearthstone;

/**
 * Created by J on 11/7/2015.
 */
public class Game {
  IndependentPlayer player1;
  IndependentPlayer player2;
  IndependentPlayer winner;
  IndependentPlayer loser;

  Game() {

  }

  public IndependentPlayer getPlayer1() {
    return player1;
  }

  public void setPlayer1(IndependentPlayer player1) {
    this.player1 = player1;
  }

  public IndependentPlayer getPlayer2() {
    return player2;
  }

  public void setPlayer2(IndependentPlayer player2) {
    this.player2 = player2;
  }

  public IndependentPlayer getWinner() {
    return winner;
  }

  public void setWinner(IndependentPlayer winner) {
    this.winner = winner;
  }

  public IndependentPlayer getLoser() {
    return loser;
  }

  public void setLoser(IndependentPlayer loser) {
    this.loser = loser;
  }
}
