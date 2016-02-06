package com.ubante.oven.halflife;

/**
 * Think uranium.
 */
public class ElementalSubstance {
    int age;
    double decayRatePerYear;

    ElementalSubstance(int a, double d) {
        age = a;
        decayRatePerYear = d;
    }

    ElementalSubstance(int a) {
        this(a, 0.25);
    }

    ElementalSubstance() {
        this(0, 0.25);
    }

    String display() {
        return String.format("age: %d", age);
    }

    void age() {
        age++;
    }
}
