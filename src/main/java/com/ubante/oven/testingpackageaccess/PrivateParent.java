package com.ubante.oven.testingpackageaccess;

/**
 * Created by J on 5/11/2014.
 */
public class PrivateParent {

    PrivateParent() {}

    void overrideMe() {
        System.out.println("This is from the parent and will be overriden by the child.");
    }
    void printSomething() {
        System.out.println("This is from the parent.");
    }

    private void printSomethingPrivate() {
        System.out.println("This is from the parent and is very private.");
    }

    public static void main(String[] args) {
        PrivateParent pp = new PrivateParent();
        System.out.println("\nMaking a parent.\n");

        pp.printSomething();
        pp.printSomethingPrivate();
        pp.overrideMe();

    }
}
