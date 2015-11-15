package com.ubante.oven.hearthstone.arena;

import com.ubante.oven.hearthstone.Game;
import com.ubante.oven.hearthstone.IndependentPlayer;

import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * This improves on ArenaOpponentRankSimulator by letting the IndependentPlayer run on its own
 * and fix the off-by-one errors.
 *
 * XXX needs logging and verbosity setting
 * XXX needs to match players with similar records
 */
public class ArenaSimulator {
  int playerCount;
  ArrayList<IndependentPlayer> players = new ArrayList<>();
  private BlockingQueue<Game> gameQueue = new ArrayBlockingQueue<>(10);
  private BlockingQueue<IndependentPlayer> playerQueue =
      new ArrayBlockingQueue<>(1000);

  ArenaSimulator(int count) {
    playerCount = count;

    for (int i=1; i<=playerCount; i++) {
      String name = "ip" + i;
      IndependentPlayer ip = new IndependentPlayer(name);
      ip.setGameQueue(gameQueue);
      ip.setPlayerQueue(playerQueue);
      players.add(ip);
    }
  }

  void begin(int pollDelay) {
    ArenaGameGenerator gg = new ArenaGameGenerator(pollDelay);
    gg.setGameQueue(gameQueue);
    gg.setPlayerQueue(playerQueue);
    gg.start();

    for (IndependentPlayer ip: players) {
      new Thread(ip, ip.playerName).start();
    }
  }


  public static void main(String[] args) {
    int playerCount = 500;
    int pollDelay = 60; // in seconds

    System.out.printf("Starting %d player threads.\n\n", playerCount);

    ArenaSimulator ips = new ArenaSimulator(playerCount);
    ips.begin(pollDelay);
  }

}
