package com.ubante.oven.halflife;

import java.util.ArrayList;
import java.util.List;

/**
 * This is a set of ElementalSubstances sampled at the same time.
 *
 * That is, at a given sampling, these were the ElementalSubstances that existed.
 *
 * Because 2d arrays are brutal in java.
 */
public class ElementalSubstanceClass {
    List<ElementalSubstance> esClass = new ArrayList<>();

    void add(ElementalSubstance es) {
        esClass.add(es);
    }

}
