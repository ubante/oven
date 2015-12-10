package com.ubante.oven.treemap;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by J on 12/8/2015.
 */
public class Thing {
  String name;
  Thing parent;
  int value;
  List<Thing> children = new ArrayList<>();

  Thing(String n, int v) {
    name = n;
    value = v;
  }

  public String getName() {
    return name;
  }

  public Thing getParent() {
    return parent;
  }

  public void addChild(Thing child) {
    children.add(child);
  }

  public void setRoot() {
    parent = null;
  }

  public void setParent(Thing parent) {
    this.parent = parent;
    parent.addChild(this);
  }

  public void printChildren(int indentSize) {
    for (Thing child : children) {
      for (int i=0; i < indentSize; i++) {
        System.out.printf("-");
      }
      System.out.println(" " + child.getName());
      child.printChildren(indentSize+1);
    }
  }
}

