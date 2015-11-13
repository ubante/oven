package com.ubante.oven.hearthstone.hearthstonebad;

import java.util.ArrayList;

/**
 * Created by J on 10/25/2015.
 */
public class Hand {
  ArrayList<Card> hand = new ArrayList<>();

  void add(Card c) {
    hand.add(c);
  }

  // must resist the urge to extend Deck
  @Override
  public String toString() {
    String returnString = "";
    for (Card c: hand) {
      returnString += c.name + " ";
    }

    return returnString;
  }

  boolean containsCard(Card c) {
    if (hand.contains(c)) {
      return true;
    }

    return false;
  }

  void clear() {
    hand.clear();
  }
}
