package com.ubante.oven;

/**
 * Created by J on 3/30/2014.
 */
public class TestClass {
    String aString = "string0";

    TestClass() {}

    void printString() {
        System.out.println(aString);
    }

    static void printSomething() {
        System.out.println("something");
    }

    public static void main(String[] args) {
        System.out.println("Hello hello");
        printSomething();
        TestClass tc = new TestClass();
        tc.printString();
        TestClass tc2 = new TestClass();
    }
}
