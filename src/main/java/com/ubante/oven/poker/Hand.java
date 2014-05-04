package com.ubante.oven.poker;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.ArrayUtils;

/**
 * Created by J on 4/29/2014.
 */
public class Hand {
    int handsize = 5;
    Card[] list = new Card[handsize];
    int[] listValues = new int[handsize];
    HashMap<Integer, Integer> valueFrequency = new HashMap<Integer, Integer>();

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
    }

    void println() {
        print();
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
        // XXX this still needs to identify 2 3 4 5 14 as a straight with a high card of 5
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

                // XXX
//                System.out.println("Entry value: "+entry.getValue());
                if (entry.getValue().equals(new Integer(3))) { return "three-of-a-kind"; }
                if (entry.getValue().equals(new Integer(2))) { return "two pairs"; }
            }
        }

        if (valueFrequency.size() == 4) { return "pair"; }
        if (valueFrequency.size() == 5) { return "high card"; }

        return result;
    }



//    boolean hasFourOfaKind() {
//        if (valueFrequency.size()>2) {
//            return false;
//        } else {
//            return true;
//        }
//    }
//
//    boolean hasThreeOfaKind() {
//        if (valueFrequency.size()>3) {
//            return false;
//        } else {
//            return true;
//        }
//    }

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

        // Four-of-a-kind, full house
        String resultFrequency = evaluateFrequency();
        if ((resultFrequency.equals("four-of-a-kind")) ||
                (resultFrequency.equals("full house"))) {
            return resultFrequency;
        }

        // Straight
        if (isStraight()) { return "straight"; }

        // Three-of-a-kind, two pairs, pair, high card
        if ((resultFrequency.equals("three-of-a-kind")) ||
                (resultFrequency.equals("two pairs")) ||
                (resultFrequency.equals("pair")) ||
                (resultFrequency.equals("high card"))) {
            return resultFrequency;
        }

        // In case there is an unknown hand
        return result;
    }

    static Hand joinStartingHandWithFlop(Hole startingHand, Flop flop) {
        Card[] combinedHand = ArrayUtils.addAll(startingHand.list,flop.list);

        return new Hand(combinedHand[0],combinedHand[1],combinedHand[2],combinedHand[3],combinedHand[4]);
    }

    /**
     * Testing main
     * @param args no args
     */
    public static void main(String[] args) {
        Hand h;

        for (int i=1; i<=200; i++) {
            h = new Hand();
            System.out.printf("%20s: ", h.evaluate());
            h.print();
            if ( (i%8) == 0 ) {
                System.out.println();
            }
        }

        System.out.println("\n1. Testing a straight flush");
        h = new Hand(
                new Card("S",5),
                new Card("S",6),
                new Card("S",9),
                new Card("S",8),
                new Card("S",7));
        System.out.printf("%20s: ", h.evaluate());
        h.println();

        System.out.println("\n2. Testing a four-of-a-kind");
        h = new Hand(
                new Card("S",3),
                new Card("C",6),
                new Card("D",3),
                new Card("S",3),
                new Card("H",3));
        System.out.printf("%20s: ", h.evaluate());
        h.println();

        System.out.println("\n3. Testing a full house");
        h = new Hand(
                new Card("S",3),
                new Card("C",6),
                new Card("D",3),
                new Card("S",6),
                new Card("H",3));
        System.out.printf("%20s: ", h.evaluate());
        h.println();

        System.out.println("\n4. Testing a flush");
        h = new Hand(
                new Card("S",4),
                new Card("S",4),
                new Card("S",4),
                new Card("S",4),
                new Card("S",4));
        System.out.printf("%20s: ", h.evaluate());
        h.println();

        System.out.println("\n5. Testing a straight");
        h = new Hand(
                new Card("S",4),
                new Card("C",6),
                new Card("C",8),
                new Card("S",5),
                new Card("H",7));
        System.out.printf("%20s: ", h.evaluate());
        h.println();

        System.out.println("\n6. Testing a three-of-a-kind");
        h = new Hand(
                new Card("S",3),
                new Card("C",6),
                new Card("D",3),
                new Card("S",2),
                new Card("H",3));
        System.out.printf("%20s: ", h.evaluate());
        h.println();

        System.out.println("\n7. Testing two pairs");
        h = new Hand(
                new Card("S",4),
                new Card("C",6),
                new Card("C",4),
                new Card("S",2),
                new Card("H",2));
        System.out.printf("%20s: ", h.evaluate());
        h.println();

        System.out.println("\n8. Testing a pair");
        h = new Hand(
                new Card("S",4),
                new Card("C",6),
                new Card("C",8),
                new Card("S",10),
                new Card("H",6));
        System.out.printf("%20s: ", h.evaluate());
        h.println();


        System.out.println("\n9. Testing high card");
        h = new Hand(
                new Card("S",4),
                new Card("C",2),
                new Card("C",8),
                new Card("S",5),
                new Card("H",12));
        System.out.printf("%20s: ", h.evaluate());
        h.println();



    }
}
