package com.ubante.oven.sixNimmt.logics;

import com.ubante.oven.sixNimmt.models.BoardState;
import com.ubante.oven.sixNimmt.models.Card;
import com.ubante.oven.sixNimmt.models.Hand;

/**
 * This logic will choose the highest value card and the lowest value row.
 */
public class HighCardLogic extends PlayerLogic {
    public HighCardLogic(String name) {
        super(name);
    }

    public Card chooseCard(BoardState boardState, Hand hand) {
        return hand.getHighestValueCard();
    }

    public int chooseRow(BoardState boardState) {
        int lowestBeefHeadRowIndex = -1;
        int lowestBeefHeadScore = 99;
        for (int i = 0; i < 4; i++) {
            int thisRowsBeefHeadSum = boardState.rows[i].getBeefHeadSum();
            if (thisRowsBeefHeadSum < lowestBeefHeadScore) {
                lowestBeefHeadRowIndex = i;
                lowestBeefHeadScore = thisRowsBeefHeadSum;
            }
        }

        return lowestBeefHeadRowIndex;
    }

}
