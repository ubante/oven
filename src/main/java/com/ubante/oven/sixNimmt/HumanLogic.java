package com.ubante.oven.sixNimmt;

import java.util.ArrayList;
import java.util.Scanner;

public class HumanLogic extends PlayerLogic {
    int previousScore = 60;  // This is an assumption.

    HumanLogic(String name) {
        super(name);
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

        System.out.println("\nBoard:");
        for (int i = 0; i < 4; i++) {
            System.out.println(i+1 + " " + boardState.rows[i].getColumnarRepresentation());
        }

        System.out.println("\nYour hand:");
        ArrayList<Card> cards = hand.getCards();
        for (int i = 1; i <= cards.size(); i++) {
            System.out.println(i + ": " + cards.get(i-1).faceValue);
        }
        System.out.print("Choose a card: ");

        Scanner input = new Scanner(System.in);
        int cardChoice = input.nextInt();
        return hand.get(cardChoice-1);
    }
}
