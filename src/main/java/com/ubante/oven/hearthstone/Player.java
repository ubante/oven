package com.ubante.oven.hearthstone;

/**
 * Created by J on 10/18/2015.
 */
public class Player implements Runnable {
  double eloRating;
  int starRating = 0;
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
      shortArenaStatus = String.format("%s(%d-%4.0f-%d-%d)", playerName, starRating, eloRating,
          arenaTournament.winCount, arenaTournament.lossCount);
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

  public int getStarRating() {
    return starRating;
  }

  public void increaseEloRating(double opponentEloRating) {
    // my creation
    eloRating = eloRating + (Math.abs(eloRating - opponentEloRating)/10);

    starRating++;
  }

  public void decreaseEloRating(double opponentEloRating) {
    // my creation
    eloRating = eloRating - (Math.abs(eloRating - opponentEloRating)/10);

    if (starRating > 10) {
      starRating--;
    }
  }

  public void addGold(int g) {
    goldAmount += g;
  }

  public void joinArena() {
    if (goldAmount < ArenaTournament.getGoldCost()) {
      System.out.println("You need more gold.");
      System.exit(1);
    }

    if (arenaTournament != null) {
      System.err.println("You already have an active Arena Tournament.");
      return;
    }

    goldAmount -= ArenaTournament.getGoldCost();
    arenaTournament = ArenaTournament.joinTournament(this);
  }

  public void playArena() {

    if (arenaTournament == null) {
      System.out.println(playerName + " cannot play a game since its tournament is concluded.");
      return;
    }

    if (arenaTournament.isReadyToPlay) {
      System.err.println(playerName + " is already waiting to play a game.");
      return;
    }

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

