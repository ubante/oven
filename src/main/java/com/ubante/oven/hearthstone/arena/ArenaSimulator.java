package com.ubante.oven.hearthstone.arena;

import com.ubante.oven.hearthstone.common.Game;
import com.ubante.oven.hearthstone.common.Player;

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
  ArrayList<ArenaPlayer> players = new ArrayList<>();
  private BlockingQueue<Game> gameQueue = new ArrayBlockingQueue<>(10);
  private BlockingQueue<Player> playerQueue = new ArrayBlockingQueue<>(1000);
//  private BlockingQueue<ArenaPlayer> playerQueue = new ArrayBlockingQueue<>(1000);

  ArenaSimulator(int count) {
    playerCount = count;

    for (int i=1; i<=playerCount; i++) {
      String name = "ip" + i;
      ArenaPlayer ap = new ArenaPlayer(name);
      ap.setGameQueue(gameQueue);
      ap.setPlayerQueue(playerQueue);
      players.add(ap);
    }
  }

  void begin(int pollDelay) {
    ArenaGameGenerator agg = new ArenaGameGenerator(pollDelay);
    agg.setGameQueue(gameQueue);
    agg.setPlayerQueue(playerQueue);
    agg.start();

    for (ArenaPlayer ip: players) {
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
