package com.ubante.oven.hearthstone;

import java.util.ArrayList;

/**
 * Created by J on 10/23/2015.
 */
public class GameGenerator implements Runnable {

  private void sleep() {
    try {
      Thread.sleep(500);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void run() {
    int counter = 3600; // in case I forget to stop the thread

    while (counter > 0) {
      ArrayList<ArenaTournament> waitingArenaTournaments = new ArrayList<>();
      counter--;
      System.out.println("--> looking for players");

      // jumping the shark
      for (ArenaTournament at: ArenaFormat.runningTournamentList) {
        String name = at.player.playerName;
        if (at.isReadyToPlay) {
          System.out.println("----> waiting is " + name);
          waitingArenaTournaments.add(at);
        }

        if (waitingArenaTournaments.size() > 1) {
          // XXX use Elo in the future
          Game game = new Game(waitingArenaTournaments.get(0).player, waitingArenaTournaments.get(1).player);
          game.play();
          waitingArenaTournaments.get(0).game = game;
          waitingArenaTournaments.get(0).isReadyToPlay = false;
          waitingArenaTournaments.get(1).game = game;
          waitingArenaTournaments.get(1).isReadyToPlay = false;
        }
      }
      sleep();
    }
  }
}
