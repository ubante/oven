package com.ubante.oven.sixNimmt.logics;

import com.ubante.oven.sixNimmt.models.BoardState;
import com.ubante.oven.sixNimmt.models.Card;
import com.ubante.oven.sixNimmt.models.Hand;

/**
 * PlayerLogic classes do not contain game state.  Instead, they contain the logic
 * to decide which card to play next.  This allows us to use untrusted classes
 * outside the VM.
 */
public class PlayerLogic {
    public String name;

    public PlayerLogic(String name) {
        this.name = name;
    }

    // The default card to choose is the first card in the hand,
    // which is the lowest value card in the hand.
    public Card chooseCard(BoardState boardState, Hand hand) {
        return hand.get(0);
    }

    // The default row to choose is the first row.
    public int chooseRow(BoardState boardState) {
        return 0;
    }

    // Subclasses may want to do something smart at the start of each round.
    public void reset() {}
}
