package com.ubante.oven.gameoflife;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 0,0 is the upper left corner.
 */
public class Board {
  Cell[][] cellBoard;
  int sizeX;
  int sizeY;
  Boolean doPrintNumeric = false;
  int generation = 1;
  List<Board> boardHistory = new ArrayList(){};
  Boolean isStable = false;
  int repeatedGeneration = -1;

  Board(int sizeX, int sizeY) {
    this.sizeX = sizeX;
    this.sizeY = sizeY;
    cellBoard = new Cell[sizeX][sizeY];

    for (int i = 0; i < sizeX; i++) {
      for (int j = 0; j < sizeY; j++) {
        cellBoard[i][j] = new Cell();
        deactivatePoint(i,j);
      }
    }

    // There are 15 possibilities
    // 6 are for the case of a single row or single column
    // 4 corners
    // 4 sides
    // and a middle
    for (int x = 0; x < sizeX; x++) {
      for (int y = 0; y < sizeY; y++) {

        if (sizeX == 1) {
          // top-most if 1-dimensional up&down
          if (y == 0) {
            cellBoard[x][y].addNeighbors(cellBoard[0][1]);
            continue;
          }

          // bottom-most if 1-dimensional up&down
          if (y == sizeY-1) {
            cellBoard[x][y].addNeighbors(cellBoard[0][sizeY-2]);
            continue;
          }

          // middle if 1-dimensional up&down
          cellBoard[x][y].addNeighbors(cellBoard[0][y-1]);
          cellBoard[x][y].addNeighbors(cellBoard[0][y+1]);
          continue;
        }

        if (sizeY == 1) {
          // left-most if 1-dimensional left&right
          if (x == 0) {
            cellBoard[x][y].addNeighbors(cellBoard[1][0]);
            continue;
          }

          // right-most if 1-dimensional left&right
          if (x == sizeX-1) {
            cellBoard[x][y].addNeighbors(cellBoard[sizeX-2][0]);
            continue;
          }

          // middle if 1-dimensional left&right
          cellBoard[x][y].addNeighbors(cellBoard[x-1][0]);
          cellBoard[x][y].addNeighbors(cellBoard[x+1][0]);
          continue;
        }

        // UL corner
        if ((x==0) && (y==0)) {
          cellBoard[x][y].addNeighbors(cellBoard[0][1]);
          cellBoard[x][y].addNeighbors(cellBoard[1][1]);
          cellBoard[x][y].addNeighbors(cellBoard[1][0]);
          continue;
        }

        // UR corner
        if ((x==sizeX-1) && (y==0)) {
          cellBoard[x][y].addNeighbors(cellBoard[sizeX-1][1]);
          cellBoard[x][y].addNeighbors(cellBoard[sizeX-2][1]);
          cellBoard[x][y].addNeighbors(cellBoard[sizeX-2][0]);
          continue;
        }

        // LL corner
        if ((x==0) && (y==sizeY-1)) {
          cellBoard[x][y].addNeighbors(cellBoard[0][sizeY-2]);
          cellBoard[x][y].addNeighbors(cellBoard[1][sizeY-2]);
          cellBoard[x][y].addNeighbors(cellBoard[1][sizeY-1]);
          continue;
        }

        // LR corner
        if ((x==sizeX-1) && (y==sizeY-1)) {
          cellBoard[x][y].addNeighbors(cellBoard[sizeX-2][sizeY-1]);
          cellBoard[x][y].addNeighbors(cellBoard[sizeX-2][sizeY-2]);
          cellBoard[x][y].addNeighbors(cellBoard[sizeX-1][sizeY-2]);
          continue;
        }

        // top
        if (y==0) {
          cellBoard[x][y].addNeighbors(cellBoard[x+1][0]);
          cellBoard[x][y].addNeighbors(cellBoard[x+1][1]);
          cellBoard[x][y].addNeighbors(cellBoard[x][1]);
          cellBoard[x][y].addNeighbors(cellBoard[x-1][1]);
          cellBoard[x][y].addNeighbors(cellBoard[x-1][0]);
          continue;
        }

        // bottom

        if (y==sizeY-1) {
          cellBoard[x][y].addNeighbors(cellBoard[x-1][sizeY-1]);
          cellBoard[x][y].addNeighbors(cellBoard[x-1][sizeY-2]);
          cellBoard[x][y].addNeighbors(cellBoard[x][sizeY-2]);
          cellBoard[x][y].addNeighbors(cellBoard[x+1][sizeY-2]);
          cellBoard[x][y].addNeighbors(cellBoard[x+1][sizeY-1]);
          continue;
        }

        // left
        if (x==0) {
          cellBoard[x][y].addNeighbors(cellBoard[0][y-1]);
          cellBoard[x][y].addNeighbors(cellBoard[1][y-1]);
          cellBoard[x][y].addNeighbors(cellBoard[1][y]);
          cellBoard[x][y].addNeighbors(cellBoard[1][y+1]);
          cellBoard[x][y].addNeighbors(cellBoard[0][y+1]);
          continue;
        }

        // right
        if (x==sizeX-1) {
          cellBoard[x][y].addNeighbors(cellBoard[sizeX-1][y+1]);
          cellBoard[x][y].addNeighbors(cellBoard[sizeX-2][y+1]);
          cellBoard[x][y].addNeighbors(cellBoard[sizeX-2][y]);
          cellBoard[x][y].addNeighbors(cellBoard[sizeX-2][y-1]);
          cellBoard[x][y].addNeighbors(cellBoard[sizeX-1][y-1]);
          continue;
        }

        // surrounded by eight neighbors
        cellBoard[x][y].addNeighbors(cellBoard[x-1][y-1]);
        cellBoard[x][y].addNeighbors(cellBoard[x][y-1]);
        cellBoard[x][y].addNeighbors(cellBoard[x+1][y-1]);
        cellBoard[x][y].addNeighbors(cellBoard[x+1][y]);
        cellBoard[x][y].addNeighbors(cellBoard[x+1][y+1]);
        cellBoard[x][y].addNeighbors(cellBoard[x][y+1]);
        cellBoard[x][y].addNeighbors(cellBoard[x-1][y+1]);
        cellBoard[x][y].addNeighbors(cellBoard[x-1][y]);
      }
    }
  }

