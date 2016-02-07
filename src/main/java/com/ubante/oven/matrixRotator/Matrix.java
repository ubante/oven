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

      for (int offset=0; offset<(size-(2 * squareCounter)-1); offset++) {
        System.out.println("- offset=" + offset);

        int rememberThis = m[squareCounter][squareCounter+offset];

        // left side to top
        System.out.printf("Row %d, column %d (%d) moved to row %d, column %d (%d)\n",
            size-squareCounter-offset-1, squareCounter, m[size-squareCounter-offset-1][squareCounter],
            squareCounter, squareCounter+offset, m[squareCounter][squareCounter+offset]);
        m[squareCounter][squareCounter+offset] = m[size-squareCounter-offset-1][squareCounter];

        // bottom to left side
        System.out.printf("Row %d, column %d (%d) moved to row %d, column %d (%d)\n",
            size-squareCounter-1, size-squareCounter-offset-1, m[size-squareCounter-1][size-squareCounter-offset-1],
            size-squareCounter-offset-1, squareCounter, m[size-squareCounter-offset-1][squareCounter]);
        m[size-squareCounter-offset-1][squareCounter] = m[size-squareCounter-1][size-squareCounter-offset-1];

        // right side to bottom
        System.out.printf("Row %d, column %d (%d) moved to row %d, column %d (%d)\n",
            squareCounter+offset, size-squareCounter-1, m[squareCounter+offset][size-squareCounter-1],
            size-squareCounter-1, size-1-squareCounter-offset, m[size-squareCounter-1][size-1-squareCounter-offset]);
        m[size-squareCounter-1][size-1-squareCounter-offset] = m[squareCounter+offset][size-squareCounter-1];

        // top to right side
        System.out.printf("Row %d, column %d (%d) moved to row %d, column %d (%d)\n",
            squareCounter, squareCounter+offset, m[squareCounter][squareCounter+offset],
            squareCounter+offset, size-1-squareCounter, m[squareCounter+offset][size-1-squareCounter]);
        m[squareCounter+offset][size-1-squareCounter] = rememberThis;

      }
    }
  }
}
