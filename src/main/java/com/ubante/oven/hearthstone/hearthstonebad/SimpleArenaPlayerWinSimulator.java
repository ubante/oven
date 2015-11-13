package com.ubante.oven.hearthstone.hearthstonebad;

import java.util.Random;

/**
 * If you win X% of the time and can lose only three matches, how many matches should you expect to win?
 */
public class SimpleArenaPlayerWinSimulator {

  int matchesPlayed = 0;
  int matchesLost = 0;
  int matchesWon = 0;
  int historicalWinRate;
  double actualWinRate;
  int tournamentsPlayed = 0;
  int tournamentMatchesWon = 0;

  SimpleArenaPlayerWinSimulator(int percentage) {
    historicalWinRate = percentage;
  }

  void reset() {
    matchesLost = matchesPlayed = matchesWon = 0;
  }

  void calculateWinRate() {
    actualWinRate = (float) matchesWon / matchesPlayed;
  }

  void recordWin() {
    matchesPlayed++;
    matchesWon++;
    calculateWinRate();
  }

  void recordLoss() {
    matchesPlayed++;
    matchesLost++;
    calculateWinRate();
  }

  boolean playMatch() {
    Random r = new Random();
    int result = r.nextInt(100); // 0 to arg-1
//    System.out.println("result is " + result);
    if ( result < historicalWinRate ) {
      recordWin();
      return true;
    } else {
      recordLoss();
      return false;
    }
  }

  void playMatches(int numberOfMatches) {
    for(int i=0; i<numberOfMatches; i++) {
      playMatch();
    }
  }

  void playTournament() {
    reset();
    while (matchesLost < 3) {
      playMatch();
    }

    tournamentsPlayed++;
    tournamentMatchesWon = tournamentMatchesWon + matchesWon;
  }

  void displayStats() {
    String line = String.format("%d played, %d lost, %d won, %d%% expected, %4.1f%% actual",
        matchesPlayed, matchesLost, matchesWon, historicalWinRate, actualWinRate*100);
    System.out.println(line);
  }

  void displayTournamentRecord() {
    String line = String.format(
        "You played %d tournies with a historical win rate of %d%%, won %d total matches, winning %f games per tourney",
        tournamentsPlayed, historicalWinRate, tournamentMatchesWon, (float) tournamentMatchesWon / tournamentsPlayed);
    System.out.println(line);
  }

  public static void main(String[] args) {
    int letsSay = 90; // %
    System.out.println("Let's say you win " + letsSay + "% of the time....");

    SimpleArenaPlayerWinSimulator you = new SimpleArenaPlayerWinSimulator(letsSay);
    you.playMatch();
    you.displayStats();

    you.playMatches(98);
    you.displayStats();

    System.out.println("\nNow for realsies.");
    SimpleArenaPlayerWinSimulator forSerious = new SimpleArenaPlayerWinSimulator(letsSay);
    forSerious.playTournament();
    forSerious.displayStats();

    System.out.println("\nPractice like you fight."); // simulate 100 tournies
    int simulatedTournamentCount = 10000000; // 10M tournies
    for (int i=2; i<=simulatedTournamentCount; i++) {
//      if ( i/(simulatedTournamentCount/100)*(simulatedTournamentCount/100) == i ) {
//        System.out.printf(i + "... ");
//        if ( i/(simulatedTournamentCount/500)*(simulatedTournamentCount/500) == i ) {
//          System.out.println();
//        }
//      }

      forSerious.playTournament();
    }
    System.out.println();
    forSerious.displayTournamentRecord();
    /**
     * You played 10000000 tournies with a historical win rate of 90%, won 269997044 total matches, winning 26.999706 games per tourney
     * You played 10000000 tournies with a historical win rate of 72%, won 77164697 total matches, winning 7.716470 games per tourney
     * You played 10000000 tournies with a historical win rate of 72%, won 77112443 total matches, winning 7.711244 games per tourney
     * You played 10000000 tournies with a historical win rate of 50%, won 30005568 total matches, winning 3.000557 games per tourney
     * You played 10000000 tournies with a historical win rate of 50%, won 29992946 total matches, winning 2.999295 games per tourneyYou played 10000000 tournies with a historical win rate of 30%, won 12865751 total matches, winning 1.286575 games per tourney
     * You played 10000000 tournies with a historical win rate of 30%, won 12857312 total matches, winning 1.285731 games per tourney
     */
  }

}
