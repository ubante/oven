package com.ubante.oven.sixNimmt.logics;

import com.ubante.oven.sixNimmt.models.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class HumanLogic extends PlayerLogic {
    int previousScore = Settings.startingPoints;
    HashMap<Card, Player> everyonesLastCard = null;
    // TODO do I need CardSet?
    ArrayList<Integer> playedCards = new ArrayList<>();
    ArrayList<Integer> remainingCards = new ArrayList<>();
    boolean isHandRecorded = false;
    BoardState boardState;

    public HumanLogic(String name) {
        super(name);

        for (int i = 1; i <= Settings.deckSize; i++) {
            remainingCards.add(i);
        }
    }

    public void reset() {
        playedCards.clear();
        remainingCards.clear();
    }

    // Maybe boardState should be an instance variable so I wouldn't
    // have to pass it around.
    void printBoard() {
        System.out.println("\nBoard:");
        for (int i = 0; i < 4; i++) {
            String rowLine = String.format("%d (%d): %s", i+1, boardState.rows[i].getBeefHeadSum(),
                    boardState.rows[i].getColumnarRepresentation());
            System.out.println(rowLine);
        }
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
    void getHandZones() {
        // TODO
    }

    void recordHand(Hand hand) {
        if (isHandRecorded) {
            return;
        }

        for (Card c: hand.cards) {
            playedCards.add(c.faceValue);
            remainingCards.remove(c.faceValue);
        }
        isHandRecorded = true;
    }

    void recordCards(HashMap<Card, Player> cards) {
        everyonesLastCard = cards;

        if (everyonesLastCard == null) {
            return;
        }

        for (Card c : cards.keySet()) {
            playedCards.add(c.faceValue);  // This creates duplicates.
            remainingCards.remove(c.faceValue);
        }
    }

    int getInput(int maxValue) {
        Scanner input = new Scanner(System.in);
        int choice;

        do {
            try {
                choice = input.nextInt();
            } catch (InputMismatchException ime) {
                System.out.println("Please input an integer.");
                choice = -2;
            }

            if (choice < 1 || choice > maxValue) {
                System.out.printf("Try again [1-%d]: ", maxValue);
                input.nextLine();
            }

        } while (choice < 1 || choice > maxValue);

        return choice;
    }

    public Card chooseCard(BoardState boardState, Hand hand) {
        this.boardState = boardState;
        recordHand(hand);
        recordCards(boardState.lastChosenCards);

        System.out.println("\\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/");
        int myScore = boardState.scores.get(name);
        if (myScore < previousScore) {
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            System.out.println("You have lost " + (previousScore-myScore) + " points!\n");
            previousScore = myScore;
        }
        System.out.println("Opponents:");
        for (String name: boardState.scores.keySet()) {
            System.out.println(String.format("%20s: %d", name, boardState.scores.get(name)));
        }

        printBoard();
        System.out.println("\nYour hand:");
        ArrayList<Card> cards = hand.getCards();
        for (int i = 1; i <= cards.size(); i++) {
            String sfmt = String.format("%2d: %s", i, cards.get(i-1).faceValue);
            System.out.println(sfmt);
        }
        System.out.printf("There are %d unknown cards.\n", remainingCards.size());
        System.out.printf("There are %d cards shown.\n", playedCards.size());
        System.out.println(playedCards);

        System.out.printf("Choose a card: [1-%s]: ", cards.size());
        int cardChoice = getInput(cards.size());

        return hand.get(cardChoice-1);
    }

    // The default row to choose is the first row.
    public int chooseRow(BoardState boardState) {
        this.boardState = boardState;
        printBoard();

        System.out.print("Choose a row [1-4]: ");
        Scanner input = new Scanner(System.in);
        return input.nextInt() - 1;
    }

}
