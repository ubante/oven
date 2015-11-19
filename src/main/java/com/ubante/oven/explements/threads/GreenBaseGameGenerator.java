package com.ubante.oven.explements.threads;

import java.util.concurrent.TimeUnit;

/**
 * Created by J on 11/18/2015.
 */
public class GreenBaseGameGenerator extends BaseGameGenerator {

  @Override
  public void run() {
    System.out.println("GG: waiting for player in gameQueue.");
    BasePlayer bp = null;

    try {
      bp = playerQueue.poll(10000, TimeUnit.MILLISECONDS);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    System.out.printf("GG: found %s in queue.\n", bp.getName());


  }
}