  Board (int squareSize) {
    this(squareSize, squareSize);
  }

  /**
   * Make a copy of a board.
   * @param inputBoard
   */
  Board (Board inputBoard) {
    this(inputBoard.sizeX, inputBoard.sizeY);
    setGeneration(inputBoard.getGeneration());
    setDoPrintNumeric(inputBoard.getDoPrintNumeric());
    setBoardHistory(inputBoard.getBoardHistory());
  }

  public void setGeneration(int generation) {
    this.generation = generation;
  }

  public int getGeneration() {
    return generation;
  }

  public void incrementGeneration() { generation++; }

  public void setDoPrintNumeric(Boolean doPrintNumeric) {
    this.doPrintNumeric = doPrintNumeric;
  }

  public Boolean getDoPrintNumeric() {
    return doPrintNumeric;
  }

  public List<Board> getBoardHistory() {
    return boardHistory;
  }

  public void setBoardHistory(List<Board> boardHistory) {
    this.boardHistory = boardHistory;
  }

  public void addToHistory(Board b) {
    boardHistory.add(b);
  }

  void activatePoint(int x, int y) {
    cellBoard[x][y].activate();
  }

  void deactivatePoint(int x, int y) {
    cellBoard[x][y].deactivate();
  }

  int getLivingCellCount() {
    int count = 0;

    for (int height = 0; height < sizeY; height++) {
      for (int width = 0; width < sizeX; width++) {
        if (cellBoard[width][height].isAlive) {
          count++;
        }
      }
    }

    return count;
  }

  public String toString() {
    String output = "";

    for (int height = 0; height < sizeY; height++) {
      for (int width = 0; width < sizeX; width++) {
        Cell c = cellBoard[width][height];

        if (c.isAlive) {
          if (doPrintNumeric) {
            output += c.getLivingNeighborCount();
          } else {
            output += "X";
          }
        } else {
          if (c.shouldLive()) {
            output += ".";
//            output += ":"; // shows incipient life
          } else {
            output += ".";
          }
        }
      }
      output += "\n";
    }

    return output;
  }

  void print() {
    String header = "Generation: " + generation + "\n";
//    header += String.format("Board history count: %d\n", boardHistory.size());
    System.out.printf(header);
    System.out.println(toString());
  }

  Board getNextGeneration() {
    Board future = new Board(this);
    future.incrementGeneration();
    future.addToHistory(this);

    for (int x = 0; x < sizeX; x++) {
      for (int y = 0; y < sizeY; y++) {
        if (cellBoard[x][y].shouldLive()) {
          future.activatePoint(x, y);
        } else {
          future.deactivatePoint(x, y);
        }
      }
    }


    return future;
  }

  void checkStability() {
    // Test for stability by looking for repetition over the last N boards.
    Collections.reverse(boardHistory);
//    System.out.println("Auditing ------------------");
//    System.out.println("My count: " + getLivingCellCount());

    // This approach begins to bog down as the boardHistory size gets > 100
    // XXX need to switch to a hash maybe
    int boardCtr = boardHistory.size();
    for (Board b : boardHistory) {
//      System.out.printf(String.format("Board #%d: %d\n", boardCtr, b.getLivingCellCount()));
      if (b.toString().equals(toString())) {
//        System.out.println("STABLE");
        isStable = true;
        repeatedGeneration = boardCtr;
      }
      boardCtr--;
    }

//    System.out.println("---------------------------\n\n");

    Collections.reverse(boardHistory);
  }
}
