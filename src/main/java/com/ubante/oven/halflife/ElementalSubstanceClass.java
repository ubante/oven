package com.ubante.oven.halflife;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * This is a set of ElementalSubstances sampled at the same time.
 *
 * That is, at a given sampling, these were the ElementalSubstances that existed.
 *
 * Because 2d arrays are brutal in java.
 */
public class ElementalSubstanceClass {
    private List<ElementalSubstance> esClass = new ArrayList<>();

    ElementalSubstanceClass() {}

    /**
     * Deep copy method.
     * @return
     */
    ElementalSubstanceClass copy() {
        ElementalSubstanceClass copy = new ElementalSubstanceClass();

        for (ElementalSubstance es : esClass) {
            copy.add(es.copy());
        }

        return copy;
    }

    public List<ElementalSubstance> getEsClass() {
        return esClass;
    }

    void add(ElementalSubstance es) {
        esClass.add(es);
    }

    void display() {
        for (ElementalSubstance es : esClass) {
            System.out.print(String.format("%2d ", es.getAge()));
        }
    }

    void ageMembers() {
        for (ElementalSubstance es : esClass) {
            es.age();
        }
    }

    double getMeanAge() {
        int sum = 0;
        for (ElementalSubstance es : esClass) {
            sum = sum + es.getAge();
        }

        return sum/(double) esClass.size();
    }

    double getStd() {
        double sum = 0;
        double mean = getMeanAge();
        for (ElementalSubstance es : esClass) {
            sum = sum + Math.pow((es.getAge()-mean), 2);
        }

        return Math.pow((sum/esClass.size()), 0.5);
    }

    void decayMembers() {
        double odds;
        int dropCount = 0;

        Iterator<ElementalSubstance> itr = esClass.iterator();
        while (itr.hasNext()) {
            ElementalSubstance es = itr.next();
            odds = Math.random();

            if (odds < es.getDecayRatePerYear()) {
                itr.remove();
                dropCount++;
            }
        }

        for (int i=0; i<dropCount; i++) {
            esClass.add(new ElementalSubstance());
        }
    }

    /**
     * Java Collections is easier with boxed primitives.  Because equals is hard.
     * @return
     */
    List<Integer> toIntegers() {
        List<Integer> intList = new ArrayList<>();

        for (ElementalSubstance es : esClass) {
            intList.add(es.getAge());
        }

        return intList;
    }
}
