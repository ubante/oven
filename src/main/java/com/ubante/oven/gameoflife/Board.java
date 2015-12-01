package com.ubante.oven.gameoflife;

/**
 * 0,0 is the upper left corner.
 */
public class Board {
  Boolean[][] board;
  Boolean[][] futureBoard;
  int sizeX;
  int sizeY;

  Board (int squareSize) {
    this(squareSize, squareSize);
  }

  Board(int sizeX, int sizeY) {
    this.sizeX = sizeX;
    this.sizeY = sizeY;
    board = new Boolean[sizeX][sizeY];

    for (int i = 0; i < sizeX; i++) {
      for (int j = 0; j < sizeY; j++) {
        deactivatePoint(i,j);
      }
    }
  }


  void activatePoint(int x, int y) {
    board[x][y] = true;
  }

  void deactivatePoint(int x, int y) {
    board[x][y] = false;
  }

  public String toString() {
    String output = "";

    for (int height = 0; height < sizeY; height++) {
      for (int width = 0; width < sizeX; width++) {
        if (board[width][height]) {
          output += "X";
        } else {
          output += ".";
        }
      }
      output += "\n";
    }

    return output;
  }

  void evolve() {
    for (int height = 0; height < sizeY; height++) {
      for (int width = 0; width < sizeX; width++) {


      }
    }
  }

  void print() {
    System.out.println(toString());
  }
}
