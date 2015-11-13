package com.ubante.oven.hearthstone.hearthstonebad;

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
  private static ArrayList<Game> gameHistoryLocal = new ArrayList<>();
  private static GameHistory gameHistory = new GameHistory();
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
    gameHistoryLocal.add(g);
    gameHistory.add(g);
  }

  public static void printHistory() {
    ArrayList<Player> players = new ArrayList<>();

    System.out.println("\nGAME HISTORY:");
    gameHistory.printHistory();

    System.out.println("\nPLAYER RECORDS:");
    for (Player p: gameHistory.players) {
      System.out.println(p.getShortArenaStatus());
    }
  }
}
