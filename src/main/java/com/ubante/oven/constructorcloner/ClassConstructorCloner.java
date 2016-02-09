package com.ubante.oven.constructorcloner;

import java.util.ArrayList;
import java.util.List;

/**
 * Make a copy() method that does a deep copy.
 */
public class ClassConstructorCloner {
    private List<String> stringList = new ArrayList<>();

    ClassConstructorCloner(String a, String b, String c) {
        stringList.add(a);
        stringList.add(b);
        stringList.add(c);
    }

    ClassConstructorCloner copy() {
        ClassConstructorCloner copy = new ClassConstructorCloner(
                stringList.get(0), stringList.get(1), stringList.get(2));
        return copy;
    }

    void change() {
        stringList.add("X");
    }

    void display() {
        for (String s : stringList) {
            System.out.printf("%s ", s);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("Making the original string list:");
        ClassConstructorCloner sl1 = new ClassConstructorCloner("a", "b", "c");
        sl1.display();
        System.out.println();

        ClassConstructorCloner sl2 = sl1.copy();
        System.out.println("This is the copy:");
        sl2.display();
        System.out.println();

        System.out.println("Modifying the copy:");
        sl2.change();
        sl2.display();
        System.out.println();

        System.out.println("Here's the original:");
        sl1.display();

    }
}
