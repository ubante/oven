package com.ubante.oven.hearthstone.hearthstonebad;

import java.util.ArrayList;

/**
 * Created by J on 10/23/2015.
 */
public class GameGenerator implements Runnable {
  int gameCounter = 0;

  private void sleep() {
    try {
      Thread.sleep(500);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  private void sleep(int sleepMillisecconds) {
    try {
      Thread.sleep(sleepMillisecconds);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void run() {
    int counter = 1800; // in case I forget to stop the thread

    while (counter > 0) {
      ArrayList<ArenaTournament> waitingArenaTournaments = new ArrayList<>();
      counter--;
      System.out.printf("(Thread-GG) --> is looking for waiting players out of the %d active arena tournaments\n",
          ArenaFormat.runningTournamentList.size());

      // jumping the shark
      for (ArenaTournament at: ArenaFormat.runningTournamentList) {
        String name = at.player.playerName;
        if (at.isReadyToPlay) {
          System.out.println("(Thread-GG) ----> waiting is " + name);
          waitingArenaTournaments.add(at);
        }

        if (waitingArenaTournaments.size() > 1) {
          // XXX use Elo/stars in the future
          gameCounter++;
          Game game = new Game(waitingArenaTournaments.get(0).player, waitingArenaTournaments.get(1).player,
              gameCounter);
          game.play();
          ArenaFormat.addGameToHistory(game);

          waitingArenaTournaments.get(1).game = game;
          waitingArenaTournaments.get(1).isReadyToPlay = false;
          waitingArenaTournaments.remove(1);
          waitingArenaTournaments.get(0).game = game;
          waitingArenaTournaments.get(0).isReadyToPlay = false;
          waitingArenaTournaments.remove(0);
          sleep();
        }
      }
      sleep(2000);
    }
  }
}
