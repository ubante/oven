package com.ubante.oven.jul;

import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * ubante 7/29/14 4:37 PM
 * This is very serious business.
 */
public class DayTwo {
    private static Logger theLogger = Logger.getLogger(DayTwo.class.getName());
    String message;

    DayTwo(String s) { message = s; }

    void printString() {
        System.out.println(message);
    }

    public static void main(String[] args) {
        DayTwo ex = new DayTwo("Some string to log");
        ex.printString();

        // turn up the Logger object and its handlers
        theLogger.setLevel(Level.FINE);
        Handler[] handlers = Logger.getLogger("").getHandlers();
        for (Handler handler : handlers) {
            System.out.println("Adjusting to FINER: " + handler.toString());
            handler.setLevel(Level.FINER);
        }

        theLogger.info("this goes to info");
        theLogger.fine("this goes to fine");
        theLogger.finer("this goes to finer");
        theLogger.finest("this goes to finest");

        Food food = new Food("salmon");
        Cat bugger = new Cat();
        bugger.eat(food);
        bugger.eat(new Food("wheat"));

    }
}
