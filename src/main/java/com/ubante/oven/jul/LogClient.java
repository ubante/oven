package com.ubante.oven.jul;

/**
 * ubante 7/29/14 4:15 PM
 * This is very serious business.
 */
public class LogClient {

    LogClient() {}

    void countDownSlowly(int countMax) {

        for (int i=countMax; i>0; i--) {
            System.out.println("Count: " + i);
            TheLogger.linfo("counted to " + i);
            try {
                TheLogger.lfiner("sleeping for 1000ms");
                Thread.sleep(1000); // sleep for 1sec
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.exit(1);
            }
        }

        System.out.println("boom!");
        TheLogger.lsevere("B-O-O-M");
    }
}
