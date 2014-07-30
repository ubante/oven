package com.ubante.oven.jul;

/**
 * ubante 7/29/14 4:37 PM
 * This is very serious business.
 */
public class DayOne {
    String message;

    DayOne(String s) { message = s; }

    void printString() {
        System.out.println(message);
    }

    public static void main(String[] args) {
        DayOne ex = new DayOne("Some string to log");
        ex.printString();
    }
}
