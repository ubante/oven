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
//
//  public static Game playGame(Player p) {
//
//    // find an opponent
//    try {
//      Thread.sleep(1000);
//    } catch (InterruptedException e) {
//      e.printStackTrace();
//    }
//
//    // play game
//    Game game = new Game(p, p);
//
//    // return results
//    System.out.println("The winner is " + p.playerName);
//
//    game.setWinner(p); // until I figure out the rest
//    return game;
//  }
}
