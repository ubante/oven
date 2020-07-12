package com.ubante.oven.sixNimmt;

import java.util.ArrayList;
import java.util.Scanner;

public class HumanLogic extends PlayerLogic {
    int previousScore = 60;  // This is an assumption.

    HumanLogic(String name) {
        super(name);
    }

    // Maybe boardState should be an instance variable so I wouldn't
    // have to pass it around.
    void printBoard(BoardState boardState) {
        System.out.println("\nBoard:");
        for (int i = 0; i < 4; i++) {
            String rowLine = String.format("%d (%d): %s", i+1, boardState.rows[i].getBeefHeadSum(),
                    boardState.rows[i].getColumnarRepresentation());
            System.out.println(rowLine);
        }
    }

    // The default card to choose is the first card in the hand.
    Card chooseCard(BoardState boardState, Hand hand) {
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

        printBoard(boardState);
        System.out.println("\nYour hand:");
        ArrayList<Card> cards = hand.getCards();
        for (int i = 1; i <= cards.size(); i++) {
            String sfmt = String.format("%2d: %s", i, cards.get(i-1).faceValue);
            System.out.println(sfmt);
        }
        System.out.print("Choose a card: ");

        Scanner input = new Scanner(System.in);
        int cardChoice = input.nextInt();
        return hand.get(cardChoice-1);
    }

    // The default row to choose is the first row.
    int chooseRow(BoardState boardState) {
        printBoard(boardState);

        System.out.print("Choose a row [1-4]: ");
        Scanner input = new Scanner(System.in);
        return input.nextInt() - 1;
    }

}
