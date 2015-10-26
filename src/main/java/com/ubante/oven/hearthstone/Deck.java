package com.ubante.oven.hearthstone;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by J on 10/25/2015.
 */
public class Deck {
  ArrayList<Card> deck = new ArrayList<>();
  int deckSize = 30;

  void shuffle() {
    Collections.shuffle(deck);
  }

  void addCard(Card c) {
    deck.add(c);
    deck.add(c);
  }

  void createRandomTwoDeck() {
    int counter = 0;
    while (deck.size() < deckSize) {
      counter++;
      Card card = new Card(Integer.toString(counter));
      deck.add(card);
      deck.add(card);
    }
  }

  @Override
  public String toString() {
    String returnString = "";
    for (Card c: deck) {
      returnString += c.name + " ";
    }

    return returnString;
  }

  Card draw() {
    Card card = deck.get(0);
    deck.remove(0);

    return card;
  }

}
