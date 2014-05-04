package com.ubante.oven.poker;

import java.util.Arrays;

/**
 * Created by J on 5/2/2014.
 */
public class Flop extends Hand {
    int handsize = 3;
    Card[] list = new Card[handsize];

    Flop(Card a, Card b, Card c) {
        list[0] = a;
        list[1] = b;
        list[2] = c;
        for (int i=0; i<handsize; i++) {
            listValues[i] = list[i].value;
            Integer value = listValues[i];
            Integer frequency = valueFrequency.get(value);
            if (frequency == null) { frequency=0; }
            valueFrequency.put(value, frequency + 1);
        }
        Arrays.sort(listValues);
    }

    Flop() {
        this(Card.getRandom(), Card.getRandom(), Card.getRandom());
    }

    void println() {
        System.out.print("This hand is: ");
        for (int i=0; i<handsize; i++) {
            System.out.printf("%3s ", list[i].toString());
        }
        System.out.println();
    }

    /**
     * Test main
     * @param args
     */
    public static void main(String[] args) {

        System.out.println("\nHere's a sample starting hand:");
        Hole sh = new Hole();
        sh.println();

        System.out.println("Here's a sample flop:");
        Flop f = new Flop();
        f.println();

        System.out.println("Combined hand:");
        Hand combinedHand = Hand.joinStartingHandWithFlop(sh, f);
        combinedHand.println();

        String whatyouhave = combinedHand.evaluate();
        System.out.println("\nYou have: "+whatyouhave);

    }
}
