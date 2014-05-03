package com.ubante.oven.poker;

import java.util.HashMap;

/**
 * This will generate a random starting hand or accept a starting hand.  Then it will:
 *
 * 1. display the likelihood of winning the round
 *
 */
public class PokerSimulator {


    public static void main(String[] args) {
        HashMap<String, Integer> flopHandFrequency = new HashMap<String, Integer>();
        int flopAttempts = 501000;

        System.out.println("Making "+flopAttempts+" attempts.");
        System.out.println("\nHere's the starting hand:");
        StartingHand sh = new StartingHand();
        sh.println();
        System.out.println();

        // Find the success after many flops
        for (int i=0; i<flopAttempts; i++) {
//            System.out.print("Here's a sample flop:  ");
            Flop f = new Flop();
//            f.println();

//            System.out.print("Combined hand:         ");
            Hand combinedHand = Hand.joinStartingHandWithFlop(sh, f);
//            combinedHand.println();

            String whatyouhave = combinedHand.evaluate();
//            System.out.println("You have: " + whatyouhave+"\n");

            Integer frequency = flopHandFrequency.get(whatyouhave);
            if (frequency == null) { frequency=0; }
            flopHandFrequency.put(whatyouhave, frequency + 1);
        }

        // Print the post-flop results
        for (String handValue : flopHandFrequency.keySet()) {
            int flopFrequency = flopHandFrequency.get(handValue);
            System.out.printf("Key: %16s  Count: %6d  Frequency: %6.2f%%\n",
                    handValue,
                    flopFrequency,
                    flopFrequency*100.0/flopAttempts);
                    // 34.2f);
        }
    }
}

/**
 Key:        high card  Count: 45545  Frequency:  45.09%
 Key:             pair  Count: 45476  Frequency:  45.03%
 Key:  three-of-a-kind  Count:  3527  Frequency:   3.49%
 Key:   four-of-a-kind  Count:   106  Frequency:   0.10%
 Key:        two pairs  Count:  6069  Frequency:   6.01%
 Key:       full house  Count:   277  Frequency:   0.27%

 Key:        high card  Count: 225279  Frequency:  44.97%
 Key:             pair  Count: 226443  Frequency:  45.20%
 Key:  three-of-a-kind  Count: 17542  Frequency:   3.50%
 Key:   four-of-a-kind  Count:   450  Frequency:   0.09%
 Key:        two pairs  Count: 29963  Frequency:   5.98%
 Key:       full house  Count:  1323  Frequency:   0.26%

 Key:        high card  Count: 225531  Frequency:  45.02%
 Key:             pair  Count: 226193  Frequency:  45.15%
 Key:  three-of-a-kind  Count: 17396  Frequency:   3.47%
 Key:   four-of-a-kind  Count:   450  Frequency:   0.09%
 Key:        two pairs  Count: 30031  Frequency:   5.99%
 Key:       full house  Count:  1399  Frequency:   0.28%

 Key:        high card  Count: 225384  Frequency:  44.99%
 Key:             pair  Count: 226128  Frequency:  45.14%
 Key:  three-of-a-kind  Count:  17635  Frequency:   3.52%
 Key:   four-of-a-kind  Count:    434  Frequency:   0.09%
 Key:        two pairs  Count:  30062  Frequency:   6.00%
 Key:       full house  Count:   1357  Frequency:   0.27%
*/