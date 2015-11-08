package com.ubante.oven.hearthstone;

/**
 * Created by J on 11/5/2015.
 */
public class ArenaTournament {
  public IndependentPlayer player;
  Boolean isReadyToPlay = false;
  public int winCount = 0;
  public int lossCount = 0;
  public int gamesPlayed = 0;

  public ArenaTournament(IndependentPlayer ip) {
    player = ip;
  }

  public static ArenaTournament joinTournament(IndependentPlayer ip) {
    ArenaTournament arenaTournament = new ArenaTournament(ip);
    ArenaFormat.addTournament(arenaTournament);

    return arenaTournament;
  }


}
