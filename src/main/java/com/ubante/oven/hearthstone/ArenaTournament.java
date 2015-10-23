package com.ubante.oven.hearthstone;

/**
 * This is the personal arena tournament that each player may have.  A player may have no more than one.
 */
public class ArenaTournament {
  static int goldCost = 150; // Maybe this belongs in ArenaFormat
  public int winCount = 0;
  public int lossCount = 0;
  public int gamesPlayed = 0;
  public Player player;
  Boolean isReadyToPlay = false;
  Boolean isConcluded = false;

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

  private void conclude() {
    isConcluded = true;
    ArenaFormat.removeTournament(this);
    // dole out rewards to player
  }

  public String getStatus() {
    String queueState = "is not in queue";
    if (isReadyToPlay) { queueState = "is in queue"; }
    return String.format("%s %s.  Record is %d/%d.", player.playerName, queueState, winCount, lossCount);
  }

  public void play() {
    isReadyToPlay = true;
    System.out.println(getStatus());
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    Game game = ArenaFormat.playGame(player);

    // record game results
    isReadyToPlay = false;
    gamesPlayed++;
    if (game.getWinner().equals(player)) {
      winCount++;
    } else {
      lossCount++;
    }

    // this may belong in ArenaFormat
    if ((winCount == 12) || (lossCount == 3)) {
      conclude();
    }
  }
}
