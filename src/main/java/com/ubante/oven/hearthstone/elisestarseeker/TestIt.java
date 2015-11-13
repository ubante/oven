package com.ubante.oven.hearthstone.elisestarseeker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

/**
 * How good is she?
 *
 * Elise Starseeker: 4cost, shuffle "Map to the Golden Monkey" into your deck
 * Map: 2 cost, shuffle Golden Monkey into your deck
 * Golden Monkey: win
 *
 * Results:
 * After      10 iterations, we have an average of 28.40 cards to find the Monkey.
 * After     100 iterations, we have an average of 28.34 cards to find the Monkey.
 * After    1000 iterations, we have an average of 28.38 cards to find the Monkey.
 * After   10000 iterations, we have an average of 28.41 cards to find the Monkey.
 * After  100000 iterations, we have an average of 28.43 cards to find the Monkey.
 * After 1000000 iterations, we have an average of 28.42 cards to find the Monkey.
 */
public class TestIt {
  int iterations;
  ArrayList<Integer> results = new ArrayList<>();
  int total = 0;

  public void setIterations(int iterations) {
    this.iterations = iterations;
  }

  void run() {
    for (int i = 0; i<iterations; i++) {
      String name;

      // make a deck with Elise
      Stack deck = new Stack();
      deck.push("Elise");
      while (deck.size()<30) {
        deck.push("filler");
      }
      Collections.shuffle(deck);

      // draw until you get Elise
//      System.out.println("Popping for Elise...");
      int counter = 0;
      do {
        counter++;
//        System.out.printf("%d ", counter);
        name = (String) deck.pop();
      } while (! name.equals("Elise"));
//      System.out.println("Found Elise\n");

      // handle the case of when you cannot yet cast Elise
      while (counter<4) {
        counter++;
        deck.pop();
      }

      // shuffle Map into the deck
      deck.push("Map");
      Collections.shuffle(deck);

      // draw until you get Map
//      System.out.println("Popping for Map...");
      do {
        counter++;
//        System.out.printf("%d ", counter);
        name = (String) deck.pop();
      } while (! name.equals("Map"));
//      System.out.println("Found Map\n");

      // shuffle Monkey into the deck
      deck.push("Monkey");
      Collections.shuffle(deck);

      // draw until you get Monkey
//      System.out.println("Popping for Monkey...");
      do {
        counter++;
//        System.out.printf("%d ", counter);
        name = (String) deck.pop();
      } while (! name.equals("Monkey"));
//      System.out.println("Found Monkey\n");

      System.out.printf("Took you %d cards to find the Monkey.\n", counter);
      results.add(counter);
      total += counter;
    }
  }

  void compute() {
    System.out.printf("\nAfter %7d iterations, we have an average of %4.2f cards to find the Monkey.\n",
        iterations, (float) total/iterations);
  }

  public static void main(String[] args) {

    TestIt t = new TestIt();
    t.setIterations(1000000);
    t.run();
    t.compute();

  }

}
