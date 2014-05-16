package com.ubante.oven.cameralensmatching;

/**
 * Created by J on 5/15/2014.
 */
public class Camera {
    String name;
    Lens lens = null;
    double cropFactor;
    double RULE = 600;
    double sensorWidth;

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

    void attachLens(Lens l) throws LensDuntFitException {

        if (l.isEFS && cropFactor==1) {
            throw new LensDuntFitException(l.toString()+" dunt fit on a "+toString());
        }
        lens = l;
    }

    double getAngleOfView() {
//        double aov = sensorWidth / (2*lens.focalLength);
        double aovRadians = 2*Math.atan(sensorWidth / (2*lens.focalLength));
        return aovRadians / Math.PI * 180;
    }

    /**
     * Return the ISO needed for this combination to look "good".  The exposure for Sunny16 is
     * eV_100 = 15 (see http://en.wikipedia.org/wiki/Exposure_value).  We're looking for
     * @return ISO
     */
    double getISO() {
        double sunny16Multiple = Math.pow(16/lens.aperture,2);
        return 0;
    }

    /**
     * Score = (aperture area) × (angular area) × (suggested shutter speed)
     * Reference: http://www.lonelyspeck.com/best-lenses-for-milky-way-photography-canon/
     * @return score
     */
    int getScore() {

        return 1;
    }

    void printReport() {
        System.out.printf("%4s: ",toString());
//        System.out.print(toString() + ": ");
        if (lens == null) {
            System.out.println("no lens");
            return;
        }

        double blurThreshold = RULE / lens.focalLength / cropFactor; // in seconds
        System.out.printf("%15s - blurs in %3.1f seconds - AoV = %3f - ISO = %.0f\n",
                lens.toString(),blurThreshold,getAngleOfView(),getISO());

        return;
    }

    public static void main(String[] args) {
//        Camera c = new Camera(1.0,"5D3");
        Camera c = new Camera(1.6,"60D");

//        Lens l = new Lens(10,3.5,true);
        Lens l = new Lens(14,2.8);
        try {
            c.attachLens(l);
        } catch (LensDuntFitException ldfe) {
            ldfe.printStackTrace();
            System.exit(1);
        }
        c.printReport();

        Lens l2 = new Lens(10,3.5,true);
        try {
            c.attachLens(l2);
        } catch (LensDuntFitException ldfe) {
            ldfe.printStackTrace();
            System.exit(1);
        }
        c.printReport();


    }
}
