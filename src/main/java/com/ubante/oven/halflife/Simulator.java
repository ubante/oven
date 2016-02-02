package com.ubante.oven.halflife;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Look for the stable mean age when elements decay and are replaced.
 *
 * With inputs of 100 items with:
 * - a 25% chance of decaying annually
 * - initial ages randomly between 0 and 10 years
 *
 * After 99 years, the stable mean age is 3 years. for data, see:
 * https://docs.google.com/spreadsheets/d/12_5TjAfx9Lkh1hnlQz0JrogDOfQ291r29t_cIcLeF4U/edit#gid=0
 */
public class Simulator {
    List<ElementalSubstance> things = new ArrayList<>();
    int minInitAge = 0;
    int maxInitAge = 10;
    int generationalYear = 0;
    int finalGenerationalYear = 99;

    void populate(int count) {
        for (int i=0; i<count; i++) {
            int initAge = (int) (Math.random()*maxInitAge);
            things.add(new ElementalSubstance(initAge));
        }
    }

    void displayIndividually() {
        for (ElementalSubstance thing : things) {
            System.out.println(thing.display());
        }
    }

    void ageThings() {
        for (ElementalSubstance thing : things) {
            thing.age();
        }
    }

    void decayThings() {
        double odds;
        int dropCount = 0;

        Iterator<ElementalSubstance> itr = things.iterator();
        while (itr.hasNext()) {
            ElementalSubstance es = itr.next();
            odds = Math.random();

            if (odds < es.decayRatePerYear) {
                itr.remove();
                dropCount++;
            }
        }

        for (int i=0; i<dropCount; i++) {
            things.add(new ElementalSubstance());
        }
    }

    void displayRow() {
        System.out.println("Generation: " + generationalYear);

        for (ElementalSubstance thing : things) {
            System.out.print(String.format("%2d ", thing.age));
        }

        System.out.println("\n");
    }

    void displayStats() {
        int size = things.size();
        int sum = 0;

        for (ElementalSubstance thing : things) {
            sum = sum + thing.age;
        }

        System.out.println(String.format("The average time is %4.1f years.\n", sum/(float) size));
    }

    void begin() {
        populate(100);
        displayRow();
        displayStats();

        while (generationalYear < finalGenerationalYear) {
            generationalYear++;
            ageThings();
            decayThings();
            displayRow();
            displayStats();
        }

//        displayIndividually();
    }

    public static void main(String[] args) {
        System.out.println("Half lives!\n");

        Simulator s = new Simulator();
        s.begin();

    }

}
