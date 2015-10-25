package com.ubante.oven.hearthstone;

/**
 * Created by J on 10/18/2015.
 */
public class Player implements Runnable {
  double eloRating;
  int goldAmount = 0;
  int dustAmount = 0;
  ArenaTournament arenaTournament = null;
  String playerName;

  public Player() {
    this(1000); // find a library later
  }

  public Player(int rating) {
    this(rating, "Elmo");
  }

  public Player(int rating, String name) {
    eloRating = rating;
    playerName = name;
  }

  public String getStatus() {
    String status = "This is your status:" +
        "\nElo rating: " + eloRating +
        "\nGold: " + goldAmount +
        "\nDust: " + dustAmount +
        "\n";
    if (arenaTournament != null) {
      status += String.format("You are in an arena tournament with a record of %d wins and %d losses\n",
          arenaTournament.winCount, arenaTournament.lossCount);
    }

    return status;
  }

  public String getShortArenaStatus() {
    String shortArenaStatus;
    if (arenaTournament != null) {
      shortArenaStatus = String.format("%s(%4.0f-%d-%d)", playerName, eloRating, arenaTournament.winCount,
          arenaTournament.lossCount);
    } else {
      shortArenaStatus = String.format("%s(%4.0f)", playerName, eloRating);
    }
    return shortArenaStatus;
  }

  public int getGoldAmount() {
    return goldAmount;
  }

  public void printStatus() {
    System.out.println(getStatus());
  }

  public double getEloRating() {
    return eloRating;
  }

  public void setEloRating(double eloRating) {
    this.eloRating = eloRating;
  }

  public void increaseEloRating(double opponentEloRating) {
    // my creation
    eloRating = eloRating + (Math.abs(eloRating - opponentEloRating)/3);
  }

  public void decreaseEloRating(double opponentEloRating) {
    // my creation
    eloRating = eloRating - (Math.abs(eloRating - opponentEloRating)/3);
  }

  public void addGold(int g) {
    goldAmount += g;
  }

  // throwing exceptions is ludicrous
  public void joinArena() {
    if (goldAmount < ArenaTournament.getGoldCost()) {
//      throw new YouAreTooPoorException("You only have " + goldAmount + " gold and you need " +
//          ArenaTournament.getGoldCost() + " so no Arena for you.");
      System.out.println("You need more gold.");
      System.exit(1);
    }

    if (arenaTournament != null) {
//      throw new AlreadyPlayingArenaException();
      return;
    }

    goldAmount -= ArenaTournament.getGoldCost();
    arenaTournament = ArenaTournament.joinTournament(this);
  }

  public void playArena() {

    new Thread(this, playerName).start();
    if (arenaTournament.isConcluded) { arenaTournament = null; }
  }

  @Override
  public void run() {
    // to prevent queueing for two games simultaneously
    if (arenaTournament.isReadyToPlay.equals(false)) {
      arenaTournament.play();
    }
  }
}

