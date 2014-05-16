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

        List<Lens> lenses = new ArrayList<>();
        lenses.add(new Lens(14,2.8));
        lenses.add(new Lens(10,3.5,true));
        lenses.add(new Lens(17,4));
        lenses.add(new Lens(17,2.8,true));
        lenses.add(new Lens(28,1.8));


        Camera.printReportHeader();
        Camera xs = new Camera(1.6, "XS");
        for (Lens lens : lenses) {
            xs.attachLens(lens);
            xs.printReport();
        }

        Camera fiveD = new Camera(1.0, "5D3");
        for (Lens lens : lenses) {
            if (lens.isEFS) { continue; }
            
            fiveD.attachLens(lens);
            fiveD.printReport();
        }

    }
}
