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
public class HalflifeSimulator {
    final int FINALGENERATIONYEAR = 100;
    final int SAMPLESIZE = 100;
    int generationalYear = 0;
    int maxInitAge = 2;
    History history;
    boolean isOutputVerbose = false;

    void generateInitialClass(int SAMPLESIZE) {

        ElementalSubstanceClass generation = new ElementalSubstanceClass();
        for (int i=0; i<SAMPLESIZE; i++) {
            int initAge = (int) (Math.random() * maxInitAge);
            generation.add(new ElementalSubstance(initAge));
        }

        history = new History();
        history.add(generation);

        System.out.println("Initial class looks like this:");
        history.displayCurrentGeneration();
        System.out.println("");
    }

    public void setOutputVerbose(boolean outputVerbose) {
        isOutputVerbose = outputVerbose;
    }

    void begin() {
        System.out.printf("Max initial age: %d, Number of generations: %d, Sample size: %d\n\n",
                maxInitAge, FINALGENERATIONYEAR, SAMPLESIZE);
        generateInitialClass(SAMPLESIZE);

        while (generationalYear <= FINALGENERATIONYEAR) {

            // Get the newest generation
            ElementalSubstanceClass newestClass = history.getNewestClass();
            newestClass.ageMembers();
            newestClass.decayMembers();
            history.add(newestClass);
            generationalYear++;

        }

        System.out.println();
        System.out.println("The history looks like:");
        history.displayAll();
        System.out.println();

        history.displayCsvWithMeanStd(FINALGENERATIONYEAR+maxInitAge);

    }

    public static void main(String[] args) {
        System.out.println("Second half life!");

        HalflifeSimulator s = new HalflifeSimulator();
        s.setOutputVerbose(true);
        s.begin();
    }

}
