package com.ubante.oven.hearthstone;

/**
 * Assuming a normal distribution of player Elo rating, how will a given player do.
 *
 * Add some random stuff.
 */
public class ArenaOpponentRankSimulator {


  public static void main(String[] args) {
    Player me = new Player(1200);
    me.addGold(500);
    me.printStatus();
    ArenaFormat.printStatus();

    try {
      me.joinArena();
    } catch (YouAreTooPoorException yatpe) {
      System.out.println("You are too poor to play arena.");
      System.out.println("You only have " + me.getGoldAmount() + " gold and you need " +
          ArenaTournament.getGoldCost() + " so no Arena for you.");
//      yatpe.printStackTrace();
    } catch (AlreadyPlayingArenaException e) {
//      e.printStackTrace();
      System.out.println("You are already playing an arena");
    }

    me.printStatus();
    ArenaFormat.printStatus();

    Player opp1 = new Player(1100,"opp1");
    opp1.addGold(200);
    Player opp2 = new Player(1300,"opp2");
    opp2.addGold(200);
    try {
      opp1.joinArena();
      opp2.joinArena();
    } catch (YouAreTooPoorException | AlreadyPlayingArenaException e) {
      e.printStackTrace();
    }

    ArenaFormat.printStatus();
    opp1.playArena();
    opp2.playArena();
    me.playArena();
  }


}
