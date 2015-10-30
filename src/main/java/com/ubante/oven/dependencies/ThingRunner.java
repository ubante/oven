package com.ubante.oven.dependencies;

import java.util.ArrayList;

/**
 * Created by J on 10/28/2015.
 */
public class ThingRunner {
  private ArrayList<Thing> list = new ArrayList<>();

  void add(String s) {
    Thing t = new Thing(s);
    list.add(t);
  }

  void add(String a, String b) {
    // First look for the first object
    for (Thing t: list) {
      if (t.isNamed(a)) {
        Thing tDown = t.makeDownstream(b);
        list.add(tDown);
        return;
      }
    }

    // Failing that, look for the second object
    for (Thing t: list) {
      if (t.isNamed(b)) {
        Thing tUp = t.makeUpstream(a);
        list.add(tUp);
        return;
      }
    }
  }

  void display() {
    for (Thing t: list) {
      System.out.println(t);
    }
  }


  public static void main(String[] args) {
    ThingRunner tr = new ThingRunner();
    tr.add("benny");
    tr.add("alice", "benny");
    tr.add("benny", "carter");
    tr.add("benny", "cathey");
    tr.display();

    System.out.println("-----------------------------------");
    Thing aThing = new Thing("a");
    System.out.println(aThing);

    Thing a1 = new Thing("a1");
    aThing.addUpstream(a1);
    System.out.println(aThing);

    Thing bThing = new Thing("b");
    Thing b1 = bThing.makeUpstream("b1");
    Thing b2 = bThing.makeDownstream("b2");
    System.out.println(bThing);
    System.out.println(b1);

    Thing b1a = bThing.makeUpstream("b1a");
    System.out.println(bThing);

  }

}
