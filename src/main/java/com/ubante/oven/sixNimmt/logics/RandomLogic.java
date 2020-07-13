package com.ubante.oven.sixNimmt.logics;

import com.ubante.oven.sixNimmt.models.BoardState;
import com.ubante.oven.sixNimmt.models.Card;
import com.ubante.oven.sixNimmt.models.Hand;

import java.util.concurrent.ThreadLocalRandom;

/**
 * This logic will randomly choose a card and a row.
 */
public class RandomLogic extends PlayerLogic {
    public RandomLogic(String name) {
        super(name);
    }

    public Card chooseCard(BoardState boardState, Hand hand) {
        int r = ThreadLocalRandom.current().nextInt(0, hand.getCards().size());

        return hand.get(r);
    }

    public int chooseRow(BoardState boardState) {
        return ThreadLocalRandom.current().nextInt(0, 4);
    }

}
