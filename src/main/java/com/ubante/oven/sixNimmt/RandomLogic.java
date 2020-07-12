package com.ubante.oven.sixNimmt;

import java.util.concurrent.ThreadLocalRandom;

/**
 * This logic will randomly choose a card and a row.
 */
public class RandomLogic extends PlayerLogic {
    RandomLogic(String name) {
        super(name);
    }

    Card chooseCard(BoardState boardState, Hand hand) {
        int r = ThreadLocalRandom.current().nextInt(0, hand.getCards().size());

        return hand.get(r);
    }

    int chooseRow(BoardState boardState) {
        return ThreadLocalRandom.current().nextInt(0, 4);
    }

}
