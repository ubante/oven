package com.ubante.oven.dependencies;

/**
 * Created by J on 10/28/2015.
 */
public class ThingRunner {


  public static void main(String[] args) {
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
  }

}
