package com.ubante.oven.pad;

import java.util.ArrayList;
import java.util.List;

/**
 * ubante 7/21/14 3:54 PM
 * This is very serious business.
 */
public class Collection {
    List<Monster> monsterList = new ArrayList<>();
    boolean isComplete = false;
    double completionPercentage;
    int maxSize;

    Collection(int maxSize) { this.maxSize = maxSize; }

    void add(Monster m) {
        // If collection is already complete, then just print something.
        if (isComplete) {
            System.out.println("Collection is already complete.");
            return;
        }

        // If monster doesn't exist in collection, add it.
        if (monsterList.contains(m)) {
//            System.out.printf("%s already exists in collection\n", m.name);
        } else {
            monsterList.add(m);
            if (monsterList.size() == maxSize) {
                isComplete = true;
            }
        }
    }
}
