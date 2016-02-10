package com.ubante.oven.oscars;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by J on 2/9/2016.
 */
public class Nominee {
  Movie movie;
  String personName = "";
  List<Voter> voters = new ArrayList<>();
  Category category;
  boolean isWinner = false;

  Nominee(Movie m, String p, Category c) {
    movie = m;
    personName = p;
    category = c;
  }

  Nominee(Movie m, Category c) {
    this(m, "", c);
  }

  boolean isPerson() {
    if (personName.equals("")) {
      return false;
    } else {
      return true;
    }
  }

  public String toString() {
    String flattenedString;

    if (isPerson()) {
      flattenedString = String.format("%s (%s)", personName, movie.title);
    } else {
      flattenedString = movie.title;
    }

    return flattenedString;
  }

  void recordVoter(Voter voter) {
    voters.add(voter);
  }
}
