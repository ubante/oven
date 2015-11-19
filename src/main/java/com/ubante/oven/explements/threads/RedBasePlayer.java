package com.ubante.oven.explements.threads;

/**
 * Created by J on 11/18/2015.
 */
public class RedBasePlayer extends BasePlayer {

  public String getSpecialSauce() { return "Tampico"; }

  @Override
  public void run() {
    System.out.println("PP: putting player into gameQueue.");

    try {
      playerQueue.put(this);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    System.out.println("PP: player is inside gameQueue.");
  }
}


