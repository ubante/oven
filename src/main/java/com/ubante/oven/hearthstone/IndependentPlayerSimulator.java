package com.ubante.oven.hearthstone;

import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * This improves on ArenaOpponentRankSimulator by letting the IndependentPlayer run on its own
 * and fix the off-by-one errors.
 *
 * XXX needs logging
 */
public class IndependentPlayerSimulator {
  int playerCount;
  ArrayList<IndependentPlayer> players = new ArrayList<>();
  private BlockingQueue<Game> queue = new ArrayBlockingQueue<Game>(10);

  IndependentPlayerSimulator(int count) {
    playerCount = count;

    for (int i=1; i<=playerCount; i++) {
      String name = "ip" + i;
      IndependentPlayer ip = new IndependentPlayer(name);
      ip.setQueue(queue);
      players.add(ip);
    }
  }

  void start() {
    GameGenerator gg = new GameGenerator();
    gg.setQueue(queue);
    gg.start();

    for (IndependentPlayer ip: players) {
      new Thread(ip, ip.playerName).start();
    }
  }


  public static void main(String[] args) {
    IndependentPlayerSimulator ips = new IndependentPlayerSimulator(4);
    ips.start();
  }

}
