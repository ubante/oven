package com.ubante.oven.singleton;

/**
 * Created by J on 10/18/2015.
 */
public class TestSingleton {

  public static void main(String[] args) {
    ClassicSingleton configleton = ClassicSingleton.getInstance();
    System.out.println("\noriginal:");
    configleton.displayState();

    configleton.setConfig1("altered_state");
    System.out.println("\noriginal:");
    configleton.displayState();

    ClassicSingleton dupe = ClassicSingleton.getInstance();
    System.out.println("\nduplicate:");
    dupe.displayState();

    System.out.println("\nWe make a change to the dupe:");
    dupe.setConfig2("changed_dupe");
    System.out.println("\noriginal:");
    configleton.displayState();
    System.out.println("\nduplicate:");
    dupe.displayState();
  }
}
