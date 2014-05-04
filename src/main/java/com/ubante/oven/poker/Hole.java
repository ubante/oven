package com.ubante.oven.poker;


import java.util.Arrays;

/**
 * Created by J on 5/1/2014.
 */
public class Hole extends Hand {
    int handsize = 2;
    Card[] list = new Card[handsize];

    Hole(Card a, Card b) {
        list[0] = a;
        list[1] = b;
        for (int i=0; i<handsize; i++) {
            listValues[i] = list[i].value;
            Integer value = listValues[i];
            Integer frequency = valueFrequency.get(value);
            if (frequency == null) { frequency=0; }
            valueFrequency.put(value, frequency + 1);
        }
        Arrays.sort(listValues);
    }

    Hole() {
        this(Card.getRandom(), Card.getRandom());
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
     * @param args none
     */
    public static void main(String[] args) {
        System.out.println("Here's a random starting hand:");
        Hole sh = new Hole();
        sh.println();

        System.out.println("Here's a great starting hand:");
        sh = new Hole(
                new Card("S",13),
                new Card("C",12)
        );
        sh.println();
    }
}
