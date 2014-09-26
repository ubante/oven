package com.ubante.oven.ctf;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 Sending password
 Receiving response
 1: skipping the question prompt
 2: 1848901157, total = 298582490
 3: 1080315539, total = 1365750598
 4: 1444082597, total = 2069151648
 5: 972904382, total = 2169989089
 6: 252010024, total = 2186414520
 7: 2534798372, total = 3946583443
 8: 3689202719, total = 4552348019
 9: 4249892944, total = 4597422370
 10: 2215106566, total = 6677283099
 11: 604594834, total = 7146430088
 12: 799734573, total = 7420437338
 13: 2816406350, total = 8898998283
 14: 1890920328, total = 9155561602
 15: 1241297740, total = 10061747509
 16: 1943964451, total = 10265266705
 17: 2671846269, total = 11888387731
 18: 1668524351, total = 12367347027
 19: 1057131105, total = 12383957745
 20: 2939752747, total = 13739172293
 21: 1807176249, total = 14079479691
 22: 2306618037, total = 16067828949
 23: 562224416, total = 16579346356
 24: 1449439055, total = 17277390948
 25: 1570543774, total = 17854330821
 26: 2066406032, total = 17935408436
 27: 2961150092, total = 19269225639
 28: 1464429614, total = 19952279672
 29: 1357195781, total = 20742567538
 30: 2500835208, total = 22536699625
 31: 3337227677, total = 23494439243
 32: 4256121972, total = 23533284566
 33: 2674026195, total = 25154225666
 34: assume the last 8 values are to be ignored
 35: assume the last 8 values are to be ignored
 36: assume the last 8 values are to be ignored
 37: assume the last 8 values are to be ignored
 38: assume the last 8 values are to be ignored
 39: assume the last 8 values are to be ignored
 40: assume the last 8 values are to be ignored
 41: assume the last 8 values are to be ignored


 offering 25154225666 as the answer
 Better luck next time
 */
public class Wrapper {

    static String generateLongNumber(int numberLength) {
        String longNumber = "";

        for (int i=0; i<numberLength; i++) {
            longNumber += i % 10;
        }

        return longNumber;
    }


    public static void main(String[] args) {
        int PORTNUMBER = 9876;
        String HOSTNAME = "yctf23.pwn-u.org";
        String password = "not_so_fast_my_young_friend";
        String veryLongNumber = generateLongNumber(500000);

        try {
            // open socket
            Socket echoSocket = new Socket(HOSTNAME, PORTNUMBER);
            PrintWriter out =
                    new PrintWriter(echoSocket.getOutputStream(), true);
            BufferedReader in =
                    new BufferedReader(
                            new InputStreamReader(echoSocket.getInputStream()));

            // send password
            System.out.println("Sending password");
            out.println(password);

            // collect response
            System.out.println("Receiving response");

            String numberString = null;
            Long total = 0L;

            for (int i=1; i<=41; i++) {
                System.out.printf("%d: ",i);

                numberString = in.readLine();
                if (i==1) {
                    System.out.println("skipping the question prompt");
                    continue;
                }

                if (i>33) {
                    System.out.println("assume the last 8 values are to be ignored");
                    continue;
                }

                OnesComplement o = new OnesComplement(Long.valueOf(numberString));
                total += o.onesComplementDecimal;
//                System.out.println(numberString + ", total = " + total);

                System.out.printf("%13s\t%40s\t%40s\t%13d\t%13d\n",
                        numberString,
                        o.binary,
                        o.onesComplement,
                        o.onesComplementDecimal,
                        total);

            }

            // Choose one of the below to leave uncommented

            // give the total
//            System.out.printf("\n\noffering %s as the answer\n", total);
//            out.println(total);

            // try a buffer overflow
            // Long.MAX_VALUE: 9223372036854775807
//            String bufferOverflowValue = "92233720368547758070";
//            System.out.printf("\n\ntrying a buffer overflow: %s\n", bufferOverflowValue);
//            out.println(bufferOverflowValue);

            // try a buffer overflow 2
            String bufferOverflowValue = veryLongNumber;
            System.out.printf("\n\ntrying a buffer overflow with %d digits: %s\n",
                    bufferOverflowValue.length(),
                    bufferOverflowValue);
            out.println(bufferOverflowValue);

            // try the decimal value of the ones complement to the constantly recurring
            // non-zero value
//            System.out.println("\n\ntrying 8631 just because");
//            out.println(8631);

            // get the response
            String response = in.readLine();
            System.out.println(response);

            // clean up
            echoSocket.close();

        } catch (UnknownHostException e) {
            System.out.println("Don't know about host " + HOSTNAME);

        } catch (IOException e) {
            System.out.println("IOE");
        }
    }
}
