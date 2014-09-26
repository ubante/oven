package com.ubante.oven.ctf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ubante 9/26/14 11:51 AM
 * This is very serious business.
 */
public class Fu {

    public static void main(String[] args) {

        Arrays.asList(1);

        List<Long> numbers =
                new ArrayList<Long>(Arrays.asList(1L, 2L, 3L, 4L));

        long x = 123;
        long y = Long.MAX_VALUE | x;

        System.out.println(x + " " + y);


    }
}
