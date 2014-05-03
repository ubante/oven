package com.ubante.oven.poker;

import java.util.HashMap;

/**
 * Created by J on 5/3/2014.
 */
public class HandStatistics {
    HashMap<String, Integer> suitCountHash = new HashMap<String, Integer>();
    HashMap<Integer, Integer> valueCountHash = new HashMap<Integer, Integer>();
    int cardCounter = 0;

    HandStatistics(HashMap<String, Integer> suitCount,
                   HashMap<Integer, Integer> valueCount) {
        this.suitCountHash = suitCount;
        this.valueCountHash = valueCount;
    }

    HandStatistics() {}

    void measure(Hand h) {
        Integer suitCount, valueCount;

        // Loop through the cards in the hand and increment the two hashes.
        for (Card c : h.list) {
            String suit = c.suit;
            int value = c.value;

            suitCount = suitCountHash.get(suit);
            if (suitCount == null) { suitCount = 0; }
            suitCountHash.put(suit, suitCount+1);

            valueCount = valueCountHash.get(value);
            if (valueCount == null) { valueCount = 0; }
            valueCountHash.put(value, valueCount+1);

            cardCounter++;
        }
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


    public static void main(String[] args) {
        Hand testHand = new Hand(
                new Card("S",4),
                new Card("S",5),
                new Card("S",11),
                new Card("S",10),
                new Card("S",2));

        HandStatistics stats = new HandStatistics();
        stats.measure(testHand);
        stats.println();
        System.out.println();

        testHand = new Hand(
                new Card("S",5),
                new Card("S",6),
                new Card("S",9),
                new Card("S",8),
                new Card("S",7));
        stats.measure(testHand);
        stats.println();
        System.out.println();
    }


}
