package com.ubante.oven.oscars;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by J on 2/9/2016.
 */
public class Category {
  String name;
  List<Nominee> nominees = new ArrayList<>();
  Nominee winner;

  Category(String name) {
    this.name = name;
  }

  public void setWinner(Nominee winner) {
    this.winner = winner;
    winner.isWinner = true;
    winner.movie.wins++;
  }

  void add(String movieName) {
    Movie movie = MovieList.find(movieName);
    nominees.add(new Nominee(movie, this));
    movie.addNominatedCategory(this);
  }

  void add(String movieName, String person) {
    Movie movie = MovieList.find(movieName);
    nominees.add(new Nominee(movie, person, this));
    movie.addNominatedCategory(this);
  }

  void display() {
    // Print category name
    System.out.println(name + ":");

    // Print nominees
    for (Nominee n : nominees) {
      System.out.println("- " + n.toString());
    }
  }


}
