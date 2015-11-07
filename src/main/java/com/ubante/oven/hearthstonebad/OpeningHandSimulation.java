package com.ubante.oven.hearthstonebad;

/**
 * How often can I expect to get card X in my opening hand?  After mulliganning?  Playing second?
 *
 * Could do this with math: 7 chances to draw one of two cards in a set of 30 cards.  7/15 = 46.7%
 * But we're playing a game here.
 *
 * Some results:
 After 1000000 iterations:
 When you play first: 36.6%
 When you play first: 46.8%

 After 1000000000 iterations:
 When you play first: 36.6%
 When you play first: 46.9%

 */
public class OpeningHandSimulation {
  boolean isPlayingFirst;
  int openingHandSize;
  int samples;
  Deck deck;
  Card specialCard;

  OpeningHandSimulation(int s, boolean f) {
    samples = s;
    isPlayingFirst = f;
    if (isPlayingFirst) {
      openingHandSize = 3;
    } else {
      openingHandSize = 4;
    }

    specialCard = new Card("99");
  }

  void initializeDeck() {
    deck = new Deck();
    deck.addCard(specialCard);
    deck.createRandomTwoDeck();
    deck.shuffle();
  }

  float run() {
    int goodOpeningHandCount = 0;

    for (int j=0; j<samples; j++) {
      Hand hand = new Hand();
      initializeDeck();
      for (int i = 0; i < openingHandSize; i++) {
        hand.add(deck.draw());
      }
      if (hand.containsCard(specialCard)) {
        goodOpeningHandCount++;
      } else {
        hand.clear();
        for (int i = 0; i < openingHandSize; i++) {
          hand.add(deck.draw());
        }
        if (hand.containsCard(specialCard)) {
          goodOpeningHandCount++;
        } else {
//          System.out.println("No love");
        }
      }
    }

    return 100 * (float) goodOpeningHandCount/samples;
  }


  public static void main(String[] args) {
    int iterations = 1000000000;

    System.out.printf("After %d iterations:\n", iterations);

    OpeningHandSimulation playingFirst = new OpeningHandSimulation(iterations, true);
    System.out.printf("When you play first: %2.1f%%\n", playingFirst.run());

    OpeningHandSimulation playingSecond = new OpeningHandSimulation(iterations, false);
    System.out.printf("When you play first: %2.1f%%\n", playingSecond.run());

  }
}
