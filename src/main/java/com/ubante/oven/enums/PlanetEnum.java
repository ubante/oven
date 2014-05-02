package com.ubante.oven.enums;

/**
 * ubante 1/23/14 1:49 PM
 * This is very serious business.
 */
public enum PlanetEnum {
    MERCURY (3.303e+23, 2.4397e6),
    VENUS   (4.869e+24, 6.0518e6),
    EARTH   (5.976e+24, 6.3781e6),
    JUPITER (1.9e+27,   7.1492e7);

    // fields
    private final double mass;
    private final double radius;

    // constants
    public static final double G = 6.67300e-11;

    // constructor
    PlanetEnum(double mass, double radius) {
        this.mass = mass;
        this.radius = radius;
    }

    // getters
    private double getMass() { return mass; }
    private double getRadius() { return radius; }

    // methods
    double surfaceGravity() { return G * mass / (radius * radius); }
    double surfaceWeight(double otherMass) { return otherMass * surfaceGravity(); }

    // usage
    static void printUsage() {
        System.err.println("Usage: java PlanetEnum <earth_weight>");
        System.exit(-1);
    }

    // main
    public static void main(String[] args) {
        //if (args.length != 1) { printUsage(); }

        //double earthWeight = Double.parseDouble(args[0]);
        double earthWeight = Double.parseDouble("100");
        double mass = earthWeight / EARTH.surfaceGravity();

        for (PlanetEnum p : PlanetEnum.values())
            System.out.printf("Your weight on %s is %f\n", p, p.surfaceWeight(mass));

    }
}

