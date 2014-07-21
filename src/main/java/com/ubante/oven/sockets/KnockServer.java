package com.ubante.oven.sockets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * From oracle.com
 */
public class KnockServer {

    public static void main(String[] args) {

        if (args.length != 1) {
            System.err.println("Usage: java KnockServer <port number>");
            System.exit(1);
        }

        int portNumber = Integer.parseInt(args[0]);

        try (
                ServerSocket serverSocket = new ServerSocket(portNumber);
                Socket clientSocket = serverSocket.accept();
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(clientSocket.getInputStream()));
                ) {

            String inputLine;
            String outputLine;

            // Initiate conversation with client
            KnockProtocol kp = new KnockProtocol();
            outputLine = kp.processInput(null);
            out.print(outputLine);

            while ((inputLine = in.readLine()) != null) {
                outputLine = kp.processInput(inputLine);
                out.println(outputLine);
                if (outputLine.equals("Bye.")) { break; }
            }

        } catch (IOException e) {
            System.out.println("Failed to bind to port " + portNumber + " or failed to get stream from socket.");
            System.out.println(e.getStackTrace());
        }
    }
}
