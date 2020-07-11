package com.ubante.oven.sixNimmt;

import java.util.HashMap;

/**
 * Represents the state of the board.
 */
public class BoardState {
    Row[] rows;
    HashMap<String, Integer> scores;

    BoardState(Row[] rows, HashMap<String, Integer> scores) {
        this.rows = rows;
        this.scores = scores;
    }
}
