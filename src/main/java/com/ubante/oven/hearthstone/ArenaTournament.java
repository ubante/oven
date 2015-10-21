package com.ubante.oven.hearthstone;

/**
 * This is the personal arena tournament that each player may have.  A player may have no more than one.
 */
public class ArenaTournament {
  static int goldCost = 150;
  public int winCount = 0;
  public int lossCount = 0;
  public int gamesPlayed = 0;
  public Player player;
  Boolean isReadyToPlay = false;

  public ArenaTournament(Player p) {
    player = p;
  }

  public static int getGoldCost() {
    return goldCost;
  }

  public static ArenaTournament joinTournament(Player p) {
    ArenaTournament arenaTournament = new ArenaTournament(p);
    ArenaFormat.addTournament(arenaTournament);

    return arenaTournament;
  }

  public void play() {
    System.out.println(player.playerName + " loves playing thes areners");
    isReadyToPlay = true;
    Game game = ArenaFormat.playGame(player);

    // record game results
  }
}
