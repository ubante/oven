package com.ubante.oven.cameralensmatching;

import java.util.ArrayList;
import java.util.List;

/**
 * Check out goo.gl/iU13yN for a great google spreadsheet comparing lens for the purpose of
 * astrophotography.
 */
public class MixerMatcher {


    public static void main(String[] args) {
        Camera FiveD = new Camera(1.0, "5D3");
        List cropCameras = new ArrayList<>();
        cropCameras.add(new Camera("60d"));
        cropCameras.add(new Camera("XS"));
        cropCameras.add(new Camera("T3i"));

        List<Lens> lenses = new ArrayList<>();

        // I got these
        lenses.add(new Lens(8,2.8));
        lenses.add(new Lens(14,2.8));
        lenses.add(new Lens(10,3.5,true));
        lenses.add(new Lens(17,4));
        lenses.add(new Lens(17,2.8,true));
        lenses.add(new Lens(28,1.8));
        lenses.add(new Lens(50,1.8));
        lenses.add(new Lens(40,2.8));

        // suggested by http://www.lonelyspeck.com/best-lenses-for-milky-way-photography-canon/
        lenses.add(new Lens(24,1.4,"lonelyspeck"));
        lenses.add(new Lens(35,1.4,"lonelyspeck"));
        lenses.add(new Lens(16,2.0,true,"lonelyspeck"));
        lenses.add(new Lens(10,2.8,true,"lonelyspeck"));
        lenses.add(new Lens(11,2.8,true,"lonelyspeck"));
        lenses.add(new Lens(12,2.0,true,"lonelyspeck"));

        // new Canon lenses
        lenses.add(new Lens(10,4.5,true,"new Canon lens"));
        lenses.add(new Lens(16,4.0,"new Canon lens"));

        // others
        lenses.add(new Lens(12,4.5,"beastly wide"));
        lenses.add(new Lens(18,1.8,true,"new Sigma 18-35 f/1.8"));

        Camera.printReportHeader();
        Camera xs = new Camera(1.6, "XS");
        for (Lens lens : lenses) {
            xs.attachLens(lens);
            xs.printReport();
        }

        Camera.printReportDivider();

        Camera fiveD = new Camera(1.0, "5D3", 2);
        for (Lens lens : lenses) {
            if (lens.isEFS) { continue; }

            fiveD.attachLens(lens);
            fiveD.printReport();
        }

    }
}

/** output as of May 16 2014
 camera             lens     blur-limit AoV   ISO score notes
 ------ ---------------- -------------- --- ----- ----- -----
 XS     EF 8mm f/2.8   39.1 seconds 109  5261   708
 XS    EF 14mm f/2.8   22.3 seconds  78  9207   117
 XS  EF-S 10mm f/3.5   31.3 seconds  97 10276   228
 XS    EF 17mm f/4.0   18.4 seconds  67 22817    29
 XS  EF-S 17mm f/2.8   18.4 seconds  67 11180    59
 XS    EF 28mm f/1.8   11.2 seconds  44  7610    22
 XS    EF 50mm f/1.8    6.3 seconds  25 13590     2
 XS    EF 40mm f/2.8    7.8 seconds  31 26307     2
 XS    EF 24mm f/1.4   13.0 seconds  50  3946    67 lonelyspeck
 XS    EF 35mm f/1.4    8.9 seconds  36  5755    16 lonelyspeck
 XS  EF-S 16mm f/2.0   19.5 seconds  70  5369   144 lonelyspeck
 XS  EF-S 10mm f/2.8   31.3 seconds  97  6577   356 lonelyspeck
 XS  EF-S 11mm f/2.8   28.4 seconds  91  7234   262 lonelyspeck
 XS  EF-S 12mm f/2.0   26.0 seconds  86  4027   385 lonelyspeck
 XS  EF-S 10mm f/4.5   31.3 seconds  97 16987   138 new Canon lens
 XS    EF 16mm f/4.0   19.5 seconds  70 21475    36 new Canon lens
 XS    EF 12mm f/4.5   26.0 seconds  86 20384    76 beastly wide
 XS  EF-S 18mm f/1.8   17.4 seconds  64  4892   116 new Sigma 18-35 f/1.8
 ------ ---------------- -------------- --- ----- ----- -----
 5D3     EF 8mm f/2.8   62.5 seconds 132  3288  6631
 5D3    EF 14mm f/2.8   35.7 seconds 104  5755  1349
 5D3    EF 17mm f/4.0   29.4 seconds  93 14261   359
 5D3    EF 28mm f/1.8   17.9 seconds  65  4756   322
 5D3    EF 50mm f/1.8   10.0 seconds  40  8493    37
 5D3    EF 40mm f/2.8   12.5 seconds  48 16442    36
 5D3    EF 24mm f/1.4   20.8 seconds  74  2466   919 lonelyspeck
 5D3    EF 35mm f/1.4   14.3 seconds  54  3597   235 lonelyspeck
 5D3    EF 16mm f/4.0   31.3 seconds  97 13422   436 new Canon lens
 5D3    EF 12mm f/4.5   41.7 seconds 113 12740   830 beastly wide
 */
