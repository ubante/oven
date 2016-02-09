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
//        System.out.println("size is: " + size);
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

    void displayCSV(int GREATESTPOSSIBLEAGE) {
        System.out.println("History in CSV format:");
        System.out.println("generation, freq of 0, freq of 1, freq of 2,...");

        int generationCounter = 0;

        for (ElementalSubstanceClass esc : history) {
//            System.out.printf("generation %d\n", generationCounter);

            esc.display();
            System.out.println("");
            List<Integer> intList = esc.toIntegers();
            System.out.printf("%2d,", generationCounter);
            for (int thisAge = 0; thisAge<= GREATESTPOSSIBLEAGE; thisAge++) {
//                System.out.printf("%d,", Collections.frequency(esc.getEsClass(), thisAge));
//                System.out.printf("%d->%d,", thisAge, Collections.frequency(intList, thisAge));
                System.out.printf("%2d,", Collections.frequency(intList, thisAge));
            }
            System.out.println("\n");

            generationCounter++;
        }

    }

}
