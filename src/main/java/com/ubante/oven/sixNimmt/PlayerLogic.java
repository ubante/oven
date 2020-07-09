package com.ubante.oven.sixNimmt;

/**
 * PlayerLogic classes do not contain game state.  Instead, they contain the logic
 * to decide which card to play next.  This allows us to use untrusted classes
 * outside the VM.
 */
public class PlayerLogic {
    String name;

    PlayerLogic(String name) {
        this.name = name;
    }

    // The default card to choose is the first card in the hand.
    Card chooseCard(State state, Hand hand) {
        return hand.get(0);
    }

    // The default row to choose is the first row.
    int chooseRow(State state) {
        return 0;
    }
}
