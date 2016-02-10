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
      System.out.printf("%s is nominated %d times\n", movie.title, movie.nominatedCategories.size());
    }
  }

  static void displayMovieStats() {
    Movie mostWiningMovie = null;

    System.out.println("Here are the final stats for all the nominated movies:");
    for (Movie movie : list) {
      int wins = movie.wins;

      System.out.printf("%s won %d of its %d nominations\n", movie.title,
          wins, movie.nominatedCategories.size());

      if (mostWiningMovie == null) {
        mostWiningMovie = movie;
      } else {
        if (movie.wins > mostWiningMovie.wins) {
          mostWiningMovie = movie;
        }
      }
    }

    System.out.printf("\nWith %d wins, the most winning movie is %s.\n", mostWiningMovie.wins, mostWiningMovie.title);
  }
}
