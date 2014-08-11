package com.ubante.oven.pad;

/**
 * Created by J on 8/11/2014.
 */
public class Board {
    int width = 6;
    int height = 5;
    Cell[][] board = new Cell[width][height];

    Board() {}

    Board getEmptyBoard() {
        Board emptyBoard = new Board();

        for (int i=0; i < width; i++) {
            for (int j=0; j < height; j++) {
                board[width][height] = Cell.getEmptyCell();
            }
        }

        return emptyBoard;
    }

    Board getRandomBaord() {
        Board randomBoard = new Board();

        // XXX

        return randomBoard;
    }

    void display() {}
}
