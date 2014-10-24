package com.ubante.oven.answers;

/**
 * Created by ubante on 10/23/14.
 */
public class SevenThousandArea {

    public static void main(String[] args) {
        for ( int i=100; i < 200; i++ ) {
            int area = i*i*i + 5*i*i - 2450000;
            System.out.println("With x = " + i + ", remainder is " + area);
        }
    }

}


// With x = 500, remainder is 123800000
// With x = 300, remainder is 25000000
// With x = 132, remainder is -62912
//With x = 133, remainder is -8918
//        With x = 134, remainder is 45884
//        With x = 135, remainder is 101500