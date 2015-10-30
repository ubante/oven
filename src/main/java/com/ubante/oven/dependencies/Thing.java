package com.ubante.oven.dependencies;

import java.util.ArrayList;

/**
 * Created by ubante on 10/27/15.
 */
public class Thing {
  String name;
  ArrayList<Thing> upstream = new ArrayList<>();
  ArrayList<Thing> downstream = new ArrayList<>();

  Thing (String s) { name = s; }

  Thing makeUpstream(String s) {
    Thing up = new Thing(s);
    addUpstream(up);
    up.addDownstream(this);
    return up;
  }

  void addUpstream(Thing t) {
    upstream.add(t);
  }

  Thing makeDownstream(String s) {
    Thing down = new Thing(s);
    addDownstream(down);
    down.addUpstream(this);
    return down;
  }

  void addDownstream(Thing t) {
    downstream.add(t);
  }

  private String arraylistToString(ArrayList<Thing> al) {
    String s = "";
    for (Thing t: al) {
      s = s.concat(" ").concat(t.name);
    }

    return s;
  }

  @Override
  public String toString() {
    String out = String.format("              Name: %s\nUp: %-25s Down: %s\n",
        name, arraylistToString(upstream), arraylistToString(downstream));

    return out;
  }

//  @Override not needed since that method expects an Object
  public boolean isNamed(String s) {
    if (name.equals(s)) {
      return true;
    } else {
      return false;
    }
  }
}
