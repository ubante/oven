package com.ubante.oven.gameoflife;

import java.util.ArrayList;

/**
 * Created by J on 11/30/2015.
 */
public class Cell {
  Boolean isAlive;
  ArrayList<Cell> neighbors = new ArrayList<>();

  Cell() {}

  void activate() {
    isAlive = true;
  }

  void deactivate() {
    isAlive = false;
  }

  void addNeighbors(Cell c) {
    neighbors.add(c);
  }

  int getLivingNeighborCount() {
    int count = 0;

    for (Cell n : neighbors) {
      if (n.isAlive) { count++; }
    }

    return count;
  }

  /**
   * If this cell is alive, it dies unless it has exactly 2 or 3 living neighbors.
   * If this cell is dead, it lives unless it has exactly 3 living neighbors.
   * @return
   */
  public Boolean shouldLive() {
    Boolean decision = false;

    if (isAlive) {
      if ((getLivingNeighborCount()==2) || (getLivingNeighborCount()==3)) {
        decision = true;
      }
    } else {
      if (getLivingNeighborCount() == 3) {
        decision = true;
      }
    }

    return decision;
  }
}
