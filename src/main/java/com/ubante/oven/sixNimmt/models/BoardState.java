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
    public HashMap<Card, Player> lastChosenCards;

    BoardState(Row[] rows,
               HashMap<String, Integer> scores,
               HashMap<Card, Player> lastChosenCards) {
        this.rows = rows;
        this.scores = scores;
        this.lastChosenCards = lastChosenCards;
    }
}
