package com.ubante.oven.nulltest;

/**
 * ubante 7/29/14 1:56 PM
 * This is very serious business.
 */
public class SomeClass {
    int i;

    SomeClass(int i) { this.i = i; }

    SomeClass getNullClass() { return null; }

    void doSomething() { i++; }

    public String toString() { return "I am " + String.valueOf(i); }
}
