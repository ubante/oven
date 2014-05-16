package com.ubante.oven.cameralensmatching;

/**
 * Created by J on 5/15/2014.
 */
public class Camera {
    String name;
    Lens lens = null;
    double cropFactor;
    double RULE = 500;
    double sensorWidth;
    double blurThreshold;

    Camera(double cF,String name) {
        cropFactor = cF;
        this.name = name;
        sensorWidth = 36 / cropFactor;
    }

    Camera(String name) { this(1.6,name); }

    @Override
    public String toString() {
        return name;
    }

//    void attachLens(Lens l) throws LensDuntFitException {

//        if (l.isEFS && cropFactor==1) {
//            throw new LensDuntFitException(l.toString()+" dunt fit on a "+toString());
//        }
//        lens = l;
//    }

    void attachLens(Lens l) {
        if (l.isEFS && cropFactor==1) {
            System.out.println(l.toString()+" dunt fit on a "+toString());
            System.exit(2);
        }
        lens = l;
    }

    double getAngleOfView() {
        double aovRadians = 2*Math.atan(sensorWidth / (2*lens.focalLength));
        return aovRadians / Math.PI * 180;
    }

    /**
     * Return the ISO needed for this combination to look "good".  The exposure for Sunny16 is
     * eV_100 = 15 (see http://en.wikipedia.org/wiki/Exposure_value).  We're looking for eV = -5.
     * This will get us close and we'll work it in post.
     *
     * Aurora borealis and australis
     *          Bright	−4 to −3
     *          Medium	−6 to −5
     * Milky Way galactic center	−11 to −9
     *
     * @return ISO
     */
    double getISO() {
        int darknessEV = -3;
        double apertureAdvantage = Math.pow(16/lens.aperture,2);
        double shutterSpeedAdvantage = blurThreshold/(1.0/125);
        double darknessDisadvantage = Math.pow(2,(15 - darknessEV));
        double iso = darknessDisadvantage/shutterSpeedAdvantage/apertureAdvantage*100;

//        System.out.println("Aperture = "+apertureAdvantage);
//        System.out.println("Shutter  = "+shutterSpeedAdvantage);
//        System.out.println("Darkness = "+darknessDisadvantage);
//        System.out.println("\nISO = "+iso);

        return iso;
    }

    /**
     * Score = (angular area)^2 × (shutter speed) / ISO
     * Reference: http://www.lonelyspeck.com/best-lenses-for-milky-way-photography-canon/
     * @return score
     */
    double getScore() {
        double score = getAngleOfView()*getAngleOfView() * blurThreshold / getISO();

        return score;
    }

    static void printReportHeader() {
        System.out.printf("%6s %16s %14s %3s %5s %5s\n",
                "camera",
                "lens",
                "blur-limit",
                "AoV",
                "ISO",
                "score");
        System.out.printf("%6s %16s %14s %3s %5s %5s\n",
                "------","----------------","--------------","---","-----","-----");
    }

    void printReport() {
        System.out.printf("%6s ",toString());
//        System.out.print(toString() + ": ");
        if (lens == null) {
            System.out.println("no lens");
            return;
        }

        blurThreshold = RULE / lens.focalLength / cropFactor; // in seconds
        System.out.printf("%16s  %5.1f seconds %3.0f %5.0f %5.0f\n",
                lens.toString(),blurThreshold,getAngleOfView(),getISO(),getScore());

        return;
    }

    public static void main(String[] args) {
//        Camera c = new Camera(1.0,"5D3");
        Camera c = new Camera(1.6,"60D");

        Camera.printReportHeader();

//        System.out.printf("%6s %16s %14s %3s %5s %5s\n",
//                "camera",
//                "lens",
//                "blur-threshold",
//                "AoV",
//                "ISO",
//                "score");
//        System.out.printf("%6s %16s %14s %3s %5s %5s\n",
//                "------","----------------","--------------","---","-----","-----");

        Lens l = new Lens(14,2.8);
        c.attachLens(l);
        c.printReport();

        Lens l2 = new Lens(10,3.5,true);
        c.attachLens(l2);
        c.printReport();

        c.attachLens(new Lens(24,1.4));
        c.printReport();

        c = new Camera(1.0, "5D3");
        c.attachLens(new Lens(16,4));
        c.printReport();

        c.attachLens(new Lens(14,2.8));
        c.printReport();



    }
}
