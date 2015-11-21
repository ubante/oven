package com.ubante.oven.hearthstone.ladder;

import com.ubante.oven.hearthstone.common.Game;
import com.ubante.oven.hearthstone.common.GameGenerator;
import com.ubante.oven.hearthstone.common.Player;

import java.util.concurrent.TimeUnit;

/**
 * Created by J on 11/15/2015.
 */
public class LadderGameGenerator extends GameGenerator {

  public LadderGameGenerator(int delay) {
    pollDelay = delay;
  }

  Game makeGame(LadderPlayer p1, LadderPlayer p2) {
    Game g = new Game();
    g.setPlayer1(p1);
    g.setPlayer2(p2);

    LadderPlayer strongerPlayer = null;
    LadderPlayer weakerPlayer = null;

    // First let the winner be random.  We can implement this by letting the player that
    // got into the queue first win.
    strongerPlayer = p1;
    weakerPlayer = p2;

    g.setWinner(strongerPlayer);
    g.setLoser(weakerPlayer);

    return g;
  }

  void printFinalSummary() {
    int playerCount = 0;
    pprint("------------------------");
    pprint("----- SEASON'S END -----");
    pprint("------------------------");
    for (Player p : knownPlayers) {
      playerCount++;
    }

    pprint("Found: " + playerCount + " players");
  }

  @Override
  public void run() {
    Boolean keepLooking = true;

    pprint("Starting the ladder game generator thread.");

    while (keepLooking) {
      Player p1 = null;
      Player p2 = null;

      try {
        /**
         * If we find one person in queue, then wait a while for a second person.  Otherwise, we're done.
         */

        p1 = playerQueue.poll(pollDelay, TimeUnit.SECONDS);
        if (p1 == null) {
          keepLooking = false;
          pprint("Exiting because there is no one in queue.");
          continue;
        }
        p2 = playerQueue.poll(pollDelay, TimeUnit.SECONDS);
        if (p2 == null) {
          keepLooking = false;
          pprint("Exiting because there has been just one player in queue for " + pollDelay + " seconds");
          continue;
        }

      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      if (! knownPlayers.contains(p1)) { knownPlayers.add(p1); }
      if (! knownPlayers.contains(p2)) { knownPlayers.add(p2); }

      LadderPlayer lp1 = (LadderPlayer) p1;
      LadderPlayer lp2 = (LadderPlayer) p2;

      Game g = makeGame(lp1, lp2);
      LadderPlayer winner = (LadderPlayer) g.getWinner();
      LadderPlayer loser = (LadderPlayer) g.getLoser();
      pprint(String.format("%s (Rank %d) beat %s (Rank %d)", winner.playerName, winner.getRank(), loser.playerName,
          loser.getRank()));
      try {
        gameQueue.put(g);
        gameQueue.put(g);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }

    printFinalSummary();
  }


  public void start() {
    Thread t = new Thread(this, "GG");
    t.start();
  }
}


