package com.ubante.oven.poker;


import java.util.Arrays;

/**
 * Created by J on 5/1/2014.
 */
public class StartingHand extends Hand {
    int handsize = 2;

    StartingHand(Card a, Card b) {
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

    StartingHand() {
        this(Card.getRandom(),Card.getRandom());
    }

    /**
     * Test main
     * @param args none
     */
    public static void main(String[] args) {

    }
}
