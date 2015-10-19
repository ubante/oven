package com.ubante.oven.hearthstone;

/**
 * Players can stay in Arena forever which is unique in all the formats.  The other formats have a set stop/start
 * time.  While Arena's start is up to when a Player joins.  And its stop time is once the Player loses 3 times or
 * wins 12 times.  When a Player joins arena, he will get his own ArenaTournament object.
 */
public class ArenaFormat extends AbstractGameFormat {

  private ArenaFormat() {
  }
//
//  public static ArenaFormat joinTournament(Player p) {
//    ArenaFormat arenaFormat = new ArenaFormat();
//    return arenaFormat;
//  }
}
