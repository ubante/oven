package com.ubante.oven.hearthstone;

/**
 * Created by J on 10/31/2015.
 */
public class PlayerRating {
  int starRating;
  double eloRating;
  int winCount;
  int lossCount;

  PlayerRating(int star, double elo, int win, int loss) {
    starRating = star;
    eloRating = elo;
    winCount = win;
    lossCount = loss;
  }

  @Override
  public String toString() {
    return String.format("(%d-%4.0f-%d-%d)", starRating, eloRating, winCount, lossCount);
  }
}
