package com.ubante.oven.hearthstone;

/**
 * Created by J on 10/18/2015.
 */
public class Player {
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
      status += "You are in an arena tournament with a record of XW andYL\n";
    }

    return status;
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
    arenaTournament.play();
    if (arenaTournament.isConcluded) { arenaTournament = null; }
  }
}

