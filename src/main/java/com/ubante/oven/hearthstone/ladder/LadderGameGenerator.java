package com.ubante.oven.hearthstone.ladder;

import com.ubante.oven.hearthstone.common.Game;
import com.ubante.oven.hearthstone.common.GameGenerator;
import com.ubante.oven.hearthstone.common.Player;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.concurrent.TimeUnit;

/**
 * Created by J on 11/15/2015.
 */
public class LadderGameGenerator extends GameGenerator {
  int gameCount = 0;

  public LadderGameGenerator(int delay) {
    pollDelay = delay;
  }

  Game makeGame(LadderPlayer p1, LadderPlayer p2) {
    Game g = new Game();
    gameCount++;
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

  /**
   * This should look like:
   * Rank 13: 2%, Rank 14: 5%, Rank 15: 12%, Rank 16: 23%, Rank 17:41%, Rank 18+: 17%
   */
  void printFinalSummary() {
    int playerCount = 0;
    Hashtable<Integer, Integer> rankFrequency = new Hashtable<>();

    pprint("------------------------");
    pprint("----- SEASON'S END -----");
    pprint("------------------------");
    pprint("");
    for (Player p : knownPlayers) {
      playerCount++;
      LadderPlayer lp = (LadderPlayer) p;
      int rank = lp.getRank();

      if (rankFrequency.containsKey(rank)) {
        int currentCount = rankFrequency.get(rank);
        rankFrequency.put(rank, currentCount+1);
      } else {
        rankFrequency.put(rank, 1);
      }
    }
    pprint("After " + playerCount + " players played " + gameCount + " total games.");

    // Print what exists
    Enumeration<Integer> keys = rankFrequency.keys();
    String toPrint = "";

    // Print by groups of five ranks
    int freq;
    for (int i=0; i<=25; i++) {

      if (rankFrequency.get(i) == null) {
        freq = 0;
      } else {
        freq = rankFrequency.get(i);
      }
      if (toPrint.equals("")) {
        toPrint = String.format("Rank %2d: %2.0f%%", i, (float) 100 * freq / playerCount);
      } else {
        toPrint = String.format("%s, R %2d: %2.0f%%", toPrint, i, (float) 100 * freq / playerCount);
      }

      // Special line for legends
      if (i == 0) {
        toPrint = String.format("Rank LEGEND: %2.0f%%", (float) 100 * freq / playerCount);
      }

      if (i/5*5 == i) {
        pprint(toPrint);
        toPrint = "";
      }
    }

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


