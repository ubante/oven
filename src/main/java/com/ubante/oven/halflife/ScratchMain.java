package com.ubante.oven.halflife;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by ubante on 2/8/16.
 */
public class ScratchMain {
    ElementalSubstanceClass esc = new ElementalSubstanceClass();
    List<Integer> intList = new ArrayList<>();
    final static int GREATESTPOSSIBLEAGE = 6;

    void addEsc(int num) {
//        esc.addEsc(new ElementalSubstance(num,0.25));
        esc.add(new ElementalSubstance(num));
    }

    void populate() {
        addEsc(1);
        addEsc(4);
        addEsc(3);
        addEsc(2);
        addEsc(2);
        addEsc(1);
    }

    void test1() {
        populate();

        esc.display();
        System.out.println();

        List list = esc.getEsClass();
        for (int thisAge = 0; thisAge<= GREATESTPOSSIBLEAGE; thisAge++) {
            System.out.printf("%d->%d,", thisAge, Collections.frequency(list, new ElementalSubstance(thisAge)));
//            System.out.printf("%d->%d,", thisAge, Collections.frequency(esc.getEsClass(), thisAge));
        }


    }

    void test2() {
        intList.add(1);
        intList.add(1);
        intList.add(2);
        intList.add(3);
        intList.add(4);
        intList.add(4);
        intList.add(2);
        intList.add(1);

        for (int thisAge = 0; thisAge <= GREATESTPOSSIBLEAGE; thisAge++) {
            System.out.printf("%d->%d,", thisAge, Collections.frequency(intList, thisAge));
        }
    }

    void test3() {
        populate();
        intList = esc.toIntegers();

        for (int thisAge = 0; thisAge <= GREATESTPOSSIBLEAGE; thisAge++) {
            System.out.printf("%d->%d,", thisAge, Collections.frequency(intList, thisAge));
        }
    }

    public static void main(String[] args) {
        ScratchMain s = new ScratchMain();
        s.test1();

        System.out.println("\n\n----------------------\n");
        s.test2();

        System.out.println("\n\n----------------------\n");
        s.test3();

    }
}
