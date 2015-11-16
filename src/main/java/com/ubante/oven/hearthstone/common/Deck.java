package com.ubante.oven.hearthstone.common;

import com.ubante.oven.hearthstone.common.Card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by J on 10/25/2015.
 */
public class Deck {
  ArrayList<Card> deck = new ArrayList<>();
  int deckSize = 30;

  public void shuffle() {
    Collections.shuffle(deck);
  }

  public void addCard(Card c) {
    deck.add(c);
  }

  public void addCardPair(Card c) {
    addCard(c);
    addCard(c);
  }

  public void createRandomTwoDeck() {
    int counter = 0;
    while (deck.size() < deckSize) {
      counter++;
      Card card = new Card(Integer.toString(counter));
      deck.add(card);
      deck.add(card);
    }
  }

  public void fillWithFiller() {
    while (deck.size() < deckSize) {
      deck.add(new Card(String.valueOf(101 + deck.size())));
    }
  }

  // from http://stackoverflow.com/questions/7281352/finding-duplicate-values-in-arraylist
  public boolean hasDuplicateCards() {
    List<String> usedNames = new ArrayList<String>();

    for (Card card : deck) {
      if (usedNames.contains(card.getName())) {
        return true;
      }
      usedNames.add(card.getName());
    }

    return false;
  }

  @Override
  public String toString() {
    String returnString = "";
    for (Card c: deck) {
      returnString += c.getName() + " ";
    }

    return returnString;
  }

  public Card draw() {
    Card card = deck.get(0);
    deck.remove(0);

    return card;
  }

}
