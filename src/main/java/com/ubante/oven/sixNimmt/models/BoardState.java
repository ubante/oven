package com.ubante.oven.sixNimmt.models;

import java.util.HashMap;

/**
 * Represents the state of the board.
 *
 * This gets passed to PlayerLogic so should contain all the raw
 * information needed to decid how to choose a card or a row.
 *
 * TODO: this should include player scores since that affects strategy.
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
