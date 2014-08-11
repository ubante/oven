package com.ubante.oven.pad;

/**
 * Created by J on 8/11/2014.
 */
public class Cell {
    String content;

    Cell() {}

    static Cell getEmptyCell() {
        Cell emptyCell = new Cell();
        emptyCell.content = "empty";
        return emptyCell;
    }
}
