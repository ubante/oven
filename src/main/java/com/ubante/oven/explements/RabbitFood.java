package com.ubante.oven.explements;

/**
 * Created by J on 11/15/2015.
 */
public class RabbitFood implements Eatable {

  public int counter = 5;

  void go() {
    System.out.println("Counter is: " + counter);
    counter++;
    System.out.println("Counter is: " + counter);

  }
  public void cook() {}

}
