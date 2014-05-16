package com.ubante.oven.cameralensmatching;

/**
 * Created by J on 5/15/2014.
 */
public class Lens {
    int focalLength;
    double aperture;
    boolean isEFS;
    String name;

    Lens(int focalLength, double aperture, boolean isEFS) {
        this.focalLength = focalLength;
        this.aperture = aperture;
        this.isEFS = isEFS;

        String prefix;
        if (isEFS) {
            prefix = "EF-S";
        } else {
            prefix = "EF";
        }
        name = String.format("%s %dmm f/%2.1f", prefix, focalLength, aperture);
    }

    Lens(int focalLength, double aperture) {
        this(focalLength, aperture, false);
    }



    @Override
    public String toString() {
//        return String.format("%dmm f/%2.1f",focalLength, aperture);
        return name;
    }

    public static void main(String[] args) {
        Lens l = new Lens(10,3.5);
        System.out.println(l.toString());
    }
}
