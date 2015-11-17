package com.ubante.oven.hearthstone.common;

import com.ubante.oven.hearthstone.arena.ArenaTournament;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * This is a thread that simulates a Player.
 */
public class Player implements Runnable {
  double eloRating;
  public String playerName;
  public ArenaTournament arenaTournament = null;
  public int maxSeconds = 20;
  public BlockingQueue<Game> gameQueue;
  public BlockingQueue<Player> playerQueue;

  public Player() {}

  public Player(String name) {
    this(1000, name);
  }

  public Player(int rating, String name) {
    eloRating = rating;
    playerName = name;
  }

  public void setGameQueue(BlockingQueue<Game> gameQueue) {
    this.gameQueue = gameQueue;
  }

  public void setPlayerQueue(BlockingQueue<Player> playerQueue) {
    this.playerQueue = playerQueue;
  }

  void pprint(String s) {
    System.out.printf("Thread %4s: %s\n", playerName, s);
  }

  @Override
  public void run() {
//    arenaTournament = new ArenaTournament(this);
//    int gameCounter = 0;
////    for (int i=1; i<=20; i++) {
//    while (! arenaTournament.isConcluded) {
//      gameCounter++;
////      pprint(String.format("entering game #%d", gameCounter));
//      try {
//        playerQueue.put(this);
//      } catch (InterruptedException e) {
//        e.printStackTrace();
//      }
//
//      try {
//        Game g = gameQueue.poll(90, TimeUnit.SECONDS);
//        // If you are the last player, then you will find no games so give up
//        if (g == null) {
//          pprint("Been in queue too long; done for the day.  Finished with a record of " +
//              arenaTournament.getRecordString());
//          return;
//        }
//        arenaTournament.addGame(g);
//
////        if (g.winner.equals(this)) {
////          pprint(String.format("%s won game against %s",
////              arenaTournament.getRecordString(), g.getLoser().playerName));
////        } else {
////          pprint(String.format("%s lost game against %s",
////              arenaTournament.getRecordString(), g.getWinner().playerName));
////        }
//      } catch (InterruptedException e) {
//        e.printStackTrace();
//      }
//
//      // recover from all the mental strain
//      int ms = (int) (Math.random() * 1000 * maxSeconds);
//      try {
//        Thread.sleep(ms);
//      } catch (InterruptedException e) {
//        e.printStackTrace();
//      }
//    }

//    pprint("arena tournament is concluded with a record of " + arenaTournament.getRecordString());
  }

}

