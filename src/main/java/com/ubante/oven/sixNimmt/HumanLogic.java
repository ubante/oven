package com.ubante.oven.sixNimmt;

public class HumanLogic extends PlayerLogic {

    HumanLogic(String name) {
        super(name);
    }

    // The default card to choose is the first card in the hand.
    Card chooseCard(State state, Hand hand) {
        return hand.get(0);
    }
}
