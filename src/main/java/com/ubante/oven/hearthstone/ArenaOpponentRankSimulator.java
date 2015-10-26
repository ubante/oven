package com.ubante.oven.hearthstone;

/**
 * Assuming a normal distribution of player Elo rating, how will a given player do.
 *
 * Add some random stuff.
 *
 * XXX needs logging
 */
public class ArenaOpponentRankSimulator {


  public static void main(String[] args) {

    // start Arena's game generator
    ArenaFormat.startGameGenerator();

    Player me = new Player(1200);
    me.addGold(500);
    me.printStatus();
    me.joinArena();
    me.printStatus();

    Player opp1 = new Player(1100,"opp1");
    opp1.addGold(200);
    opp1.joinArena();

    Player opp2 = new Player(1250,"opp2");
    opp2.addGold(200);
    opp2.joinArena();

    Player opp3 = new Player(1150,"opp3");
    opp3.addGold(200);
    opp3.joinArena();
    ArenaFormat.printStatus();

    // play a bunch of games
    int waveCount = 3;
    for (int i=1; i<=waveCount; i++) {
      System.out.println("\n(Thread-Main) Wave #" + i);
      opp1.playArena();
      opp2.playArena();
      opp3.playArena();
      me.playArena();
      Sleep.seconds(20);
    }

    Sleep.seconds(10);

    opp1.printHistory();
    opp2.printHistory();
    opp3.printHistory();
    me.printHistory();

    System.out.printf("\nAfter %d waves:\n", waveCount);
    ArenaFormat.printHistory();
    System.exit(1);
  }


}
