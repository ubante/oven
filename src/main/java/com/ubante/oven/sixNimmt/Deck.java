package com.ubante.oven.sixNimmt;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    Integer size;
    ArrayList<Card> list;

    public Deck (int size) {
        this.size = size;
        reset();
    }

    /**
     * Refill the deck with cards.  Useful at the start of rounds.
     */
    public void reset() {
        list = new ArrayList<>();
        for (int i = 1; i <= size; i++) {
            list.add(new Card(i));
        }
    }

    // TODO: how to deal with an empty deck?  Throw exception or return null?
    Card getCard() {
        Card card = list.get(0);
        list.remove(0);

        return card;
    }

    void shuffle() {
        Collections.shuffle(list);
    }

    public static void main(String[] args) {
        Deck d = new Deck(104);

        Card c;
        for (int i = 0; i < 160; i++) {
            c = d.getCard();
            System.out.println(c);
        }
    }
}
