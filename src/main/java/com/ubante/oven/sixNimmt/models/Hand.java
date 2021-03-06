package com.ubante.oven.sixNimmt.models;

import java.util.ArrayList;

public class Hand {
    public ArrayList<Card> cards = new ArrayList<>();

    public String toString() {
        return cards.toString();
    }

    public ArrayList<Card> getCards() { return cards; }

    void add(Card c) {
        // To make this easier for humans, we'll insert the new card in order.
        for (int i = 0; i < cards.size(); i++) {
            if (cards.get(i).faceValue < c.faceValue) {
                continue;
            }
            cards.add(i, c);
            return;
        }

        cards.add(c);
    }

    boolean remove(Card c) { return cards.remove(c); }

    public Card get(int i) { return cards.get(i); }

    public int size() { return cards.size(); }

    public Card getHighestValueCard() {
        return get(cards.size()-1);
    }
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
