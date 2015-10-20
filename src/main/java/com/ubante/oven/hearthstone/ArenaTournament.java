package com.ubante.oven.hearthstone;

/**
 * Created by J on 10/19/2015.
 */
public class ArenaTournament {
  static int goldCost = 150;
  public int winCount = 0;
  public int lossCount = 0;
  public int gamesPlayed = 0;
  public Player player;

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
    System.out.println("man I love playing thes arenas");
  }
}
