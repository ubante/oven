package com.ubante.oven.sixNimmt;

import java.util.ArrayList;

public class Row {
    ArrayList<Card> items = new ArrayList<>();

    void addCard(Card c) {
        items.add(c);
    }
}
