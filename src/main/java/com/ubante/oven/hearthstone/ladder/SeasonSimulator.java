package com.ubante.oven.hearthstone.ladder;

/**
 * We will simulate a full season of ladder.
 */
public class SeasonSimulator {
  int playerCount;

  SeasonSimulator(int count) {
    playerCount = count;

    for (int i=1; i<=playerCount; i++) {
      String name = "ip" + i;
//      LadderPlayer ip = new LadderPlayer(name);
//      ip.setGameQueue(gameQueue);
//      ip.setPlayerQueue(playerQueue);
//      players.add(ip);
    }
  }

  void begin(int pollDelay) {
  }

  public static void main(String[] args) {
    int playerCount = 5;
    int pollDelay = 60; // in seconds

    System.out.printf("Starting %d player threads.\n\n", playerCount);

    SeasonSimulator ss = new SeasonSimulator(playerCount);
    ss.begin(pollDelay);
  }
}
