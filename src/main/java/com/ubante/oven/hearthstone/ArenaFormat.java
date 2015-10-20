package com.ubante.oven.hearthstone;

import java.util.ArrayList;

/**
 * Players can stay in Arena forever which is unique in all the formats.  The other formats have a set stop/start
 * time.  While Arena's start is up to when a Player joins.  And its stop time is once the Player loses 3 times or
 * wins 12 times.  When a Player joins arena, he will get his own ArenaTournament object.
 */
public class ArenaFormat extends AbstractGameFormat {
  public static ArrayList<ArenaTournament> runningTournamentList = new ArrayList<>();

  private ArenaFormat() {
  }

  public static void addTournament(ArenaTournament at) {
    runningTournamentList.add(at);
  }

  public static void printStatus() {
    System.out.println("Arena statuses:");
    System.out.printf("There are %d running arenas.\n", runningTournamentList.size());
  }


}
