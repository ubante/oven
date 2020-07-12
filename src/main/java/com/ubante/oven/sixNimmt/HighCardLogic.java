package com.ubante.oven.sixNimmt;

/**
 * This logic will choose the highest value card and the lowest value row.
 */
public class HighCardLogic extends PlayerLogic {
    HighCardLogic(String name) {
        super(name);
    }

    Card chooseCard(BoardState boardState, Hand hand) {
        return hand.getHighestValueCard();
    }

    int chooseRow(BoardState boardState) {
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
