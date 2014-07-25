package com.ubante.oven.sockets;

import java.io.IOException;
import java.net.ServerSocket;

/**
 * ubante 7/22/14 3:33 PM
 * This is very serious business.
 */
public class MulticlientServer {
    int portNumber = 1933;
    boolean listening = true;

    void start() {
        System.out.println("Starting server.");
        try (ServerSocket serverSocket = new ServerSocket(portNumber)) {
            while (listening) {
                new RequestThread(serverSocket.accept()).start();
            }
        } catch (IOException ioe) {
            System.out.println("Exception caught when trying to open a socket on port " + portNumber);
            ioe.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        MulticlientServer server = new MulticlientServer();
        server.start();

    }
}
