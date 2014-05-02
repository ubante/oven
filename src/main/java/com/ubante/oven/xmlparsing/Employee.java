package com.ubante.oven.xmlparsing;


/**
 * ubante 4/8/14 2:19 PM
 * This is very serious business.
 */
public class Employee {
    String id;
    String firstName;
    String lastName;
    String location;

    @Override
    public String toString() {
        return firstName+" "+lastName+"("+id+")"+location;
    }

}
