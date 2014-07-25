package com.ubante.oven.jsonmanipulation;


/**
 * ubante 5/27/14 6:44 PM
 * This is very serious business.
 */
public class Base64BackAndForth {

    public static void main(String[] args) {
        String originalString = "Hello, this is not encoded, World.";
        byte[] encoded = org.apache.commons.codec.binary.Base64.encodeBase64(originalString.getBytes());

        System.out.println("Original string: " + originalString);
        System.out.println("Encoded string:  " + new String(encoded));
    }
}
