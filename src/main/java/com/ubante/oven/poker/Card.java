package com.ubante.oven.poker;

import java.util.Random;

/**
 * Created by J on 4/28/2014.
 */
public class Card {
    static int maxValue = 13; // This is an ace
    String suit;
    int value;

    Card (String suit, int value) {
        this.suit = suit;
        this.value = value;
    }

    static Card getRandom() {
        String suit = "";
        Random r = new Random();
        int value = r.nextInt(maxValue) + 2;
        int suitNumber = r.nextInt(4); // 4 is the number of suits

        switch (suitNumber) {
            case 0:
                suit = "S";
                break;
            case 1:
                suit = "D";
                break;
            case 2:
                suit = "H";
                break;
            case 3:
                suit = "C";
                break;
        }

        return new Card(suit,value);
    }

    @Override
    public String toString() {
        return suit+value;
    }

    void print() {
        System.out.print(toString());
    }

    /**
     * Test main
     * @param args
     */
    public static void main(String[] args) {
        Card c = Card.getRandom();

        c.print();

        for (int i=0; i<60; i++) {
            c = Card.getRandom();
            System.out.printf("%3s ",c.toString());
        }
        System.out.println();
    }

}
