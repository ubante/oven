package com.ubante.oven.jul;

import java.util.logging.Logger;

/**
 * ubante 7/29/14 5:12 PM
 * This is very serious business.
 */
public class Food {
    private static Logger theLogger = Logger.getLogger(Food.class.getName());
    String name;

    Food(String foodName) {
        name = foodName;
        theLogger.fine("new food created: " + foodName);
    }
}
