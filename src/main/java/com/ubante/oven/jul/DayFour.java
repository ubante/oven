package com.ubante.oven.jul;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * Clean example for logging
 */
public class DayFour {
    private static Logger classLogger = Logger.getLogger(DayThree.class.getName());

    DayFour() {
        FileHandler fh;
        String logPath = "/home/ubante/tmp/theloggerLogs/Day4.log";
        try {
            fh = new FileHandler(logPath, true);
            classLogger.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);
            classLogger.info("Creating DayFour object.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void log(String message) {
        classLogger.info(message);

        Cat cat = new Cat();
        Food f = new Food("tuna");
        cat.eat(f);
        cat.eat(new Food("salmon"));
    }

    public static void main(String[] args) {
        DayFour df = new DayFour();

        df.log("logs this message");
    }
}
