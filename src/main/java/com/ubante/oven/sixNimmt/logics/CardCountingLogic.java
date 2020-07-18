package com.ubante.oven.sixNimmt.logics;

import com.ubante.oven.sixNimmt.models.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * This logic will choose:
 *  (1) a safe card and
 *  (2) the lowest value row.
 */
public class CardCountingLogic extends PlayerLogic {
    int previousScore = Settings.startingPoints;
    BoardState boardState;
    boolean isHandRecorded = false;
    HashMap<Card, Player> everyonesLastCards = null;
    ArrayList<Integer> playedCards = new ArrayList<>();
    ArrayList<Integer> remainingCards = new ArrayList<>();
    // These two could be combined.
    ArrayList<Integer> zoneBoundaries = new ArrayList<>();
    HashMap<Integer, Row> zoneMap = new HashMap<>();

    public CardCountingLogic(String name) {
        super(name);
    }

    /***
     * The four rows form different zones:
     * (A) the cards lower than the lowest row
     * (B) the cards lower than the second lowest row but not in (A)
     * (C) the cards lower than the second highest row but not in (A) or (B)
     * (D) the cards lower than the highest row but not in (A), (B), or (C)
     * (E) the cards higher than the highest row
     *
     * Each zone is divided in to low and high subzones.
     *
     * When choosing a card, you may want to choose the highest card in a zone or
     * the lowest card in a zone.  This is where knowing the number of free spaces
     * in a row is important.
     *
     * The best endgame for a five-player game is to have many cards that are in
     * high B.  Inversely, for the same game, ending a round with many cards in low
     * B is dangerous.
     */
    void setBoardZones() {
        zoneBoundaries.clear();
        zoneMap.clear();
        for (Row r: boardState.rows) {
            Integer highestValueInRow = r.getHighestValue();
            zoneBoundaries.add(highestValueInRow);
            zoneMap.put(highestValueInRow, r);
        }
        Collections.sort(zoneBoundaries);
    }

    void recordHand(Hand hand) {
        if (isHandRecorded) {
            return;
        }

        for (Card c: hand.cards) {
            // Tempted to make a method for these two lines so I can
            // also call it in recordLastChosenCards().
            playedCards.add(c.faceValue);
            remainingCards.remove(c.faceValue);
        }
        isHandRecorded = true;
    }

    void recordLastChosenCards(HashMap<Card, Player> cards) {
        everyonesLastCards = cards;

        if (everyonesLastCards == null) {
            return;
        }

        for (Card c : cards.keySet()) {
            playedCards.add(c.faceValue);  // This creates duplicates.
            remainingCards.remove(c.faceValue);
        }
    }

    // This condition should factor in playedCards.
    String measureSafety(int cardValue, int zoneBoundary) {
        String safetyString = "";
        if (cardValue - zoneBoundary <= zoneMap.get(zoneBoundary).getFreeSpaces()) {
            safetyString = "+";
        } else if (cardValue - zoneBoundary == 1 && zoneMap.get(zoneBoundary).getFreeSpaces() == 1) {
            safetyString = "--";
        } else if (cardValue - zoneBoundary == 2 && zoneMap.get(zoneBoundary).getFreeSpaces() == 1) {
            safetyString = "-";
        }
        return safetyString;
    }

    public Card chooseCard(BoardState boardState, Hand hand) {
        this.boardState = boardState;
        recordHand(hand);
        recordLastChosenCards(boardState.lastChosenCards);

        int myScore = boardState.scores.get(name);
        if (myScore < previousScore) {
            previousScore = myScore;
        }
        System.out.println("Opponents:");
        for (String name: boardState.scores.keySet()) {
            System.out.println(String.format("%20s: %d", name, boardState.scores.get(name)));
        }

        setBoardZones();
//        System.out.println("\nZone boundaries");
//        System.out.println(zoneBoundaries);
//        System.out.printf("There are %d unknown cards.\n", remainingCards.size());
//        System.out.printf("There are %d cards shown.\n", playedCards.size());
//        System.out.println(playedCards);
//        System.out.println();
//        System.out.println("Your hand:");
//        System.out.println("   |  |  |  |  |  |");
        ArrayList<Card> cards = hand.getCards();
        for (int i = 1; i <= cards.size(); i++) {
            int cardValue = cards.get(i-1).faceValue;

            StringBuilder zonePadding = new StringBuilder();
            String safetyLevel = "";
            for (int zb: zoneBoundaries) {
                if (cardValue <= zb) {
                    continue;
                }
                zonePadding.append("   ");

                // Decide how safe this card is.
                if (safetyLevel.equals("")) {
                    safetyLevel = measureSafety(cardValue, zb);
                }
            }

//            System.out.printf("%2d: %s%d %s\n", i, zonePadding.toString(), cardValue, safetyLevel);
        }

//        System.out.printf("Choose a card: [1-%s]: ", cards.size());
//        int cardChoice = getInput(cards.size());
        int cardChoice = 1;
        
        return hand.get(cardChoice-1);
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
