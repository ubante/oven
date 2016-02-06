package com.ubante.oven.matrixRotator;

/**
 * Objects hodor on 2D arrays
 */
public class Matrix {
  int m[][];
  int size;

  Matrix(int size) {
    this.size = size;
    m = new int[size][size];
    populate();
  }

  void populate() {
    int ctr = 0;

    for (int row=0; row<size; row++) {
      for (int column=0; column<size; column++) {
        ctr++;
        m[row][column] = ctr;
      }
    }
  }

  void display() {
    System.out.println("\nHere is the matrix:");

    for (int row=0; row<size; row++) {
      for (int column=0; column<size; column++) {
        System.out.printf("%2d ", m[row][column]);
      }
      System.out.println();
    }
  }

  void rotate() {
    int numOfInnerSquares = size/2;

    System.out.println();
    for (int squareCounter=0; squareCounter<numOfInnerSquares; squareCounter++) {
      System.out.println("Working on square layer #" + squareCounter);

      for (int offset=squareCounter; offset<(size-squareCounter-1); offset++) {
//        int firstCorner = m[squareCounter][squareCounter];
//        m[squareCounter][squareCounter] = m[size - squareCounter - 1][squareCounter];
//        m[size - squareCounter - 1][squareCounter] = m[size - squareCounter - 1][size - squareCounter - 1];
//        m[size - squareCounter - 1][size - squareCounter - 1] = m[squareCounter][size - squareCounter - 1];
//        m[squareCounter][size - squareCounter - 1] = firstCorner;
//        display();

        System.out.println("- offset=" + offset);
        System.out.printf("Row %d, column %d\n", squareCounter, squareCounter+offset);
        System.out.printf("Row %d, column %d\n", squareCounter+offset, size - squareCounter - 1);
        System.out.printf("Row %d, column %d\n", size - squareCounter - 1, size - squareCounter-offset - 1);
        System.out.printf("Row %d, column %d\n", size - squareCounter-offset - 1, squareCounter);
      }

      System.out.println();
    }
  }
}
