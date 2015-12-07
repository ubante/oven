package com.ubante.oven.gameoflife;

/**
 * Created by J on 11/29/2015.
 */
public class Simulator {
  int boardSizeX;
  int boardSizeY;
  Board currentBoard;
  Board futureBoard;
  int maxAge = 100;

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

  public void setMaxAge(int maxAge) {
    this.maxAge = maxAge;
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

  /**
   *   ......  ......
   *   .XX...  .XX...
   *   .XX...  .X....
   *   ...XX.  ....X.
   *   ...XX.  ...XX.
   *   ......  ......
   * @param startX
   * @param startY
   */
  void setBeacon(int startX, int startY) {
    currentBoard.activatePoint(startX+0, startY+0);
    currentBoard.activatePoint(startX+1, startY+0);
    currentBoard.activatePoint(startX+0, startY+1);
    currentBoard.activatePoint(startX+3, startY+2);
    currentBoard.activatePoint(startX+2, startY+3);
    currentBoard.activatePoint(startX+3, startY+3);
  }

  /**
   *  .................  .....X.....X.....  .................
   *  ....XXX...XXX....  .....X.....X.....  .................
   *  .................  .....XX...XX.....  .................
   *  ..X....X.X....X..  .................  .................
   *  ..X....X.X....X..  .XXX..XX.XX..XXX.  .................
   *  ..X....X.X....X..  ...X.X.X.X.X.X...  .................
   *  ....XXX...XXX....  .....XX...XX.....  .................
   *  .................  .................  .................
   *  ....XXX...XXX....  .....XX...XX.....  .................
   *  ..X....X.X....X..  ...X.X.X.X.X.X...  .................
   *  ..X....X.X....X..  .XXX..XX.XX..XXX.  .................
   *  ..X....X.X....X..  .................  .................
   *  .................  .....XX...XX.....  .................
   *  ....XXX...XXX....  .....X.....X.....  .................
   *  .................  .....X.....X.....  .................
   *
   * @param startX
   * @param startY
   */
  void setPulsar(int startX, int startY) {
    currentBoard.activatePoint(startX+2, startY+0);
    currentBoard.activatePoint(startX+3, startY+0);
    currentBoard.activatePoint(startX+4, startY+0);
    currentBoard.activatePoint(startX+8, startY+0);
    currentBoard.activatePoint(startX+9, startY+0);
    currentBoard.activatePoint(startX+10, startY+0);
    currentBoard.activatePoint(startX+0, startY+2);
    currentBoard.activatePoint(startX+5, startY+2);
    currentBoard.activatePoint(startX+7, startY+2);
    currentBoard.activatePoint(startX+12, startY+2);
    currentBoard.activatePoint(startX+0, startY+3);
    currentBoard.activatePoint(startX+5, startY+3);
    currentBoard.activatePoint(startX+7, startY+3);
    currentBoard.activatePoint(startX+12, startY+3);
    currentBoard.activatePoint(startX+0, startY+4);
    currentBoard.activatePoint(startX+5, startY+4);
    currentBoard.activatePoint(startX+7, startY+4);
    currentBoard.activatePoint(startX+12, startY+4);
    currentBoard.activatePoint(startX+2, startY+5);
    currentBoard.activatePoint(startX+3, startY+5);
    currentBoard.activatePoint(startX+4, startY+5);
    currentBoard.activatePoint(startX+8, startY+5);
    currentBoard.activatePoint(startX+9, startY+5);
    currentBoard.activatePoint(startX+10, startY+5);
    currentBoard.activatePoint(startX+2, startY+7);
    currentBoard.activatePoint(startX+3, startY+7);
    currentBoard.activatePoint(startX+4, startY+7);
    currentBoard.activatePoint(startX+8, startY+7);
    currentBoard.activatePoint(startX+9, startY+7);
    currentBoard.activatePoint(startX+10, startY+7);
    currentBoard.activatePoint(startX+0, startY+8);
    currentBoard.activatePoint(startX+5, startY+8);
    currentBoard.activatePoint(startX+7, startY+8);
    currentBoard.activatePoint(startX+12, startY+8);
    currentBoard.activatePoint(startX+0, startY+9);
    currentBoard.activatePoint(startX+5, startY+9);
    currentBoard.activatePoint(startX+7, startY+9);
    currentBoard.activatePoint(startX+12, startY+9);
    currentBoard.activatePoint(startX+0, startY+10);
    currentBoard.activatePoint(startX+5, startY+10);
    currentBoard.activatePoint(startX+7, startY+10);
    currentBoard.activatePoint(startX+12, startY+10);
    currentBoard.activatePoint(startX+2, startY+12);
    currentBoard.activatePoint(startX+3, startY+12);
    currentBoard.activatePoint(startX+4, startY+12);
    currentBoard.activatePoint(startX+8, startY+12);
    currentBoard.activatePoint(startX+9, startY+12);
    currentBoard.activatePoint(startX+10, startY+12);
  }

  /**
   * .........................................
   * .XXXXXXXX.XXXXX...XXX......XXXXXXX.XXXXX.
   * .........................................
   *
   * @param startX
   * @param startY
   */
  void setGun(int startX, int startY) {
    currentBoard.activatePoint(startX+1, startY+1);
    currentBoard.activatePoint(startX+2, startY+1);
    currentBoard.activatePoint(startX+3, startY+1);
    currentBoard.activatePoint(startX+4, startY+1);
    currentBoard.activatePoint(startX+5, startY+1);
    currentBoard.activatePoint(startX+6, startY+1);
    currentBoard.activatePoint(startX+7, startY+1);
    currentBoard.activatePoint(startX+8, startY+1);
    currentBoard.activatePoint(startX+10, startY+1);
    currentBoard.activatePoint(startX+11, startY+1);
    currentBoard.activatePoint(startX+12, startY+1);
    currentBoard.activatePoint(startX+13, startY+1);
    currentBoard.activatePoint(startX+14, startY+1);
    currentBoard.activatePoint(startX+18, startY+1);
    currentBoard.activatePoint(startX+19, startY+1);
    currentBoard.activatePoint(startX+20, startY+1);
    currentBoard.activatePoint(startX+27, startY+1);
    currentBoard.activatePoint(startX+28, startY+1);
    currentBoard.activatePoint(startX+29, startY+1);
    currentBoard.activatePoint(startX+30, startY+1);
    currentBoard.activatePoint(startX+31, startY+1);
    currentBoard.activatePoint(startX+32, startY+1);
    currentBoard.activatePoint(startX+33, startY+1);
    currentBoard.activatePoint(startX+35, startY+1);
    currentBoard.activatePoint(startX+36, startY+1);
    currentBoard.activatePoint(startX+37, startY+1);
    currentBoard.activatePoint(startX+38, startY+1);
    currentBoard.activatePoint(startX+39, startY+1);
  }

  /**
   * This creature has a period of 15.
   *  ...................
   *  ......X.....X......
   *  ....XX.XXXXX.XX....
   *  ......X.....X......
   *  ...................
   *
   * @param startX
   * @param startY
   */
  void setPentadecathalon(int startX, int startY) {
    currentBoard.activatePoint(startX+6, startY+5);
    currentBoard.activatePoint(startX+7, startY+5);
    currentBoard.activatePoint(startX+8, startY+4);
    currentBoard.activatePoint(startX+8, startY+6);
    currentBoard.activatePoint(startX+9, startY+5);
    currentBoard.activatePoint(startX+10, startY+5);
    currentBoard.activatePoint(startX+11, startY+5);
    currentBoard.activatePoint(startX+12, startY+5);
    currentBoard.activatePoint(startX+13, startY+4);
    currentBoard.activatePoint(startX+13, startY+6);
    currentBoard.activatePoint(startX+14, startY+5);
    currentBoard.activatePoint(startX+15, startY+5);
  }

  void go(Boolean printNum) {
    currentBoard.setDoPrintNumeric(printNum);

    for (int i = 0; i < maxAge; i++) {
      currentBoard.print();
      currentBoard.checkStability();

      if (currentBoard.isStable) {
        System.out.println("We have reached stability - this is the same as generation "
            + currentBoard.repeatedGeneration);
        return;
      }

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

    Simulator sim = new Simulator();
    sim.setBoardSize(80, 60);
//    sim.setBoardSize(80, 20);
    sim.setMaxAge(1000);
    sim.setGlider(2, 1);
    sim.setBlinker(10, 0);
    sim.setToad(20, 1);
    sim.setBeacon(30, 1);
    sim.setPulsar(40, 2);
    sim.setGun(10,40);
    sim.setPentadecathalon(58,0);
    sim.setPentadecathalon(60,11);
    sim.setPentadecathalon(58,22);
    Boolean printNumeric = false;
    sim.go(printNumeric);
  }
}





















