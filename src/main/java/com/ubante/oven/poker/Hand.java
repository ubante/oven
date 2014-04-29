package com.ubante.oven.poker;


import java.util.Arrays;

/**
 * Created by J on 4/29/2014.
 */
public class Hand {
    int handsize = 5;
    Card[] list = new Card[handsize];
    int[] listValues = new int[handsize];

    Hand() {
        for (int i=0; i<handsize; i++) {
            list[i] = Card.getRandom();
            listValues[i] = list[i].value;
        }
        Arrays.sort(listValues);
    }

    Hand(Card a, Card b, Card c, Card d, Card e) {
        list[0] = a;
        list[1] = b;
        list[2] = c;
        list[3] = d;
        list[4] = e;
        for (int i=0; i<handsize; i++) {
            listValues[i] = list[i].value;
        }
        Arrays.sort(listValues);
    }

    void print() {
        System.out.print("This hand is: ");
        for (int i=0; i<handsize; i++) {
            System.out.printf("%3s ", list[i].toString());
        }
        System.out.println();
    }

    boolean isFlush() {
        String suit = list[0].suit;
        boolean flushResults = true;

        for (int i=1; i<handsize; i++) {
            if (! list[i].suit.equals(suit)) {
                flushResults = false;
                break;
            }
        }

        return flushResults;
    }

    boolean isStraight() {
        boolean straightResults = true;

        for (int i=1; i<handsize; i++) {
            if (listValues[i] - listValues[i-1] != 1) {
                straightResults = false;
                break;
            }
        }

        return straightResults;
    }

    String evaluate() {
        String results = "unknown";

        // There are 9 poker hands

        // Flushes (2 kinds)
        if (isFlush()) {
            if (isStraight()) {
                results = "straight flush";
            } else {
                results = "flush";
            }
        }

        return results;
    }


    public static void main(String[] args) {
        Hand h = new Hand();

        for (int i=0; i<100; i++) {
            h = new Hand();
            System.out.printf("%20s: ", h.evaluate());
            h.print();
        }

        System.out.println("\nTesting a flush");
        h = new Hand(
                new Card("S",4),
                new Card("S",4),
                new Card("S",4),
                new Card("S",4),
                new Card("S",4));
        System.out.printf("%20s: ", h.evaluate());
        h.print();

        System.out.println("\nTesting a straight flush");
        h = new Hand(
                new Card("S",5),
                new Card("S",6),
                new Card("S",9),
                new Card("S",8),
                new Card("S",7));
        System.out.printf("%20s: ", h.evaluate());
        h.print();


    }
}
