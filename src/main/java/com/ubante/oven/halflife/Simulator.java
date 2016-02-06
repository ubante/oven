package com.ubante.oven.halflife;

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
    final int FINALGENERATIONYEAR = 49;
    final int SAMPLESIZE = 10;
    int generationalYear = 0;
    int maxInitAge = 10;
    History history;

    void generateInitialClass(int SAMPLESIZE) {

        ElementalSubstanceClass generation = new ElementalSubstanceClass();
        for (int i=0; i<SAMPLESIZE; i++) {
            int initAge = (int) (Math.random() * maxInitAge);
            generation.add(new ElementalSubstance(initAge));
        }

        history = new History();
        history.add(generation);
    }

    void displayClassStats() {}

    void ageThings() {}



    void begin() {
        generateInitialClass(SAMPLESIZE);
        displayClassStats();

        while (generationalYear <= FINALGENERATIONYEAR) {
            generationalYear++;
            ageThings();

//            decayThings();
//            rememberThings();
//            displayRow();
//            displayStats();
        }


    }

    public static void main(String[] args) {
        System.out.println("Second half life!");

        Simulator s = new Simulator();
        s.begin();
    }

}
