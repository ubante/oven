package com.ubante.oven.hearthstone2;

/**
 * Created by J on 10/18/2015.
 */
public class IndependentPlayer implements Runnable {
  double eloRating;
  String playerName;
  ArenaTournament arenaTournament = null;
  int maxSeconds = 20;

  public IndependentPlayer(String name) {
    this(1000, name);
  }

  public IndependentPlayer(int rating, String name) {
    eloRating = rating;
    playerName = name;
  }

  void pprint(String s) {
    System.out.printf("Thread %s: %s\n", playerName, s);
  }

  @Override
  public void run() {
    pprint("beginning");
    arenaTournament = ArenaTournament.joinTournament(this);

    for (int i=1; i<=10; i++) {
      int ms = (int) (Math.random() * 1000 * maxSeconds);

      pprint("entering game #" + i);

      try {
        Thread.sleep(ms);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }

    }
  }

}

