package com.ubante.oven.jul;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * ubante 7/25/14 1:35 PM
 * This is very serious business.
 */
public class TheLogger {
    private static Logger JULLOGGER = Logger.getLogger(TheLogger.class.getName());
    static String rootDir = "/home/ubante/tmp/theloggerLogs";

//    TheLogger getLoggerSingleton() { return Logger; }
    void logStart() {
        JULLOGGER.info("Starting logger");
        lfine("log level: " + getLogLevel());
    }

    static void setLogLevel(Level level) { JULLOGGER.setLevel(level);}

    static String getLogLevel() {
        Level l = JULLOGGER.getLevel();
        return l.getName();
//        return l.toString();
//        return JULLOGGER.getLevel().toString();
    }


    static void lsevere(String message) { JULLOGGER.severe(message); }
    static void lwarn(String message) { JULLOGGER.warning(message); }
    static void linfo(String message) { JULLOGGER.info(message); }
    static void lfine(String message) { JULLOGGER.fine(message); }
    static void lfiner(String message) { JULLOGGER.finer(message); }



    public static void main(String[] args) {
        TheLogger logger = new TheLogger();
        logger.logStart();
        logger.setLogLevel(Level.FINER);

        LogClient client = new LogClient();
        client.countDownSlowly(5);

    }
}
