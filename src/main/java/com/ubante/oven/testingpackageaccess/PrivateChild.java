package com.ubante.oven.testingpackageaccess;

/**
 * Created by J on 5/11/2014.
 */
public class PrivateChild extends PrivateParent {

    void printSomethingPrivate() {
        System.out.println("This is from the child and is not private.");
    }

    @Override
    void overrideMe() {
        System.out.println("This is from the child and has overriden the parent's method.");
    }

    /**
     * See if we can override a private method in the parent.
     * @param args Nothing
     */
    public static void main(String[] args) {
        PrivateChild pc = new PrivateChild();
        System.out.println("\nMaking a child.\n");

        pc.printSomething();
        pc.printSomethingPrivate();
        pc.overrideMe();
    }
}
