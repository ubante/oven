package com.ubante.oven.oscars;

import java.util.ArrayList;
import java.util.List;

/**
 * This will simulate N voters voting on the results of the Oscars.
 */
public class OscarRunner {
  List<Voter> voters = new ArrayList<>();
  List<Category> categories = new ArrayList<>();

  void initializeVoters() {
    String[] voterNames = {"Condo", "Bugger", "?oarece", "Condootz", "Slobonog", "Mus Musculus",
        "Diagonal", "Condool", "Mustachele", "j", "k", "l", "m", "n", "o"};
    for (String voterName : voterNames) {
      voters.add(new Voter(voterName));
    }
  }

  void initializeCategories() {
    Category bestPicture = new Category("Best Picture");
    bestPicture.add("The Big Short");
    bestPicture.add("Bridge of Spies");
    bestPicture.add("Brooklyn");
    bestPicture.add("Mad Max: Fury Road");
    bestPicture.add("The Martian");
    bestPicture.add("The Revenant");
    bestPicture.add("Room");
    bestPicture.add("Spotlight");
    categories.add(bestPicture);

    Category leadingActor = new Category("Actor in a Leading Role");
    leadingActor.add("Trumbo", "Bryan Cranston");
    leadingActor.add("The Martian", "Matt Damon");
    leadingActor.add("The Revenant", "Leonardo DiCaprio");
    leadingActor.add("Steve Jobs", "Michael Fassbender");
    leadingActor.add("The Danish Girl", "Eddie Redmayne");
    categories.add(leadingActor);

    Category leadingActress = new Category("Actress in a Leading Role");
    leadingActress.add("Carol", "Cate Blanchett");
    leadingActress.add("Room", "Brie Larson");
    leadingActress.add("Joy", "Jennifer Lawrence");
    leadingActress.add("45 Years", "Charlotte Rampling");
    leadingActress.add("Brooklyn", "Saoirse Ronan");
    categories.add(leadingActress);

    Category supportingActor = new Category("Actor in a Supporting Role");
    supportingActor.add("The Big Short", "Christian Bale");
    supportingActor.add("The Revenant", "Tom Hardy");
    supportingActor.add("Spotlight", "Mark Ruffalo");
    supportingActor.add("Bridge of Spies" ,"Mark Rylance");
    supportingActor.add("Creed", "Sylvester Stallone");
    categories.add(supportingActor);

    Category supportingActress = new Category("Actress in a Supporting Role");
    supportingActress.add("The Hateful Eight", "Jennifer Jason Leigh");
    supportingActress.add("Carol", "Rooney Mara");
    supportingActress.add("Spotlight", "Rachel McAdams");
    supportingActress.add("The Danish Girl", "Alicia Vikander");
    supportingActress.add("Steve Jobs", "Kate Winslet");
    categories.add(supportingActress);

    Category animatedFilm = new Category("Animated Feature Film");
    animatedFilm.add("Anomalisa");
    animatedFilm.add("Boy and the World");
    animatedFilm.add("Inside Out");
    animatedFilm.add("Shaun the Sheep Movie");
    animatedFilm.add("When Marnie Was There");
    categories.add(animatedFilm);

    Category cinematography = new Category("Cinematography");
    cinematography.add("Carol");
    cinematography.add("The Hateful Eight");
    cinematography.add("Mad Max: Fury Road");
    cinematography.add("The Revenant");
    cinematography.add("Sicario");
    categories.add(cinematography);

    Category costumeDesign = new Category("Costume Design");
    costumeDesign.add("Carol");
    costumeDesign.add("Cinderella");
    costumeDesign.add("The Danish Gril");
    costumeDesign.add("Mad Max: Fury Road");
    costumeDesign.add("The Revenant");
    categories.add(costumeDesign);

    Category directing = new Category("Directing");
    directing.add("The Big Short");
    directing.add("Mad Max: Fury Road");
    directing.add("The Revenant");
    directing.add("Room");
    directing.add("Spotlight");
    categories.add(directing);

    Category documentaryFeature = new Category("Documentary (Feature))");
    documentaryFeature.add("Amy");
    documentaryFeature.add("Cartel Land");
    documentaryFeature.add("The Look of Silence");
    documentaryFeature.add("What Happened, Miss Simone?");
    documentaryFeature.add("Winter on Fire: Ukraine's Fight for Freedom");
    categories.add(documentaryFeature);

    Category documentaryShortSubject = new Category("Documentary (Short Subject)");
    documentaryShortSubject.add("Body Team 12");
    documentaryShortSubject.add("Chau, beyond the Lines");
    documentaryShortSubject.add("Claude Lanzmann: Spectres of the Shoah");
    documentaryShortSubject.add("A Girl in the River: The Price of Forgiveness");
    documentaryShortSubject.add("Last Day of Freedom");
    categories.add(documentaryShortSubject);

    Category filmEditing = new Category("Film Editing");
    filmEditing.add("The Big Short");
    filmEditing.add("Mad Max: Fury Road");
    filmEditing.add("The Revenant");
    filmEditing.add("Spotlight");
    filmEditing.add("Star Wars: The Force Awakens");
    categories.add(filmEditing);

    Category foreignLanguageFilm = new Category("Foreign Language Film");
    foreignLanguageFilm.add("Embrace of the Serpent");
    foreignLanguageFilm.add("Mustang");
    foreignLanguageFilm.add("Son of Saul");
    foreignLanguageFilm.add("Theeb");
    foreignLanguageFilm.add("A War");
    categories.add(foreignLanguageFilm);

    Category makeupHairstyling = new Category("Makeup and Hairstyling");
    makeupHairstyling.add("Mad Max: Fury Road");
    makeupHairstyling.add("The 100-Year-Old Man Who Climbed Out");
    makeupHairstyling.add("The Window and Disappeared");
    makeupHairstyling.add("The Revenant");
    categories.add(makeupHairstyling);

    Category music = new Category("Music (Original Score)");
    music.add("Bridge of Spies");
    music.add("Carol");
    music.add("The Hateful Eight");
    music.add("Sicario");
    music.add("Star Wars: The Force Awakens");
    categories.add(music);

    Category song = new Category("Music (Original Song)");
    song.add("Fifty Shades of Grey", "Earned It");
    song.add("Racing Extinction", "Manta Ray");
    song.add("Youth", "Simple Song #3");
    song.add("The Hunting Ground", "Till It Happens To You");
    song.add("Spectre", "Writing's On The Wall");
    categories.add(song);

    Category productionDesign = new Category("Production Design");
    productionDesign.add("Bridge of Spies");
    productionDesign.add("The Danish Girl");
    productionDesign.add("Mad Max: Fury Road");
    productionDesign.add("The Martian");
    productionDesign.add("The Revenant");
    categories.add(productionDesign);

    Category shortFilmAnimated = new Category("Short Film (Animated)");
    shortFilmAnimated.add("Bear Story");
    shortFilmAnimated.add("Prologue");
    shortFilmAnimated.add("Sanjay's Super Team");
    shortFilmAnimated.add("We Can't Live without Cosmos");
    shortFilmAnimated.add("World of Tomorrow");
    categories.add(shortFilmAnimated);

    Category shortFilmLive = new Category("Short Film (Live Action)");
    shortFilmLive.add("Ave Maria");
    shortFilmLive.add("Day One");
    shortFilmLive.add("Everything Will Be Okay (Alles Wird Gut)");
    shortFilmLive.add("Shok");
    shortFilmLive.add("Stutterer");
    categories.add(shortFilmLive);

    Category soundEditing = new Category("Sound Editing");
    soundEditing.add("Mad Max: Fury Road");
    soundEditing.add("The Martian");
    soundEditing.add("The Revenant");
    soundEditing.add("Sicario");
    soundEditing.add("Star Wars: The Force Awakens");
    categories.add(soundEditing);

    Category soundMixing = new Category("Sound Mixing");
    soundMixing.add("Bridge of Spies");
    soundMixing.add("Mad Max: Fury Road");
    soundMixing.add("The Martian");
    soundMixing.add("The Revenant");
    soundMixing.add("Star Wars: The Force Awakens");
    categories.add(soundMixing);

    Category visualEffects = new Category("Visual Effects");
    visualEffects.add("Ex Machina");
    visualEffects.add("Mad Max: Fury Road");
    visualEffects.add("The Martian");
    visualEffects.add("The Revenant");
    visualEffects.add("Star Wars: The Force Awakens");
    categories.add(visualEffects);

    Category writing = new Category("Writing (Adapted Screenplay)");
    writing.add("The Big Short");
    writing.add("Brooklyn");
    writing.add("Carol");
    writing.add("The Martian");
    writing.add("Room");
    categories.add(writing);

    Category writingOriginal = new Category("Writing (Original Screenplay)");
    writingOriginal.add("Bridge of Spies");
    writingOriginal.add("Ex Machina");
    writingOriginal.add("Inside Out");
    writingOriginal.add("Spotlight");
    writingOriginal.add("Straight Outta Compton");
    categories.add(writingOriginal);
  }

