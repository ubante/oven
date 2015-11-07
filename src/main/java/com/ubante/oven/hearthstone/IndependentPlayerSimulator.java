package com.ubante.oven.hearthstone;

import java.util.ArrayList;

/**
 * This improves on ArenaOpponentRankSimulator by letting the IndependentPlayer run on its own
 * and fix the off-by-one errors.
 *
 * XXX needs logging
 */
public class IndependentPlayerSimulator {
  int playerCount;
  ArrayList<IndependentPlayer> players = new ArrayList<>();

  IndependentPlayerSimulator(int count) {
    playerCount = count;

    for (int i=1; i<=playerCount; i++) {
      String name = "ip" + i;
      IndependentPlayer ip = new IndependentPlayer(name);
      players.add(ip);
      new Thread(ip, name).start();
    }
  }



  public static void main(String[] args) {
    IndependentPlayerSimulator ips = new IndependentPlayerSimulator(4);
  }


}
