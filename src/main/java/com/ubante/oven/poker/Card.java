package com.ubante.oven.poker;

import java.util.Random;

/**
 * This is a card.  A value of 11 is a jack, 12 is a queen, 13 is a king and 14 is an ace.
 */
public class Card {
    static int maxValue = 14; // This is an ace
    String suit;
    int value;

    Card (String suit, int value) {
        this.suit = suit;
        this.value = value;
    }

    static Card getRandomJur() {
        String suit = "";
        Random r = new Random();
        int value = r.nextInt(maxValue-1) + 2; // Gives a range of 2..14
        int suitNumber = r.nextInt(4); // 4 is the number of suits

        switch (suitNumber) {
            case 0:
                suit = "C";
                break;
            case 1:
                suit = "D";
                break;
            case 2:
                suit = "S";
                break;
            case 3:
                suit = "H";
                break;
        }

        return new Card(suit,value);
    }

    static Card getRandomMath() {

        String suit = "";
        int value = 2 + (int)(Math.random()*(maxValue-1));
        int suitNumber = (int)(Math.random()*4);

        switch (suitNumber) {
            case 0:
                suit = "C";
                break;
            case 1:
                suit = "D";
                break;
            case 2:
                suit = "S";
                break;
            case 3:
                suit = "H";
                break;
        }

        return new Card(suit,value);
    }

    static Card getRandom() {
//        return getRandomJur();
        return getRandomMath();
    }

    @Override
    public String toString() {
        return suit+value;
    }

    void print() {
        System.out.print(toString());
    }

    void println() { System.out.println(toString()); }

    /**
     * Test main
     * @param args no args
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
