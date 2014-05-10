package com.ubante.oven.effectivejava;

/**
 * Created by J on 5/9/2014.
 */
public class CameraBuilder {

    private final String model, name, size, condition, brand;
    private String style;
    private final int modelVersion, count;

    public static class Builder {
        // Required fields
        private final String model;
        private final int modelVersion;

        // Optional parameters
        private String condition = "new";
        private String name = "unknownName";
        private String brand = "unknownBrand";
        private String size = "unknownSize";
        private String style = "unknownSize";
        private int count = -1;

        public Builder(String model, int modelVersion) {
            this.model = model;
            this.modelVersion = modelVersion;
        }

        public Builder condition(String val) {
            condition = val; return this; }

        public Builder name(String val) {
            name = val; return this; }

        public Builder brand(String val) {
            brand = val; return this; }

        public Builder size(String val) {
            size = val; return this; }

        public Builder style(String val) {
            style = val; return this; }

        public Builder count(int val) {
            count = val; return this; }

        public CameraBuilder build() {
            return new CameraBuilder(this);
        }
    }

    private CameraBuilder(Builder builder) {
        model           = builder.model;
        modelVersion    = builder.modelVersion;
        name            = builder.name;
        condition       = builder.condition;
        style           = builder.style;
        brand           = builder.brand;
        size            = builder.size;
        count           = builder.count;
    }

    void print() {
        System.out.println("\nThis camera has these values:");
        System.out.printf("%15s: %-15s\n","model",model);
        System.out.printf("%15s: %-15s\n","modelVersion",modelVersion);
        System.out.printf("%15s: %-15s\n","condition",condition);
        System.out.printf("%15s: %-15s\n","name",name);
        System.out.printf("%15s: %-15s\n","brand",brand);
        System.out.printf("%15s: %-15s\n","style",style);

    }

    public static void main(String[] args) {
        CameraBuilder c = new CameraBuilder.Builder("5D", 3).condition("fair").brand("Canon").build();
        c.print();

        c.style = "SLR";
        c.print();

        // Final is final
//        c.name = "Wilson";


    }
}
