package com.ubante.oven.model.bullet;

import java.util.Calendar;

/**
 * Created by J on 4/7/2014.
 */
public class Photo {
    Calendar takenTime;

    Photo() {
        takenTime = Calendar.getInstance();
    }

    void print() {
        System.out.println(takenTime.getTime());
    }

    public static void main(String[] args) {
        Photo p = new Photo();
        p.print();
    }
}
