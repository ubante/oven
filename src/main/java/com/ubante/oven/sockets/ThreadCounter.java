package com.ubante.oven.sockets;

/**
 * ubante 7/22/14 4:01 PM
 * This is very serious business.
 */
public class ThreadCounter {
    static int counter = 0;

    static int checkIn() {
        counter++;
        return counter;
    }
}
