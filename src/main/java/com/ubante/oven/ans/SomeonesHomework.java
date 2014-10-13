package com.ubante.oven.ans;

/**
 * Created by ubante on 9/26/14.
 */
public class SomeonesHomework {
    double[] dArray = {4,5,6,7.5};
    String message = "some string: ";

    SomeonesHomework() {}

    boolean sumArray(double[] dd, String m) {
        double total = 0;
        for (double d: dd) { total += d; }
        System.out.println(m+total);

        if ((total % 2) == 0) { return true; }
        else { return false; }
    }

    void go() {

        if (sumArray(dArray, message)) {
            System.out.println("This is true");
        } else {
            System.out.println("This is false");
        }
    }

    public static void main(String[] args) {

        SomeonesHomework sh = new SomeonesHomework();

        sh.go();

    }
}
