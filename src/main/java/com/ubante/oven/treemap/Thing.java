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
  int groupValue;
  List<Thing> children = new ArrayList<>();

  Thing(String n, int v) {
    name = n;
    value = v;
    groupValue = v;
  }

  public String getName() {
    return name;
  }

  public int getValue() {
    return value;
  }

  public int getGroupValue() {
    return groupValue;
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

  public String toString() {
    String outputString;

    if (children.isEmpty()) {
      outputString = String.format("%s (%d)\n", name, value);
    } else {
      outputString = String.format("%s (%d | %d)\n", name, value, groupValue);
    }

    return outputString;
  }

  public int printChildren(int indentSize) {
    int valueSum = 0;

    for (Thing child : children) {
      child.printChildren(indentSize + 1);
      valueSum += child.getGroupValue();
      for (int i=0; i < indentSize; i++) {
        System.out.printf("-");
      }
      System.out.printf(" " + child.toString());
    }

    groupValue = value + valueSum;
    return valueSum;
  }
}

