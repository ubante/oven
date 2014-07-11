package com.ubante.oven.sockets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * ubante 7/10/14 3:43 PM
 * This is very serious business.
 */
public class KnockClient {
    public static void main(String[] args) {

        if (args.length != 2) {
            System.err.println("Usage: java KnockClient <host name> <por number>");
            System.exit(1);
        }

        String hostName = args[0];
        int portNumber = Integer.parseInt(args[1]);

        try (
                Socket kkSocket = new Socket(hostName, portNumber);
                PrintWriter out = new PrintWriter(kkSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(kkSocket.getInputStream()));
                ) {

            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
            String fromServer;
            String fromUser;

            while ((fromServer = in.readLine()) != null) {
                System.out.println("Server: " + fromServer);
                if (fromServer.equals("Bye.")) { break; }

                fromUser = stdIn.readLine();
                if (fromUser != null) {
                    System.out.println("Client: " + fromUser);
                    out.println(fromUser);
                }
            }
        } catch (UnknownHostException uhe) {
            System.err.println("You gave a hostname I cannot resolve.");
            uhe.getStackTrace();
            System.exit(2);
        } catch (IOException ioe) {
            System.err.println("I can't bind to the port (" + portNumber +
                    "), get from the socket or write to the socket.");
            ioe.getStackTrace();
            System.exit(3);
        }
    }
}
