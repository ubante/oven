package com.ubante.oven.hearthstone.renojackson;

import com.ubante.oven.hearthstone.common.Card;
import com.ubante.oven.hearthstone.common.Deck;

/**
 * Reno Jackson: Battlecry: If your deck contains no more than 1 of any card, fully heal your hero.
 *
 * Find the odds of a "satisfactory deck" given N pairs of cards.
 */
public class OddsFinder {
  int numberOfPairs;
  int iterations;

  OddsFinder(int n, int i) {
    // assuming numberOfPairs is below 15 just because
    numberOfPairs = n;
    iterations = i;
  }

  void findOdds() {
    int totalCardsDrawn = 0;

    for (int i=1; i<=iterations; i++) {
      int result = simulateOnce();
      totalCardsDrawn += result;
//      System.out.printf("Run %3d: took %2d cards\n", i, result);
    }

    System.out.printf("With %d pairs and after %4d runs, it took an average of %4.1f cards to play Jackson with kicker.\n",
        numberOfPairs, iterations, (float) totalCardsDrawn/iterations);
  }

  int simulateOnce() {
    // make a deck
    Deck deck = new Deck();
    deck.addCard(new Card("Jackson"));

    for(int i=1; i<=numberOfPairs; i++) {
      deck.addCardPair(new Card(String.valueOf(i)));
    }
//    System.out.println("Here's the starting deck:");
//    System.out.println(deck);
    deck.fillWithFiller();
//    System.out.println("Again with filler:");
//    System.out.println(deck);
    deck.shuffle();
//    System.out.println("And shuffled:");
//    System.out.println(deck);

    // draw until Jackson
    Card drawnCard;
    int drawnCardCounter = 0;
    do {
      drawnCard = deck.draw();
      drawnCardCounter++;
    } while (drawnCard.getName() != "Jackson");
//    System.out.printf("Found Jackson after drawing %d cards.\n", drawnCardCounter);

    // draw until no pairs exist in remaining deck
    int cardsDrawnUntilNoPairs = 0;
    while (deck.hasDuplicateCards()) {
      deck.draw();
      cardsDrawnUntilNoPairs++;
    }
//    System.out.printf("Had to draw %d cards until there were no pairs left in the deck.\n", cardsDrawnUntilNoPairs);

    return drawnCardCounter + cardsDrawnUntilNoPairs;
  }

  public static void main(String[] args) {

    for (int pairs=0; pairs<10; pairs++) {
      OddsFinder of;
//      of = new OddsFinder(pairs, 10);
//    System.out.printf("Finding how long it would take to play Reno Jackson with a deck that has %d pairs.\n", pairs);
//      of.findOdds();
//      of = new OddsFinder(pairs, 100);
//      of.findOdds();
      of = new OddsFinder(pairs, 10000);
      of.findOdds();
//      System.out.println();
    }
  }
}
