package com.ubante.oven.singleton;

/**
 * Created by J on 10/18/2015.
 */
public class TestSingleton {

  public static void main(String[] args) {
    ClassicSingleton configleton = ClassicSingleton.getInstance();
    configleton.displayState();

    configleton.setConfig1("altered_state");
    configleton.displayState();

    ClassicSingleton dupe = ClassicSingleton.getInstance();
    dupe.displayState();
  }
}
