package com.ubante.oven.strings;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * ubante 7/22/14 10:04 AM
 * This is very serious business.
 */
public class SimpleScanner {

    public static void main(String[] args) throws IOException {
        String aString = "asdfsdf";
        String bString = "sdf'sdfsdf'sdfs 'sdf sd' dsf sdf ";
        String longString = "        'VideoDate':0, 'Signature':'d0fce6a273b7f201a6487909b6218ff6', 'VideoLength':-1," +
                "'Size':10116                                                                       " +
                " { 'AdultFlag':false,      " +
                " 'MediaUrlHash':'uipESujyCkrefA',  " +
                " 'MediaType':'I',                   " +
                " 'MediaUrl':'http://l.yimg.com/a/i/us/crsl/messenger/09q2/emoticon_smiley.jpg',  " +
                " 'FileType':'jpeg',   " +
                " 'Height':75, " +
                " 'Width':75,";

        Scanner scanner = new Scanner(System.in);
        Scanner mockResponseScanner = new Scanner (new File("/home/ubante/tmp/mockResponse.json"));
        Scanner longsScanner = new Scanner (new File("/home/ubante/tmp/longs"));


        while (longsScanner.hasNextLong()) {
            System.out.println("this is a long: " + longsScanner.nextLong());
        }

        int counter = 0;
        while (mockResponseScanner.hasNext() && counter < 4) {
            counter++;
            System.out.println(mockResponseScanner.next());
        }

//            return new java.util.Scanner(is).useDelimiter("\\A").next();


        //          return Response.ok(convertStreamToString(in)).build();


    }
}
