package com.ubante.oven.randomnumbergenerator;

import java.util.HashMap;

/**
 * Created by J on 5/3/2014.
 */
public class FindGoodDistribution {
    int minValue = 2;
    int maxValue = 14;
    int numberOfSamples = 0;
    HashMap<Integer, Integer> freq = new HashMap<Integer, Integer>();


    FindGoodDistribution(int min, int max) {
        this.minValue = min;
        this.maxValue = max;
    }

    void initialize() {
        for (int i=minValue; i<=maxValue; i++) {
            freq.put(i,0);
        }
    }

    void println() {
        System.out.println("Size of frequency map is: "+numberOfSamples);
        for (int i=minValue; i<=maxValue; i++) {
            System.out.printf("%6d ",i);
        }
        System.out.println();
//        for (int i=minValue; i<=maxValue; i++) {
//            System.out.printf(" %6s","----");
//        }
//        System.out.println();
        for (int i=minValue; i<=maxValue; i++) {
            System.out.printf("%6d ",freq.get(i));
        }
        System.out.println();
        for (int i=minValue; i<=maxValue; i++) {
            System.out.printf("%5.1f%% ",freq.get(i)*100.0/numberOfSamples);
        }
        System.out.println("\n");
    }

    void add() {
        int value = minValue + (int)(Math.random()*(maxValue-1));
        int count = freq.get(value);
        freq.put(value,count+1);
        numberOfSamples++;
    }

    public static void main(String[] args) {
        int minValue = 2;
        int maxValue = 14;

        FindGoodDistribution distribution = new FindGoodDistribution(
                minValue, maxValue
        );

        System.out.println("Initializing frequency map:");
        distribution.initialize();
        distribution.println();

        // Generate a bunch
        for (int i=1; i<=1000; i++) {
            distribution.add();
        }
        distribution.println();
        for (int i=1; i<=100000; i++) {
            distribution.add();
        }
        distribution.println();

//        // Generate a bunch
//        for (int i=0; i<numberOfSamples; i++) {
//            int value = minValue + (int)(Math.random()*(maxValue-1));
//
//            System.out.printf("%d ",value);
//
//            Integer frequency = flopHandFrequency.get(value);
//            if (frequency == null) { frequency=0; }
//            flopHandFrequency.put(frequency, frequency + 1);
//        }
//        System.out.println();
//
//        System.out.println("The size is: "+flopHandFrequency.size());
//
//        // Print report
//        for (Integer value : flopHandFrequency.keySet()) {
//            Integer freq = flopHandFrequency.get(value);
//            System.out.printf("Key: %16d  Count: %6d  Frequency: %6.2f%%\n",
//                    value,
//                    freq,
//                    freq*100.0/numberOfSamples
//            );
//        }

    }
}

/**
 * With Math.random()
 Size of frequency map is: 11000
 2      3      4      5      6      7      8      9     10     11     12     13     14
 796    887    841    814    792    881    865    839    859    851    902    867    806
 7.2%   8.1%   7.6%   7.4%   7.2%   8.0%   7.9%   7.6%   7.8%   7.7%   8.2%   7.9%   7.3%
*/