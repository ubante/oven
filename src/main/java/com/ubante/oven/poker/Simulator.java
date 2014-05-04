package com.ubante.oven.poker;

import java.util.HashMap;

/**
 * This will generate stats of winning percentages given a set of hole cards.
 */
public class Simulator {

    void randomHoleCards() {
        HashMap<String, Integer> flopHandFrequency = new HashMap<String, Integer>();
        int flopAttempts = 10000; // 200k hands equals 1M cards
        int flopCards = flopAttempts * 3;
        HandStatistics stats = new HandStatistics();
        CardStack stack = CardStack.getInstance(flopCards);

        // Find the distribution of this cardstack
//        System.out.println("The raw card deck.");
//        HandDistribution distribution = new HandDistribution();
//        for (Card c : stack.getStack()) {
//            distribution.tally(c);
//        }
//        distribution.println();
//        System.out.println();

        System.out.println("PokerSimulator: making "+flopAttempts+" attempts.");
        System.out.println("\nHere's the starting random hand:");
        Hole sh = new Hole();
        sh.println();
        System.out.println();

        // Find the success after many flops
        for (int i=0; i<flopAttempts; i++) {
            Flop f = new Flop(stack.getCard(), stack.getCard(), stack.getCard());

            Hand combinedHand = Hand.joinStartingHandWithFlop(sh, f);
//            stats.measure(combinedHand); // this overcounts the hole cards
            stats.measure(f);

            String whatyouhave = combinedHand.evaluate();
            Integer frequency = flopHandFrequency.get(whatyouhave);
            if (frequency == null) { frequency=0; }
            flopHandFrequency.put(whatyouhave, frequency + 1);
        }

        // Print the post-flop results
        System.out.println("After the flop:");
        for (String handValue : flopHandFrequency.keySet()) {
            int flopFrequency = flopHandFrequency.get(handValue);
            System.out.printf("Key: %16s  Count: %6d  Frequency: %6.2f%%\n",
                    handValue,
                    flopFrequency,
                    flopFrequency*100.0/flopAttempts);
        }

        // And the measurements
//        System.out.println();
//        stats.println();
    }

    void nonrandomHoleCards(Card a, Card b) {
        HashMap<String, Integer> flopHandFrequency = new HashMap<String, Integer>();
        int flopAttempts = 10000; // 200k hands equals 1M cards
        int flopCards = flopAttempts * 3;
        HandStatistics stats = new HandStatistics();
        CardStack stack = CardStack.getInstance(flopCards);

        System.out.println("PokerSimulator: making "+flopAttempts+" attempts.");
        System.out.println("\nHere's the starting non-random hand:");
        Hole sh = new Hole(a,b);
        sh.println();
        System.out.println();

        // Find the success after many flops
        for (int i=0; i<flopAttempts; i++) {
            Flop f = new Flop(stack.getCard(), stack.getCard(), stack.getCard());

            Hand combinedHand = Hand.joinStartingHandWithFlop(sh, f);
//            stats.measure(combinedHand); // this overcounts the hole cards
            stats.measure(f);

            String whatyouhave = combinedHand.evaluate();
            Integer frequency = flopHandFrequency.get(whatyouhave);
            if (frequency == null) { frequency=0; }
            flopHandFrequency.put(whatyouhave, frequency + 1);
        }

        // Print the post-flop results
        System.out.println("After the flop:");
        for (String handValue : flopHandFrequency.keySet()) {
            int flopFrequency = flopHandFrequency.get(handValue);
            System.out.printf("Key: %16s  Count: %6d  Frequency: %6.2f%%\n",
                    handValue,
                    flopFrequency,
                    flopFrequency*100.0/flopAttempts);
        }

        // And the measurements
//        System.out.println();
//        stats.println();
    }

    public static void main(String[] args) {
        Simulator sim = new Simulator();
        sim.randomHoleCards();

        // Pocket aces
        sim.nonrandomHoleCards(
                new Card("S",14),
                new Card("C",14));

        // Onsuite AK
        sim.nonrandomHoleCards(
                new Card("D",14),
                new Card("D",13)
        );
    }
}
