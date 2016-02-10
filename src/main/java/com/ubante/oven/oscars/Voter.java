package com.ubante.oven.oscars;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by J on 2/9/2016.
 */
public class Voter {
  String name;
  List<Nominee> chosenNominees = new ArrayList<>();
  int correctGuesses = 0;

  Voter (String name) {
    this.name = name;
  }

  void vote(Nominee choice) {
    choice.recordVoter(this);
    chosenNominees.add(choice);
  }
}
