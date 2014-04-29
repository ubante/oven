package com.ubante.oven.poker;

/**
 * Created by J on 4/28/2014.
 */
public class Card {
    String suit;
    int value;

    Card (String suit, int value) {
        this.suit = suit;
        this.value = value;
    }

    static Card getRandom() {
        int v = 3;
        String s = "a";

        return new Card(s,v);
    }

    void print() {
        System.out.println(suit+value);
    }

    /**
     * Test main
     * @param args
     */
    public static void main(String[] args) {
        Card c = Card.getRandom();

        c.print();
    }

}
