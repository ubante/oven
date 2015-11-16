package com.ubante.oven.hearthstone.common;

import com.ubante.oven.hearthstone.arena.ArenaPlayer;

/**
 * Created by J on 11/7/2015.
 */
public class Game {
  ArenaPlayer player1;
  ArenaPlayer player2;
  ArenaPlayer winner;
  ArenaPlayer loser;

  public Game() {}

  public void setPlayer1(ArenaPlayer player1) {
    this.player1 = player1;
  }

  public void setPlayer2(ArenaPlayer player2) {
    this.player2 = player2;
  }

  public ArenaPlayer getWinner() {
    return winner;
  }

  public void setWinner(ArenaPlayer winner) {
    this.winner = winner;
  }

  public void setLoser(ArenaPlayer loser) {
    this.loser = loser;
  }
}

