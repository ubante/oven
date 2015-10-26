package com.ubante.oven.hearthstone;

import java.util.ArrayList;

/**
 * Players can stay in an ArenaTournament forever which is unique in all the formats.  The other formats have a set
 * stop/start time.  While Arena's start is up to when a Player joins.  And its stop time is once the Player loses 3
 * times or wins 12 times.  When a Player joins arena, he will get his own ArenaTournament object.
 */
public class ArenaFormat {
  public static ArrayList<ArenaTournament> runningTournamentList = new ArrayList<>();
  private static GameGenerator generator = new GameGenerator();
  private static Thread generatorThread;
  private static ArrayList<Game> gameHistory = new ArrayList<>();

  private ArenaFormat() {}

  public static void startGameGenerator() {
    generatorThread = new Thread(generator,"generator");
    generatorThread.start();
  }

  public static void addTournament(ArenaTournament at) {
    runningTournamentList.add(at);
  }

  public static void removeTournament(ArenaTournament at) {
    runningTournamentList.remove(at);
  }

  public static void printStatus() {
    System.out.println("Arena statuses:");
    System.out.printf("There are %d running arenas.\n", runningTournamentList.size());
  }

  public static void addGameToHistory(Game g) {
    gameHistory.add(g);
  }

  public static void printHistory() {
    ArrayList<Player> players = new ArrayList<>();

    System.out.println("\nGAME HISTORY:");
    for (Game g: gameHistory) {
      System.out.printf("Game #%d: %s vs %s --> %s wins\n", g.gameNumber, g.statusStartPlayerA, g.statusStartPlayerB,
          g.winner.playerName);
//      System.out.printf("Game #%d: %s beat %s\n", g.gameNumber, g.winner.playerName, g.loser.playerName);
      if (! players.contains(g.winner)) {
        players.add(g.winner);
      }
      if (! players.contains(g.loser)) {
        players.add(g.loser);
      }
    }

    System.out.println("\nPLAYER RECORDS:");
    for (Player p: players) {
      System.out.println(p.getShortArenaStatus());
    }
  }
}
