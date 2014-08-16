package com.ubante.oven.strings;

/**
 * ubante 8/15/14 4:41 PM
 * This is very serious business.
 */
public class StringBuilderBuilder {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("start ");
        System.out.println(sb.toString());

        sb.append(" and more");
        System.out.println(sb.toString());
    }
}
