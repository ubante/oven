package com.ubante.oven.oscars;

import java.util.ArrayList;
import java.util.List;

/**
 * This is a movieton.
 */
public class MovieList {
  private static MovieList instance = null;
  private static List<Movie> list = new ArrayList<>();

  protected MovieList() {} // get out of here with that

  public static MovieList getInstance() {
    if (instance == null) {
      instance = new MovieList();
    }

    return instance;
  }

  static Movie find(String title) {
    for (Movie m : list) {
      if (m.title.equals(title)) {
        return m;
      }
    }

    System.out.println("Cannot find " + title + "; adding it");
    Movie newMovie = new Movie(title);
    list.add(newMovie);

    return newMovie;
  }

  static void displayPreshowStats() {
    System.out.println("Here are the stats for all the nominated movies:");
    for (Movie movie : list) {
      System.out.printf("%s nominated %d times\n", movie.title, movie.nominatedCategories.size());
    }
  }
}
