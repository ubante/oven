package com.ubante.oven.poker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by J on 5/3/2014.
 */
public class HandDistribution {
    HashMap<String, Integer> suitCountHash = new HashMap<String, Integer>();
    HashMap<Integer, Integer> valueCountHash = new HashMap<Integer, Integer>();
    int cardCounter = 0;

    void tally(Card c) {
        String suit = c.suit;
        int value = c.value;

        Integer suitCount = suitCountHash.get(suit);
        if (suitCount == null) { suitCount = 0; }
        suitCountHash.put(suit, suitCount+1);

        Integer valueCount = valueCountHash.get(value);
        if (valueCount == null) { valueCount = 0; }
        valueCountHash.put(value, valueCount+1);

        cardCounter++;
    }

    void println() {

        System.out.println("Here are the measurements:");

        for (String suit : suitCountHash.keySet()) {
            System.out.printf("Suit:   %s  Count: %7d  Frequency: %6.2f%%\n",
                    suit,
                    suitCountHash.get(suit),
                    suitCountHash.get(suit)*100.0/cardCounter);
        }

        for (Integer value : valueCountHash.keySet()) {
            System.out.printf("Value: %2d  Count: %7d  Frequency: %6.2f%%\n",
                    value,
                    valueCountHash.get(value),
                    valueCountHash.get(value)*100.0/cardCounter);
        }
    }

    /**
     * Troubleshoot this random card problem
     * @param args none
     */
    public static void main(String[] args) {
        int cardCount = 10000;
        List<Card> cards = new ArrayList<Card>();

        System.out.printf("With %d cards:",cardCount);
        for (int i=0; i<=cardCount; i++) {
            cards.add(Card.getRandom());
        }

        HandDistribution distribution = new HandDistribution();
        for (Card c : cards) {
            distribution.tally(c);
        }
        distribution.println();

        System.out.println("\n\nSecond round:");
        CardStack stack = CardStack.getInstance(100000);
        distribution = new HandDistribution();
        for (Card c : stack.getStack()) {
            distribution.tally(c);
        }
        distribution.println();

    }
}

/**
 * It's random....
 With 10000 cards:Here are the measurements:
 Suit:   D  Count:    2541  Frequency:  25.41%
 Suit:   S  Count:    2564  Frequency:  25.64%
 Suit:   C  Count:    2434  Frequency:  24.34%
 Suit:   H  Count:    2462  Frequency:  24.62%
 Value:  2  Count:     766  Frequency:   7.66%
 Value:  3  Count:     722  Frequency:   7.22%
 Value:  4  Count:     771  Frequency:   7.71%
 Value:  5  Count:     731  Frequency:   7.31%
 Value:  6  Count:     786  Frequency:   7.86%
 Value:  7  Count:     751  Frequency:   7.51%
 Value:  8  Count:     798  Frequency:   7.98%
 Value:  9  Count:     793  Frequency:   7.93%
 Value: 10  Count:     747  Frequency:   7.47%
 Value: 11  Count:     787  Frequency:   7.87%
 Value: 12  Count:     796  Frequency:   7.96%
 Value: 13  Count:     776  Frequency:   7.76%
 Value: 14  Count:     777  Frequency:   7.77%
 */