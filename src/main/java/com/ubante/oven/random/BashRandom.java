package com.ubante.oven.random;

import java.util.HashMap;

/**
 * Created by ubante on 5/20/14.
 */
public class BashRandom {
    int product, mod;
    int hourCoefficient, minCoefficient, secondCoefficient;
    int modValue = 100000;
    Integer modInteger, modHashValue;
    HashMap<Integer, Integer> modCount = new HashMap<>();

    BashRandom(int h, int m, int s) {
        hourCoefficient = h;
        minCoefficient = m;
        secondCoefficient = s;
    };

    void makeHash() {
        // 60 * 60 * 24 = 86400
        for (int hour = 0; hour < 24; hour++) {
            for (int min = 0; min < 60; min++) {
                for (int second = 0; second < 60; second++) {
                    product = hourCoefficient * hour + minCoefficient * min + secondCoefficient * second;
                    mod = product % modValue;
                    modInteger = Integer.valueOf(mod);

                    modHashValue = modCount.get(modInteger);
                    if (modHashValue == null) {
                        modHashValue = 0;
                    }
                    modCount.put(modInteger, modHashValue + 1);

                }
            }
        }
    }

    void printResults() {
        // count possibilities
        System.out.printf("Given hour coefficient %d, minute coefficient %d, second coeficient %d, there are %d possibilities.\n",
                hourCoefficient, minCoefficient, secondCoefficient, modCount.size());

        // find min and max values
        Integer minKey = Integer.valueOf(modValue);
        Integer maxKey = Integer.valueOf(0);
        int evenCounter = 0;
        int oddCounter = 0;
        for (Integer key : modCount.keySet()) {
            if (key < minKey) { minKey = key; }
            if (key > maxKey) { maxKey = key; }
            if ((key % 2) == 0) { evenCounter++; }
            if ((key % 2) == 1) { oddCounter++; }
        }
        System.out.println("The lowest mod value is:   "+minKey);
        System.out.println("The highest mod value is:  "+maxKey);
        System.out.println("The number of even values: "+evenCounter);
//        System.out.println("The number of odd values:  "+oddCounter);
    }

    public static void main(String[] args) {
        System.out.println("This is to see how many values are made from seconds, minutes and hours.");
        BashRandom br = new BashRandom(24690, 2, 2345);
        br.makeHash();
        br.printResults();


    }
}
