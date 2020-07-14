package com.ubante.oven.sixNimmt.models;

import java.util.ArrayList;

public class Row {
    ArrayList<Card> items = new ArrayList<>();
    int beefHeadSum = 0;

    public String toString() {
        return (items.size() + " cards, " + beefHeadSum + " beefs, top card = " + getHighestValueCard().faceValue);
    }

    public int getBeefHeadSum() { return beefHeadSum; }

    int getFreeSpaces() { return Settings.rowWidth - items.size() - 1;}

    void addCard(Card c) {
        items.add(c);
        beefHeadSum += c.beefHeads;
    }

    public String getColumnarRepresentation() {
        StringBuilder output = new StringBuilder();
        for (Card c: items) {
            output.append(String.format(" %3d", c.faceValue));
        }

        return output.toString();
    }

    void replaceWith(Card c) {
        items.clear();
        beefHeadSum = 0;
        addCard(c);
    }

    Card getHighestValueCard() { return items.get(items.size() - 1); }

    int getHighestValue() { return getHighestValueCard().faceValue; }

    boolean nearFull() {
        return items.size() == Settings.rowWidth-1;
    }
}