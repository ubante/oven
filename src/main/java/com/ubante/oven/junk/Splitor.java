package com.ubante.oven.junk;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

/**
 * Created by ubante on 5/21/14.
 */
public class Splitor {

    Splitor() {}


    public static void main(String[] args) {
        String[] parts = {"a","b","c","d","e","f","g","h","i"};
//        String[] parts = {"a"};
        System.out.println(StringUtils.join(parts, "/"));

        System.out.println(StringUtils.join(Arrays.asList(parts).subList(3, parts.length), "/"));


    }




}
