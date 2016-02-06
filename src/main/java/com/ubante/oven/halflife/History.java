package com.ubante.oven.halflife;

import java.util.ArrayList;
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




}
