package com.ubante.oven.hash;

import java.util.Enumeration;
import java.util.Hashtable;

/**
 * Created by J on 11/8/2015.
 */
public class LearnByDoing {

  public static void main(String[] args) {

    Hashtable<String, Integer> numbers
        = new Hashtable<String, Integer>();
    numbers.put("one", 1);
    numbers.put("two", 2);
    numbers.put("three", 3);

    Integer n = numbers.get("two");
    if (n != null) {
      System.out.println("two = " + n);
    }

    String x2 = "two";
    numbers.put(x2, numbers.get(x2)+1);

    String x4 = "four";
    if (numbers.containsKey(x4)) {
      numbers.put(x4, numbers.get(x4) + 1);
    } else {
      numbers.put(x4, 1);
    }

    n = numbers.get("two");
    if (n != null) {
      System.out.println("two = " + n);
      System.out.println("two = " + n);
    }

    // loop through the enum
    Enumeration<String> keys = numbers.keys();
    while (keys.hasMoreElements()) {
      String k = keys.nextElement();
      String line = String.format("%s -> %d", k, numbers.get(k));
      System.out.println(line);
    }

    //        numbers.put(x4, numbers.get(x4) + 1);


    System.out.println();
  }
}
