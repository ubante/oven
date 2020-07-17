package com.ubante.oven.sixNimmt.models;

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

    Card getCard() {
        if (list.size() == 0) {
            System.out.println("The deck is empty and you are trying to get a card.  Exiting.");
            System.exit(83);
        }
        Card card = list.get(0);
        list.remove(0);

        return card;
    }

    void shuffle() {
        Collections.shuffle(list);
    }

    public static void main(String[] args) {
        Deck d = new Deck(Settings.deckSize);

        Card c;
        for (int i = 0; i < 160; i++) {
            c = d.getCard();
            System.out.println(c);
        }
    }
}
