package com.ubante.oven.nulltest;

/**
 * ubante 7/29/14 1:55 PM
 * This is very serious business.
 */
public class WillItNull {

    public static void main(String[] args) {
        System.out.println("Testing NPEs....\n");
        SomeClass declaredObject = null;
        SomeClass initializedObject = new SomeClass(123);

        System.out.println("Initilized object does this:");
        System.out.println(initializedObject.toString());
        initializedObject.doSomething();
        System.out.println(initializedObject.toString());

        System.out.println("\nMerely declared object does this:");

        // This works.
        if (declaredObject == null) {
            System.out.println("This object == null.");
        }

        // This gives an NPE
        if (declaredObject.equals(null)) {
            System.out.println("This object isNamed null.");
        }

//        System.out.println(declaredObject.toString());


    }

}
