package com.ubante.oven.sockets;

import java.io.IOException;
import java.net.ServerSocket;

/**
 * ubante 7/22/14 3:33 PM
 * This is very serious business.
 */
public class MulticlientServer2 {

    public static void main(String[] args) throws IOException {

        int portNumber = 1933;
        boolean listening = true;

        try (ServerSocket serverSocket = new ServerSocket(portNumber)) {
            while (listening) {
                System.out.println("Creating a new thread.");
                new RequestThread(serverSocket.accept()).start();
            }
        } catch (IOException ioe) {
            System.out.println("Exception caught when trying to open a socket on port " + portNumber);
            ioe.printStackTrace();
        }
    }
}
