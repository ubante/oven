package com.ubante.oven.hearthstone.arena;

import com.ubante.oven.hearthstone.common.Game;
import com.ubante.oven.hearthstone.common.GameGenerator;
import com.ubante.oven.hearthstone.common.Player;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * This thread creates the games and decides their winner.  Players put themselves into the playerQueue, this thread
 * will block until there are two players and creates a game, decides the winner and puts the game into the gameQueue
 * for the players to find.
 */
public class ArenaGameGenerator extends GameGenerator {
//  ArrayList<Player> knownPlayers = new ArrayList<>();

  public ArenaGameGenerator(int delay) {
    pollDelay = delay;
  }

  Game makeGame(ArenaPlayer p1, ArenaPlayer p2) {
    Game g = new Game();
    g.setPlayer1(p1);
    g.setPlayer2(p2);

    // Decide on the winner
    // Give the player with a better record a greater chance of winning.
    // [ lower / (lower + higher) ]^2
    ArenaPlayer strongerPlayer = null;
    ArenaPlayer weakerPlayer = null;

    if ( p1.arenaTournament.getWinCount() > p2.arenaTournament.getWinCount()) {
      strongerPlayer = p1;
      weakerPlayer = p2;
    } else {
      strongerPlayer = p2;
      weakerPlayer = p1;
    }

    Integer strongerWins = strongerPlayer.arenaTournament.getWinCount();
    Integer weakerWins = weakerPlayer.arenaTournament.getWinCount();
    Random r = new Random();
    Float roll = r.nextFloat();

    // handle the case of a zero denominator
    Float ratio;
    if ((weakerWins+strongerWins) == 0) {
      ratio = 0.0f;
    } else {
      ratio = (float) ( weakerWins / (weakerWins+strongerWins) );
    }

    if ( roll > Math.pow(ratio, 2)) {
      g.setWinner(strongerPlayer);
      g.setLoser(weakerPlayer);
    } else {
      g.setWinner(weakerPlayer);
      g.setLoser(strongerPlayer);
    }

    return g;
  }

  void printSummary(int loop) {
    pprint("");
    pprint("Summary: loop " + loop);

    Hashtable<Integer, Integer> wins = ArenaTournament.getWins();
    Enumeration<Integer> Keys = wins.keys();
    while (Keys.hasMoreElements()) {
      Integer v = Keys.nextElement();
      pprint(String.format("%2d win -> %3d occurrences (%4.1f%% of %d players)", v,
              wins.get(v), (float) 100*wins.get(v)/knownPlayers.size(), knownPlayers.size()));
    }
  }

  @Override
  public void run() {
    int loopCounter = 0;
    Boolean keepLooking = true;

    while (keepLooking) {
      loopCounter++;
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

      /**
       * Since there is no arenaTournament field in the base Player class and since the playerQueue is defined in the base
       * GameGenerator class, we have to put ArenaPlayers in that queue as Players.  Then when we poll() them off, we have
       * to cast them back to ArenaPlayers so we have access to the arenaTournament field.
       */
      ArenaPlayer ap1 = (ArenaPlayer) p1;
      ArenaPlayer ap2 = (ArenaPlayer) p2;
      try {
        Game g = makeGame(ap1, ap2);
        gameQueue.put(g);
        gameQueue.put(g);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }

      int divisor = knownPlayers.size();
      if (5*loopCounter/divisor*divisor == 5*loopCounter) {
        printSummary(loopCounter);
      }
    }

    // final summary
    pprint("");
    pprint("");
    pprint("----- FINAL -----");
    printSummary(loopCounter);
  }

  public void start() {
    pprint("Starting the arena game generator.");
    Thread t = new Thread(this, "GG");
    t.start();
  }
}
