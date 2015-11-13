package com.ubante.oven.hearthstone.hearthstonebad;

import java.util.ArrayList;
import java.util.List;

/**
 * from http://stackoverflow.com/questions/8189466/java-util-concurrentmodificationexception
 * to understand why I'm getting a java.util.ConcurrentModificationException in GameGenerator
 */
public class RemoveListElementDemo {
  private static final List<Integer> integerList;

  static {
    integerList = new ArrayList<Integer>();
    integerList.add(1);
    integerList.add(2);
    integerList.add(3);
//    integerList.add(4);
//    integerList.add(5);
  }

  public static void remove(Integer remove) {
    for(Integer integer : integerList) {
      if(integer.equals(remove)) {
        integerList.remove(integer);
      }
    }
  }

  public static void main(String... args) {
    System.out.printf("1: %s\n\n", integerList);

    remove(Integer.valueOf(2));
    System.out.printf("2: %s\n\n", integerList);

    Integer removeThis = Integer.valueOf(3);
    for(Integer integer : integerList) {
      if(integer.equals(removeThis)) {
//        integerList.remove(integer);
      }
    }
    System.out.printf("3: %s\n\n", integerList);

  }
}