package com.ubante.oven.hearthstone.common;

import com.ubante.oven.hearthstone.common.Card;

import java.util.ArrayList;

/**
 * Created by J on 10/25/2015.
 */
public class Hand {
  ArrayList<Card> hand = new ArrayList<>();

  public void add(Card c) {
    hand.add(c);
  }

  // must resist the urge to extend Deck
  @Override
  public String toString() {
    String returnString = "";
    for (Card c: hand) {
      returnString += c.getName() + " ";
    }

    return returnString;
  }

  public boolean containsCard(Card c) {
    if (hand.contains(c)) {
      return true;
    }

    return false;
  }

  public void clear() {
    hand.clear();
  }
}
