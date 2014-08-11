package com.ubante.oven.jul;

import java.io.IOException;
import java.util.logging.*;

/**
 * ubante 7/29/14 4:37 PM
 * This is very serious business.
 */
public class DayThree {
    private static Logger theLogger = Logger.getLogger(DayThree.class.getName());
    String message;

    DayThree(String s) {
        FileHandler fh;
        String logPath = "/home/ubante/tmp/theloggerLogs/Day3.log";
        try {
            fh = new FileHandler(logPath, true);
            theLogger.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);
            theLogger.info("test 123");
        } catch (IOException e) {
            e.printStackTrace();
        }
        message = s;
    }

    void printString() {
        System.out.println(message);
    }

    public static void main(String[] args) {

        DayThree ex = new DayThree("Some string to log in Day3");
        ex.printString();


        // disable logging to the console
//        theLogger.setUseParentHandlers(false);

        // since I don't want to do this in Cat
        Logger globalLogger = Logger.getLogger("");
        Handler[] handlers = globalLogger.getHandlers();
        for (Handler handler : handlers) {
            globalLogger.removeHandler(handler);
        }

//        FileHandler fh;
//        String logPath = "/home/ubante/tmp/theloggerLogs/Day3.log";
//        try {
//            fh = new FileHandler(logPath, true);
//            theLogger.addHandler(fh);
//            SimpleFormatter formatter = new SimpleFormatter();
//            fh.setFormatter(formatter);
//            theLogger.info("test 123");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }




        // turn up the Logger object and its handlers
        theLogger.setLevel(Level.FINE);
        Handler[] handlers2 = Logger.getLogger("").getHandlers();
        for (Handler handler : handlers2) {
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
