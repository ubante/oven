package com.ubante.oven.cameralensmatching;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by J on 5/15/2014.
 */
public class MixerMatcher {


    public static void main(String[] args) {
        Camera FiveD = new Camera(1.0, "5D3");
        List cropCameras = new ArrayList<>();
        cropCameras.add(new Camera("60d"));
        cropCameras.add(new Camera("XS"));
        cropCameras.add(new Camera("T3i"));

        List lenses = new ArrayList<>();
        lenses.add(new Lens(14,2.8));
        lenses.add(new Lens(10,3.5,true));
        lenses.add(new Lens(17,4));
        lenses.add(new Lens(17,2.8,true));
        lenses.add(new Lens(28,1.8));

        for (int i=1; i<=10; i++) {

        }
    }
}
