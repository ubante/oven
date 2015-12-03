package com.ubante.oven.gameoflife;

/**
 * Created by J on 11/29/2015.
 */
public class Simulator {
  int boardSizeX;
  int boardSizeY;
  Board currentBoard;
  Board futureBoard;

  public void setBoardSize(int boardSize) {
    boardSizeX = boardSize;
    boardSizeY = boardSize;
    currentBoard = new Board(boardSize);
  }

  public void setBoardSize(int x, int y) {
    boardSizeX = x;
    boardSizeY = y;
    currentBoard = new Board(x, y);
  }

  /**
   *   .......  .......  .......  .......
   *   ...X...  ..X.X..  ....X..  ..X....
   *   ....X..  ...XX..  ..X.X..  ...XX..
   *   ..XXX..  ...X...  ...XX..  ..XX...
   *   .......  .......  .......  .......
   */
  void setGlider(int startX, int startY) {
    currentBoard.activatePoint(startX+1, startY+0);
    currentBoard.activatePoint(startX+2, startY+1);
    currentBoard.activatePoint(startX+0, startY+2);
    currentBoard.activatePoint(startX+1, startY+2);
    currentBoard.activatePoint(startX+2, startY+2);
  }

  /**
   *    .....   .....
   *    ..X..   .....
   *    ..X..   .XXX.
   *    ..X..   .....
   *    .....   .....
   *
   * @param startX
   * @param startY
   */
  void setBlinker(int startX, int startY) {
    currentBoard.activatePoint(startX+0, startY+1);
    currentBoard.activatePoint(startX+1, startY+1);
    currentBoard.activatePoint(startX+2, startY+1);
  }

  /**
   *    ......  ...X..
   *    ..XXX.  .X..X.
   *    .XXX..  .X..X.
   *    ......  ..X...
   *
   * @param startX
   * @param startY
   */
  void setToad(int startX, int startY) {
    currentBoard.activatePoint(startX+1, startY+1);
    currentBoard.activatePoint(startX+2, startY+1);
    currentBoard.activatePoint(startX+3, startY+1);
    currentBoard.activatePoint(startX+0, startY+2);
    currentBoard.activatePoint(startX+1, startY+2);
    currentBoard.activatePoint(startX+2, startY+2);
  }

  void go() {
    for (int i = 0; i < 100; i++) {
      currentBoard.print();
      futureBoard = currentBoard.getNextGeneration();
      currentBoard = futureBoard;

      try {
        Thread.sleep(250);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  public static void main(String[] args) {
    System.out.println("Let the life begin.");

    Simulator sim2 = new Simulator();
    sim2.setBoardSize(80, 20);
    sim2.setGlider(2, 1);
    sim2.setBlinker(10,0);
    sim2.setToad(20,1);
    sim2.go();
  }
}
