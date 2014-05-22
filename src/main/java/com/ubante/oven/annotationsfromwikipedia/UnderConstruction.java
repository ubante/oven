package com.ubante.oven.annotationsfromwikipedia;

/**
 * Created by ubante on 5/22/14.
 */
public @interface UnderConstruction {
    String owner() default "Patrick Naughton";
    String value() default "Object is Under Construction.";
    String createdBy() default "Mike Sheridan";
    String lastChanged() default "2011-07-08";
}
