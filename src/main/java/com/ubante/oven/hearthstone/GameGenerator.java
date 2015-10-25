package com.ubante.oven.hearthstone;

/**
 * Created by J on 10/23/2015.
 */
public class GameGenerator implements Runnable {

  @Override
  public void run() {

    while (true) {
      System.out.println("----> looking for players");

      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
