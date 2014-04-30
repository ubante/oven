package com.ubante.oven.poker;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by J on 4/29/2014.
 */
public class Hand {
    int handsize = 5;
    Card[] list = new Card[handsize];
    int[] listValues = new int[handsize];
    HashMap<Integer,Integer> valueFrequency = new HashMap<Integer,Integer>();

    /**
     * Constructors
     */
    Hand(Card a, Card b, Card c, Card d, Card e) {
        list[0] = a;
        list[1] = b;
        list[2] = c;
        list[3] = d;
        list[4] = e;
        for (int i=0; i<handsize; i++) {
            listValues[i] = list[i].value;
            Integer value = listValues[i];
            Integer frequency = valueFrequency.get(value);
            if (frequency == null) { frequency=0; }
            valueFrequency.put(value, frequency + 1);
        }
        Arrays.sort(listValues);
    }

    Hand() {
        this(Card.getRandom(),Card.getRandom(),Card.getRandom(),
                Card.getRandom(),Card.getRandom());
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

    String evaluateFrequency() {
        String result = "none";

        // Four-of-a-kind (4-1,5) or full house (2-3,3-2)
        // A five-of-a-kind is possible but Texas Hold 'em treats them like
        // four-of-a-kind.
        if (valueFrequency.size() <= 2) {
            Map.Entry<Integer, Integer> anEntry =
                    valueFrequency.entrySet().iterator().next();
            Integer frequency = anEntry.getValue();
            if (frequency == 2 || frequency == 3) {
                result = "full house";
            } else {
                result = "four-of-a-kind";
            }
            return result;
        }

        // Three-of-a-kind (1-1-3,1-3-1,3-1-1) or two pairs (1-2-2,2-1-2,2-2-1)
        if (valueFrequency.size() == 3) {
            for (Map.Entry entry : valueFrequency.entrySet()) {
                if (entry.getValue() == new Integer(3)) { return "three-of-a-kind"; }
                if (entry.getValue() == new Integer(2)) { return "two pairs"; }
            }
        }

        if (valueFrequency.size() == 4) { return "pair"; }
        if (valueFrequency.size() == 5) { return "high card"; }

        return result;
    }

    boolean hasFourOfaKind() {
        if (valueFrequency.size()>2) {
            return false;
        } else {
            return true;
        }
    }

    boolean hasThreeOfaKind() {
        if (valueFrequency.size()>3) {
            return false;
        } else {
            return true;
        }
    }

    String evaluate() {
        String result = "unknown";

        // There are 9 poker hands
        // Flushes (2 kinds)
        if (isFlush()) {
            if (isStraight()) {
                result = "straight flush";
            } else {
                result = "flush";
            }
            return result;
        }

        // Four-of-a-kind, full house, three-of-a-kind, two pairs, pair
        String resultFrequency = evaluateFrequency();
        if (!resultFrequency.equals("none")) { return resultFrequency; }

        // Straight

        // High card

        // Hopefully, nuke the below
        // Four-of-a-kind
        if (hasFourOfaKind()) { return "four-of-a-kind"; }

        // Full house

        // Three-of-a-kind
        if (hasThreeOfaKind()) { return "three-of-a-kind"; }


        return result;
    }


    public static void main(String[] args) {
        Hand h;

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

        System.out.println("\nTesting a four-of-a-kind");
        h = new Hand(
                new Card("S",3),
                new Card("C",6),
                new Card("D",3),
                new Card("S",3),
                new Card("H",3));
        System.out.printf("%20s: ", h.evaluate());
        h.print();

        System.out.println("\nTesting a full house");
        h = new Hand(
                new Card("S",3),
                new Card("C",6),
                new Card("D",3),
                new Card("S",6),
                new Card("H",3));
        System.out.printf("%20s: ", h.evaluate());
        h.print();

        System.out.println("\nTesting a three-of-a-kind");
        h = new Hand(
                new Card("S",3),
                new Card("C",6),
                new Card("D",3),
                new Card("S",2),
                new Card("H",3));
        System.out.printf("%20s: ", h.evaluate());
        h.print();
    }
}
