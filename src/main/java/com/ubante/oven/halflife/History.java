package com.ubante.oven.halflife;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Collection of ElementalSubstanceClass.  Each element represents a sampling.  This class is a history of the
 * samplings.
 */
public class History {
    List<ElementalSubstanceClass> history = new ArrayList<>();

    History() {}

    void add(ElementalSubstanceClass esClass) {
        history.add(esClass);
    }

    /**
     * This will return a new object so it can be manipulated without effecting the existing ElementalSubstances.
     * @return
     */
    ElementalSubstanceClass getNewestClass() {
        int size = history.size();
        ElementalSubstanceClass last = history.get(size-1);
        return last.copy();
    }

    void displayCurrentGeneration() {
        int generation = history.size()-1;
        ElementalSubstanceClass newestGeneration = history.get(generation);
        System.out.printf("Generation %3d: ", generation);
        newestGeneration.display();

        System.out.printf(": %.2f\n", newestGeneration.getMeanAge());

    }

    void displayAll() {
        System.out.println("This is a simple dump of the history of generations.");
        for (ElementalSubstanceClass esc : history) {
            esc.display();
            System.out.println();
        }
    }

    void displayCsv(int GREATESTPOSSIBLEAGE) {
        System.out.println("History in CSV format:");
        System.out.println("generation,freq of 0,freq of 1,freq of 2,...");

        int generationCounter = 0;

        for (ElementalSubstanceClass esc : history) {
            List<Integer> intList = esc.toIntegers();
            System.out.printf("%2d,", generationCounter);
            for (int thisAge = 0; thisAge<= GREATESTPOSSIBLEAGE; thisAge++) {
                System.out.printf("%2d,", Collections.frequency(intList, thisAge));
            }
            System.out.println("");

            generationCounter++;
        }

    }

    void displayCsvWithMeanStd(int GREATESTPOSSIBLEAGE) {
        System.out.println("History in CSV format:");
        System.out.println("generation,mean,std,freq of 0,freq of 1,freq of 2,...");

        int generationCounter = 0;

        for (ElementalSubstanceClass esc : history) {
            List<Integer> intList = esc.toIntegers();
            System.out.printf("%2d,%4.2f,%5.3f,", generationCounter, esc.getMeanAge(), esc.getStd());

            for (int thisAge = 0; thisAge<= GREATESTPOSSIBLEAGE; thisAge++) {
                System.out.printf("%2d,", Collections.frequency(intList, thisAge));
            }
            System.out.println("");

            generationCounter++;
        }

    }

}
