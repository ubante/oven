package com.ubante.oven.gameoflife;

/**
 * Created by J on 11/29/2015.
 */
public class Simulator {
  int boardSizeX;
  int boardSizeY;
  Board board;

  public void setBoardSize(int boardSize) {
    boardSizeX = boardSize;
    boardSizeY = boardSize;
    board = new Board(boardSize);
  }

  public void setBoardSize(int x, int y) {
    boardSizeX = x;
    boardSizeY = y;
    board = new Board(x, y);
  }

  /**
   *   .......
   *   ...X...
   *   ....X..
   *   ..XXX..
   *   .......
   */
  void setGlider() {
    board.activatePoint(3, 1);
    board.activatePoint(4, 2);
    board.activatePoint(2, 3);
    board.activatePoint(3, 3);
    board.activatePoint(4, 3);
  }

  void go() {
    board.print();

  }

  public static void main(String[] args) {
    System.out.println("Let the life begin.");

    Simulator sim2 = new Simulator();
    sim2.setBoardSize(80, 20);
    sim2.setGlider();
    sim2.go();
  }
}
