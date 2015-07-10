package com.ubante.oven.yarr;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by J on 3/14/2015.
 */
public class Plank {
  private List<Plank> leaves = new LinkedList<Plank>();
  private Plank parent = null;
  private String data;

  public Plank(String data, Plank parent) {
    this.data = data;
    this.parent = parent;
  }
}