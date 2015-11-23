package com.ubante.oven.explements;

/**
 * What happens if I use a super method to change a local field that overrrides the super's
 * field?
 */
public class Arugula extends RabbitFood {

  public int counter = 15;

  public static void main(String[] args) {
    Arugula a = new Arugula();
    a.go();

  }
}
