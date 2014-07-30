package com.ubante.oven.jul;

import java.util.logging.Logger;

/**
 * ubante 7/29/14 5:11 PM
 * This is very serious business.
 */
public class Cat {
    private static Logger theLogger = Logger.getLogger(Cat.class.getName());

    Cat() { theLogger.fine("new cat created"); }

    void eat(Food f) {
        if (!f.name.equals("salmon")) {
            theLogger.severe("Danger -> eating something gross: " + f.name);
        } else {
            theLogger.info("eating: " + f.name);
        }
    }
}
