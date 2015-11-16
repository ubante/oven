package com.ubante.oven.hearthstone.hearthstonebad;

import com.ubante.oven.hearthstone.arena.ArenaPlayer;

/**
 * This is the personal arena tournament that each player may have.  A player may have no more than one.
 */
public class ArenaTournament {
  static int goldCost = 150; // Maybe this belongs in ArenaFormat
  public int winCount = 0;
  public int lossCount = 0;
  public int gamesPlayed = 0;
  public Player player;
  ArenaPlayer arenaPlayer;
  Boolean isReadyToPlay = false;
  Boolean isConcluded = false;
  Game game = null;

  public ArenaTournament(Player p) {
    player = p;
  }

  public ArenaTournament(ArenaPlayer ip) {
    arenaPlayer = ip;
  }

  public static int getGoldCost() {
    return goldCost;
  }

  public static ArenaTournament joinTournament(Player p) {
    ArenaTournament arenaTournament = new ArenaTournament(p);
    ArenaFormat.addTournament(arenaTournament);

    return arenaTournament;
  }

  public static ArenaTournament joinTournament(ArenaPlayer ip) {
    ArenaTournament arenaTournament = new ArenaTournament(ip);
    ArenaFormat.addTournament(arenaTournament);

    return arenaTournament;
  }

  private void conclude() {
    System.out.println(player.playerName + " has concluded its tournament.");
    isConcluded = true;
//    ArenaFormat.removeTournament(this); // this line was causing the ConcurrentModificationException in the
    // GameGenerator thread, instead do do some checking in that thread

    // XXX dole out rewards to player
  }

  public String getStatus() {
    String queueState = "is not in queue";
    if (isReadyToPlay) { queueState = "is in queue"; }
    return String.format("%s %s.  Record is %d/%d.", player.playerName, queueState, winCount, lossCount);
  }

  public void play() {
    isReadyToPlay = true;

    while (game == null) {
      System.out.printf("(Thread-%s) is waiting to play Arena game #%d\n", player.getShortArenaStatus(), gamesPlayed+1);
      try {
        Thread.sleep(900);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }

    // record game results
    gamesPlayed++;
    player.history.add(game);
    if (game.getWinner().equals(player)) {
      winCount++;
    } else {
      lossCount++;
    }
    game = null;
//    System.out.printf("Game #%d: %s played %s and the winner is %s\n", game.getGameNumber(), player.playerName,
//        game.getOpponent(player).playerName, game.getWinner().playerName);

    System.out.printf("=> Result: %s\n", player.getShortArenaStatus());

    // this may belong in ArenaFormat
    if ((winCount == 12) || (lossCount == 3)) {
      conclude();
    }
  }
}
