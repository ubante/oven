package com.ubante.oven.hearthstone.hearthstonebad;

/**
 * Annoyed by try/catch blocks.  XXX must be a better way.
 */
public class Sleep {
  public static void sleep() {
    try {
      Thread.sleep(500);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public static void sleep(int sleepMillisecconds) {
    try {
      Thread.sleep(sleepMillisecconds);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public static void seconds(int seconds) {
    try {
      Thread.sleep(seconds * 1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
