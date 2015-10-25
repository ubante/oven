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
    ArenaFormat.printStatus();
    me.joinArena();
    me.printStatus();
    ArenaFormat.printStatus();

    Player opp1 = new Player(1100,"opp1");
    opp1.addGold(200);
    opp1.joinArena();

    Player opp2 = new Player(1300,"opp2");
    opp2.addGold(200);
    opp2.joinArena();

    ArenaFormat.printStatus();
    opp1.playArena();
    opp2.playArena();
    me.playArena();

    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    me.playArena();
  }


}
