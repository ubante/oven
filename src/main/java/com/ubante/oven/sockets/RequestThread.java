package com.ubante.oven.sockets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.URL;

/**
 * ubante 7/22/14 3:35 PM
 * This is very serious business.
 */
public class RequestThread extends Thread {
    private Socket socket = null;

    public RequestThread(Socket socket) {
        super("RequestThread");
        this.socket = socket;
    }

    public void run() {

        int threadCounter = ThreadCounter.checkIn();
        System.out.println("Starting request thread #" + threadCounter);

        try (
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        ) {
            String inputLine = in.readLine();

            if (inputLine != null) {
                URL url = new URL(inputLine);
                System.out.println("Requesting: " + url.toString());
                String outputLine = "I love " + url.toString();
                out.println(outputLine);
            }

            socket.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        System.out.println("Ending request thread #" + threadCounter);

    }

}
