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
public class OldSimulator {
    List<ElementalSubstance> things = new ArrayList<>();
    final int SAMPLESIZE = 100;
//    final int SAMPLESIZE = 10;
    int FINALGENERATIONYEAR = 49;
    //    int FINALGENERATIONYEAR = 4;
    int OLDESTPOSSIBLEAGE = 80;
    int minInitAge = 0;
    int maxInitAge = 10;
    int generationalYear = 0;
    int[][] record = new int[FINALGENERATIONYEAR+2][SAMPLESIZE];

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

    /**
     * Add this to a two-dimensional array so we can better manipulate data over time
     */
    void rememberThings() {
        int counter = 0;

        for (ElementalSubstance thing : things) {
//            System.out.println("year: " + generationalYear + " and counter: " + counter);
            record[generationalYear][counter] = thing.age;
            counter++;
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

    int[] rawToFrequency(int[] rawData) {
        int ageCounter[] = new int[OLDESTPOSSIBLEAGE];
        for (int i=0; i<OLDESTPOSSIBLEAGE; i++) {
            ageCounter[i] = 0;
        }

        for (int position=0; position<SAMPLESIZE; position++) {
            int value = rawData[position];
            ageCounter[value]++;
        }

        return ageCounter;
    }


    /**
     * We want a csv that looks like the below
     *
     */
    void displayRecord() {


        for (int year=0; year<FINALGENERATIONYEAR; year++) {

            for (int position=0; position<SAMPLESIZE; position++) {
                System.out.print(String.format("%2d ", record[year][position]));
            }
            System.out.println();

//            int frequency = rawToFrequency(record[year]);

        }


    }

    void begin() {
        populate(SAMPLESIZE);
        rememberThings();
        displayRow();
        displayStats();

        while (generationalYear <= FINALGENERATIONYEAR) {
            generationalYear++;
            ageThings();
            decayThings();
            rememberThings();
            displayRow();
            displayStats();
        }

        displayRecord();
    }

    public static void main(String[] args) {
        System.out.println("Half lives!\n");

        OldSimulator s = new OldSimulator();
        s.begin();

    }

}

/**

 The average time is  2.5 years.

 Generation: 50
 19 18 13 10  9  8  6  6  6  6  6  6  5  5  5  5  5  4  4  4  4  4  4  4  3  3  3  3  3  3  2  2  2  2  2  2  2  2  2  2  2  2  2  2  2  2  2  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  0  0  0  0  0  0  0  0  0  0  0  0  0  0  0  0  0  0  0  0  0  0  0  0  0  0  0  0  0  0

 The average time is  2.4 years.

 1  4  8  8  0  2  1  6  9  2  3  8  2  5  6  3  4  0  5  2  4  8  7  0  9  9  7  2  8  4  5  6  4  9  8  9  0  3  3  1  6  2  6  4  9  2  6  9  7  3  8  0  6  9  1  6  7  8  4  2  8  1  8  3  3  2  6  0  4  9  6  4  8  3  8  0  6  4  2  2  1  0  5  2  1  5  9  9  8  4  0  3  0  9  2  4  8  6  1  4
 5  9  9  3  7  3  4  9  7  4  5  1  6  3  5  9  8  1 10 10  8  9  6  7  5 10 10  4  2  3  7  5 10  7 10  8  4  9  1  7  2  7  8  9  2  4  4  3  1 10  7  5  9  4  9  1  7  5  1  6  6 10  9  5  1  4  1  3  9  7  2  0  0  0  0  0  0  0  0  0  0  0  0  0  0  0  0  0  0  0  0  0  0  0  0  0  0  0  0  0
 6 10 10  4  8  5 10  8  5  6  2  7  4  6 10  9  2  9  7  6 11 11  3  8 11  8 11  9  5 10  2  3 10  5  4  2 11  8  6 10  5 10  8  6  7  7 11 10  6  4 10  8  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  0  0  0  0  0  0  0  0  0  0  0  0  0  0  0  0  0  0  0  0  0  0
 7 11 11  5  9  6 11  9  3  5 10  3 10 12 12  4  9 12  9 12 10  6  3  6  5  3 12 11  6  9  7  8  8 12  7  5 11  2  2  2  2  2  2  2  2  2  2  2  2  2  2  2  2  2  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  0  0  0  0  0  0  0  0  0  0  0  0  0  0  0  0  0  0  0  0  0  0  0  0  0  0  0  0  0  0  0
 8 12 12 10 12 10  4  6 11  4 13 13 10 13 10 13  7  4  7  4 13  7 10  8  9  9 13 12  3  3  3  3  3  3  3  3  3  3  3  3  3  2  2  2  2  2  2  2  2  2  2  2  2  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  0  0  0  0  0  0  0  0  0  0  0  0  0  0  0  0  0  0  0  0  0  0  0  0  0  0
 9 13 11 13 11  5  7 12  5 14 11 11  8  5  8  5  8 11  9 10 14 13  4  4  4  4  4  4  4  4  4  4  4  3  3  3  3  3  3  3  3  3  2  2  2  2  2  2  2  2  2  2  2  2  2  2  2  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  0  0  0  0  0  0  0  0  0  0  0  0  0  0  0  0  0  0  0  0  0  0  0  0
 */

