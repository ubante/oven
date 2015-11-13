package com.ubante.oven.hearthstone.hearthstonebad;

import java.util.ArrayList;

/**
 * Assuming a normal distribution of player Elo rating, how will a given player do.
 *
 * Add some random stuff.
 *
 * XXX needs logging
 */
public class ArenaOpponentRankSimulator {


  public static void main(String[] args) {
    int waveCount = 13;
    int numPlayers = 10;
    int waveSleepSeconds = 20;
    ArrayList<Player> players = new ArrayList<>();

    System.out.printf("Simulating %d waves with %d players.\n", waveCount, numPlayers);
    System.out.printf("Expect this simulation run to take %3.1f minutes.\n",
        ((waveCount-1)*waveSleepSeconds)/60.0);

    // start Arena's game generator
    ArenaFormat.startGameGenerator();

    // make the players
    Player p;
    String playerName;
    for (int i=0; i<numPlayers; i++) {
      playerName = "opp"+i;
      System.out.println("Creating player: " + playerName);
      p = new Player(1100+10*i, playerName);
      p.addGold(500);
      p.joinArena();
      players.add(p);
    }

    ArenaFormat.printStatus();

    // play a bunch of games
    for (int waveCounter=0; waveCounter<waveCount; waveCounter++) {
      System.out.println("\n(Thread-Main) WAVE #" + waveCounter);
      for (Player pp: players) { pp.playArena(); }
      Sleep.seconds(waveSleepSeconds);
    }

    Sleep.seconds(10);
    for (Player pp: players) { pp.printHistory(); }

    String waveWord = "waves";
    if (waveCount == 1) {  waveWord = "wave"; }
    System.out.printf("\nAfter %d %s:\n", waveCount, waveWord);
    ArenaFormat.printHistory();
    System.exit(1);
  }


}
