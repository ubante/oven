package com.ubante.oven.debatethreads;

import java.util.ArrayList;
import java.util.List;

/**
 * XXX this needs some randomness.
 */
public class StockResponses {
  private static StockResponses singleton = null;
  private List<String> responses = new ArrayList<>();
  private int counter = -1;

  public static StockResponses getInstance() {
    if (singleton == null) {
      singleton = new StockResponses();
    }
    singleton.setupResponses();

    return singleton;
  }

  private void setupResponses() {
    responses.add("I will stand up for the middle class.");
    responses.add("I am an outsider.");
    responses.add("Let's do this for the children.");
    responses.add("I love the military and all the veterans.");
    responses.add("In my heart, I keep close, the children of the veterans.");
    responses.add("We can do great things.  Let's do it together.");
    responses.add("Families are having a tough time because of the other party.  I won't make that mistake.");
    responses.add("I'm tough when I have to be, but I also have a soft side.");
    responses.add("There's no else who can do this.");
    responses.add("We have to improve the process one person at a time.");
  }

  public String getResponse() {
    counter++;
    return responses.get(counter);
  }

}
