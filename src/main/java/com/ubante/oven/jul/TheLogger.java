package com.ubante.oven.jul;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * ubante 7/25/14 1:35 PM
 * This is very serious business.
 */
public class TheLogger {

    public static void main(String[] args) {
        final Logger JULLOGGER = Logger.getLogger(TheLogger.class.getName());

        JULLOGGER.setLevel(Level.INFO);

        JULLOGGER.info("In the main - JUL.");
        System.out.println("In the main - sout.");

    }
}
