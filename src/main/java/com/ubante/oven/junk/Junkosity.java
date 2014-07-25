package com.ubante.oven.junk;

/**
 * ubante 7/15/14 11:25 AM
 * This is very serious business.
 */
public class Junkosity {
    public static void main(String[] args) {
        String big = "zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz";
        System.out.println("Length: " + big.length());

        StringBuilder sb = new StringBuilder();
        sb.append("aaaaaaaa");
        sb.append("bbbbbbbbbbbb");
        sb.append("cccccccccc");
        System.out.printf("Length: %d\n", sb.length());
    }
}