  void displayCategoryNominees() {
    for (Category category : categories) {
      category.display();
      System.out.println();
    }
  }

  void displayMoviePreshowStats() {
    MovieList.displayPreshowStats();
    System.out.println();
  }

  /**
   * This is a sim so guess.
   */
  void vote() {
    for (Voter voter : voters) {
      System.out.println(voter.name + " is voting now.");

      for (Category category : categories) {
        int index = (int) (Math.random() * category.nominees.size());
        Nominee chosenNominee = category.nominees.get(index);
//        System.out.printf("%s chose index %d in %s which is %s\n", voter.name, index, category.name,
//            chosenNominee.toString());

        voter.vote(chosenNominee);
      }
    }
  }

  /**
   * Again, this is a sim.
   */
  void findWinners() {
    for (Category category : categories) {
      int index = (int) (Math.random() * category.nominees.size());
      Nominee winner = category.nominees.get(index);
      category.setWinner(winner);
      System.out.printf("The winner for %s is %s.\n", category.name, winner.toString());
    }
  }

  void displayVoterScores() {
    Voter bestGuesser = null;

    for (Voter voter : voters) {
      for (Nominee nominee : voter.chosenNominees) {
        if (nominee.isWinner) {
          voter.correctGuesses++;
        }

        if (bestGuesser == null) {
          bestGuesser = voter;
        } else {
          if (voter.correctGuesses > bestGuesser.correctGuesses) {
            bestGuesser = voter;
          }
        }
      }

      System.out.printf("%s had %d correct guesses", voter.name, voter.correctGuesses);
      if (voter.equals(bestGuesser)) {
        System.out.printf(" and is leading the pack");
      }
      System.out.println();
    }

    System.out.printf("\nThe best guesser is %s with %d correct guesses.\n", bestGuesser.name,
        bestGuesser.correctGuesses);
  }

  void displayMovieStats() {
    MovieList.displayMovieStats();
  }

  void printPageBreak() {
    System.out.println("---------------------------------------------------------\n");
  }

  void run() {
    printPageBreak();
    initializeVoters();
    initializeCategories();
    System.out.println();

    displayCategoryNominees();
    printPageBreak();

    displayMoviePreshowStats();
    printPageBreak();

    vote();
    printPageBreak();

    findWinners();
    printPageBreak();

    displayVoterScores();
    printPageBreak();

    displayMovieStats();
    printPageBreak();

  }

  public static void main(String[] args) {
    OscarRunner or = new OscarRunner();
    or.run();
  }
}
