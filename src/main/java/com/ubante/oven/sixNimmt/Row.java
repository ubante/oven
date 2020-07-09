package com.ubante.oven.sixNimmt;

import java.util.ArrayList;

public class Row {
    ArrayList<Card> items = new ArrayList<>();
    int beefHeadSum = 0;

    public String toString() {
        return (getHighestValue().faceValue + " & " + items.size() + " cards");
    }

    void addCard(Card c) {
        items.add(c);
        beefHeadSum += c.faceValue;
    }

    Card getHighestValue() { return items.get(items.size() - 1); }

    Card getLowestValue() { return items.get(0); }
}
