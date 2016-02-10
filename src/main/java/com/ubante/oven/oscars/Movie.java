package com.ubante.oven.oscars;

import java.util.ArrayList;
import java.util.List;

/**
 * XXX This will later read xml or json.
 */
public class Movie {
  String title;
  List<Category> nominatedCategories = new ArrayList<>();

  Movie(String movieName) {
    title = movieName;
  }

  void addNominatedCategory(Category category) {
    nominatedCategories.add(category);
  }

}
