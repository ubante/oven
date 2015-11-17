package com.ubante.oven.hearthstone.arena;

import com.ubante.oven.hearthstone.common.Game;
import com.ubante.oven.hearthstone.common.Player;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * This is a thread that simulates an Arena Player.
 */
public class ArenaPlayer extends Player implements Runnable {
  double eloRating;
  public String playerName;
  public ArenaTournament arenaTournament = null;
  int maxSeconds = 20;
  BlockingQueue<Game> gameQueue;
//  BlockingQueue<ArenaPlayer> playerQueue;

  public ArenaPlayer(String name) {
    this(1000, name);
  }

  public ArenaPlayer(int rating, String name) {
    eloRating = rating;
    playerName = name;
  }

  public void setGameQueue(BlockingQueue<Game> gameQueue) {
    this.gameQueue = gameQueue;
  }

  public void setPlayerQueue(BlockingQueue<Player> pq) {
    playerQueue = pq;
  }
//  public void setPlayerQueue(BlockingQueue<ArenaPlayer> pq) {
//    playerQueue = pq;
//  }

  void pprint(String s) {
    System.out.printf("Thread %4s: %s\n", playerName, s);
  }

  @Override
  public void run() {
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
        Game g = gameQueue.poll(90, TimeUnit.SECONDS);
        // If you are the last player, then you will find no games so give up
        if (g == null) {
          pprint("Been in queue too long; done for the day.  Finished with a record of " +
              arenaTournament.getRecordString());
          return;
        }
        arenaTournament.addGame(g);

//        if (g.winner.equals(this)) {
//          pprint(String.format("%s won game against %s",
//              arenaTournament.getRecordString(), g.getLoser().playerName));
//        } else {
//          pprint(String.format("%s lost game against %s",
//              arenaTournament.getRecordString(), g.getWinner().playerName));
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

//    pprint("arena tournament is concluded with a record of " + arenaTournament.getRecordString());
  }

}

