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
  private BlockingQueue<Game> gameQueue = new ArrayBlockingQueue<Game>(10);
  private BlockingQueue<IndependentPlayer> playerQueue =
      new ArrayBlockingQueue<IndependentPlayer>(100);

  IndependentPlayerSimulator(int count) {
    playerCount = count;

    for (int i=1; i<=playerCount; i++) {
      String name = "ip" + i;
      IndependentPlayer ip = new IndependentPlayer(name);
      ip.setGameQueue(gameQueue);
      ip.setPlayerQueue(playerQueue);
      players.add(ip);
    }
  }

  void begin() {
    GameGenerator gg = new GameGenerator();
    gg.setGameQueue(gameQueue);
    gg.setPlayerQueue(playerQueue);
    gg.start();

    for (IndependentPlayer ip: players) {
      new Thread(ip, ip.playerName).start();
    }
  }


  public static void main(String[] args) {
    IndependentPlayerSimulator ips = new IndependentPlayerSimulator(50);
    ips.begin();
  }

}
