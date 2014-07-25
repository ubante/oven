package com.ubante.oven.strings;

/**
 * ubante 6/3/14 5:56 PM
 * This is very serious business.
 */
public class SubStringing {


    public static void main(String[] args) {
        int numberOfAsterisks = 8;
        String line = "********something: mascosas";

        System.out.println("Original: "+line);

        if (line.startsWith("********")) {
            System.out.println("line has asterisks");
            line = line.substring(numberOfAsterisks);
        }


        System.out.println("Skipping: " + line.substring(numberOfAsterisks));

        line = line.substring(numberOfAsterisks);

        System.out.println("Final:    "+line);

        String[] parts = line.split(":");
        System.out.println("\nFirst part: "+parts[0]);


        if (line.startsWith("*********")) {
            line = line.substring(numberOfAsterisks);
        }


        String overlyPaddedString = "{\"LastDownloadedContent\":\"some stuff we want\\\"extra quotes\\\" and the finish\"}";
        System.out.println("This is the original longline:");
        System.out.println(overlyPaddedString);

        System.out.println("This is the same minus the trailing chars:");
        int padding = 26;
        for (int i=0;i<padding;i++) {
            System.out.print(" ");
        }
        System.out.println(overlyPaddedString.substring(padding,overlyPaddedString.length()-2));

//        String response = "{        \"content_raw\":\"";
        String response = "ERROR: url not found.";
        String goodBeginning = "{";
        System.out.printf("\n\nHere is the response:\n%s\n", response);
        if (response.startsWith(goodBeginning)) {
            System.out.println("We have a good beginning.");
        } else {
            System.out.println("The response is not good - wrapping it:");
            String wrappedResponse = String.format("{ \"content_raw\":\"%s\"}",response);
            System.out.println(wrappedResponse);
        }


    }
}
