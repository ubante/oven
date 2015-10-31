package com.ubante.oven.hearthstone;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * java.util.ConcurrentModificationExceptions make you stronger
 */
public class CrushTheCme {

  static ArrayList<String> getArrayList() {
    ArrayList<String> al = new ArrayList<>();
    al.add("one");
    al.add("two");
    al.add("three");
    al.add("four");

    return al;
  }
  static void loopBadly() {
    ArrayList<String> al = getArrayList();

    for (String s: al) {
      if (s.equals("two")) { al.remove(s); }
      else { System.out.println(s); }
    }
  }

  static void loopGoodly() {
    ArrayList<String> al = getArrayList();

    Iterator itr = al.iterator();
    while (itr.hasNext()) {
      String s = (String) itr.next();
      if (s.equals("two")) { itr.remove(); }
      else System.out.println(s);
    }
  }

  static void loopBestly() {
    ArrayList<String> al = getArrayList();

    Iterator itr = al.iterator();
    while (itr.hasNext()) {
      String s = (String) itr.next();
      if (s.equals("two")) { itr.remove(); }
      else System.out.println(s);
    }
  }

  public static void main(String[] args) {
//    loopBadly();
    System.out.printf("\n\n");
    loopGoodly();
    System.out.printf("\n\n");
    loopBestly();
  }
}
