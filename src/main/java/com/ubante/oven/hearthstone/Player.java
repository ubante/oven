package com.ubante.oven.hearthstone;

/**
 * Created by J on 10/18/2015.
 */
public class Player {
  double eloRating;
  int goldAmount;
  int dustAmount;
  ArenaTournament arenaTournament = null;

  public Player() {
    eloRating = 1000; // find a library later
    goldAmount = 0;
    dustAmount = 0;
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

  public Player(int rating) {
    eloRating = rating;
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

  public void joinArena() throws YouAreTooPoorException {
    if (goldAmount < ArenaTournament.getGoldCost()) {
      throw new YouAreTooPoorException("You only have " + goldAmount + " gold and you need " +
          ArenaTournament.getGoldCost() + " so no Arena for you.");
    }

    goldAmount -= ArenaTournament.getGoldCost();
    arenaTournament = ArenaTournament.joinTournament(this);

  }
}

