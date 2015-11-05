package com.ubante.oven.hearthstone;

import java.util.ArrayList;

/**
 * Assuming a normal distribution of player Elo rating, how will a given player do.
 *
 * Add some random stuff.
 *
 * XXX needs logging
 */
public class IndependentPlayerSimulator {
  int playerCount;

  IndependentPlayerSimulator(int count) {
    playerCount = count;
  }

  void begin() {}

  public static void main(String[] args) {
    IndependentPlayerSimulator ips = new IndependentPlayerSimulator(3);
    ips.begin();
  }


}
