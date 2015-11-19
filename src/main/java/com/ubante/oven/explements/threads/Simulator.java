package com.ubante.oven.explements.threads;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by J on 11/18/2015.
 */
public class Simulator {
  BlockingQueue<BasePlayer> playerQueue = new ArrayBlockingQueue<BasePlayer>(10);
  BlockingQueue<BaseGameGenerator> gameQueue = new ArrayBlockingQueue<BaseGameGenerator>(10);
  RedBasePlayer player;
  GreenBaseGameGenerator gg;

  Simulator() {
    player = new RedBasePlayer();
    player.setName("Hodor");
    player.setPlayerQueue(playerQueue);
    System.out.println("Made player.");

    gg = new GreenBaseGameGenerator();
    gg.setPlayerQueue(playerQueue);
    gg.setGameQueue(gameQueue);
    System.out.println("Made gg.");
  }

  void go() {
    System.out.println("Starting the player thread.");
    new Thread(player).start();

    System.out.println("Starting the GG thread.");
    new Thread(gg).start();


  }

  public static void main(String[] args) {
    Simulator r = new Simulator();
    r.go();
  }
}
