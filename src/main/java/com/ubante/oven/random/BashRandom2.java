package com.ubante.oven.random;

import java.util.HashMap;

/**
 * Created by ubante on 5/20/14.
 */
public class BashRandom2 {

    public static void main(String[] args) {
        System.out.println("This is to see how many values are made from seconds, minutes and hours.");
        int product, mod;
        int hourCoefficient = 2469;
        int minCoefficient = 1;
        int secondCoefficient = 2345;
        int modValue = 100000;
        Integer modInteger, modHashValue;
        HashMap<Integer, Integer> modCount = new HashMap<>();


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

        // count possibilities
        System.out.printf("Given hour coefficient %d, minute coefficient %d, second coeeficient %d, there are %d possibilities.\n",
                hourCoefficient, minCoefficient, secondCoefficient, modCount.size());

        // find min and max values
        Integer minKey = Integer.valueOf(modValue);
        Integer maxKey = Integer.valueOf(0);
        for (Integer key : modCount.keySet()) {
            if (key < minKey) {
                minKey = key;
            }
            if (key > maxKey) {
                maxKey = key;
            }
        }
        System.out.println("The lowest mod value is  "+minKey);
        System.out.println("The highest mod value is "+maxKey);

    }
}
