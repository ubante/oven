//package com.ubante.oven.annotationsfromwikipedia;
//
///**
// * Created by ubante on 5/22/14.
// */
//// This is the annotation to be processed
//// Default for Target is all Java Elements
//// Change retention policy to RUNTIME (default is CLASS)
//@Retention(RetentionPolicy.RUNTIME)
//public @interface TypeHeader {
//    // Default value specified for developer attribute
//    String developer() default "Unknown";
//    String lastModified();
//    String [] teamMembers();
//    int meaningOfLife();
//}
//
//// This is the annotation being applied to a class
//@TypeHeader(developer = "Bob Bee",
//        lastModified = "2013-02-12",
//        teamMembers = { "Ann", "Dan", "Fran" },
//        meaningOfLife = 42)
//
//public class SetCustomAnnotation {
//    // Class contents go here
//}
//
//// This is the example code that processes the annotation
//import java.lang.annotation.Annotation;
//        import java.lang.reflect.AnnotatedElement;
//
//public class UseCustomAnnotation {
//    public static void main(String [] args) {
//        Class<SetCustomAnnotation> classObject = SetCustomAnnotation.class;
//        readAnnotation(classObject);
//    }
//
//    static void readAnnotation(AnnotatedElement element) {
//        try {
//            System.out.println("Annotation element values: \n");
//            if (element.isAnnotationPresent(TypeHeader.class)) {
//                // getAnnotation returns Annotation type
//                Annotation singleAnnotation =
//                        element.getAnnotation(TypeHeader.class);
//                TypeHeader header = (TypeHeader) singleAnnotation;
//
//                System.out.println("Developer: " + header.developer());
//                System.out.println("Last Modified: " + header.lastModified());
//
//                // teamMembers returned as String []
//                System.out.print("Team members: ");
//                for (String member : header.teamMembers())
//                    System.out.print(member + ", ");
//                System.out.print("\n");
//
//                System.out.println("Meaning of Life: "+ header.meaningOfLife());
//            }
//        } catch (Exception exception) {
//            exception.printStackTrace();
//        }
//    }
//}
