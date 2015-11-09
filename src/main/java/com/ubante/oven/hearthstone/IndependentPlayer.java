package com.ubante.oven.hearthstone;

import java.util.concurrent.BlockingQueue;

/**
 * Created by J on 10/18/2015.
 */
public class IndependentPlayer implements Runnable {
  double eloRating;
  String playerName;
  ArenaTournament arenaTournament = null;
  int maxSeconds = 20;
  BlockingQueue<Game> gameQueue;
  BlockingQueue<IndependentPlayer> playerQueue;

  public IndependentPlayer(String name) {
    this(1000, name);
  }

  public IndependentPlayer(int rating, String name) {
    eloRating = rating;
    playerName = name;
  }

  public void setGameQueue(BlockingQueue<Game> gameQueue) {
    this.gameQueue = gameQueue;
  }

  public void setPlayerQueue(BlockingQueue<IndependentPlayer> playerQueue) {
    this.playerQueue = playerQueue;
  }

  void pprint(String s) {
    System.out.printf("Thread %4s: %s\n", playerName, s);
  }

  @Override
  public void run() {
//    pprint("beginning");
    arenaTournament = new ArenaTournament(this);
    int gameCounter = 0;
//    for (int i=1; i<=20; i++) {
    while (! arenaTournament.isConcluded) {
      gameCounter++;
//      pprint(String.format("entering game #%d", gameCounter));
      try {
        playerQueue.put(this);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }

      try {
        Game g = gameQueue.take();
        arenaTournament.addGame(g);

//        if (g.winner.equals(this)) {
//          pprint(String.format("%s won game against %s",
//              arenaTournament.getRecord(), g.getLoser().playerName));
//        } else {
//          pprint(String.format("%s lost game against %s",
//              arenaTournament.getRecord(), g.getWinner().playerName));
//        }
      } catch (InterruptedException e) {
        e.printStackTrace();
      }

      // recover from all the mental strain
      int ms = (int) (Math.random() * 1000 * maxSeconds);
      try {
        Thread.sleep(ms);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }

//    pprint("arena tournament is concluded with a record of " + arenaTournament.getRecord());
  }

}

