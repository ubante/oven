package com.ubante.oven.sixNimmt;

import java.util.ArrayList;

public class Hand {
    ArrayList<Card> cards = new ArrayList<>();

    public String toString() {
        return cards.toString();
    }

    void add(Card c) { cards.add(c); }

    Card get(int i) { return cards.get(i); }

    void empty() { cards.clear(); }

    int[] summarize() {
        int[] summary = new int[cards.size()];
        for (int i = 0; i < cards.size(); i++) {
            summary[i] = cards.get(i).faceValue;
        }

        return summary;
    }

    // Should I use clone()?
    public Hand copy() {
        Hand copy = new Hand();
        for (Card c: cards) {
            copy.add(c);
        }

        return copy;
    }
}
