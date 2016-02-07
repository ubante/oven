package com.ubante.oven.matrixRotator;

/**
 * Saw this puzzle on youtube.
 *
 * Given a square matrix, rotate it clockwise
 *
 */
public class Rotator {


  public static void main(String[] args) {
    Matrix m = new Matrix(8);
    m.display();
    m.rotate();
    m.display();
  }

}
