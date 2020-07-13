package com.ubante.oven.sixNimmt.models;

import java.util.HashMap;

/**
 * Represents the state of the board.
 *
 * TODO: this should include the cards chosen in the last turn.
 */
public class BoardState {
    public Row[] rows;
    public HashMap<String, Integer> scores;

    BoardState(Row[] rows, HashMap<String, Integer> scores) {
        this.rows = rows;
        this.scores = scores;
    }
}
