package com.ubante.oven.sixNimmt;

import java.util.HashMap;

public class MultipleGameRunner {
    HashMap<String, Integer> totalScore = new HashMap<>();
    HashMap<String, Integer> gamesWon = new HashMap<>();
    int gameCounter = 0;

    void playGame() {
        gameCounter++;
        Game g = new Game();
        g.addPlayer(new PlayerLogic("Genero"));
        g.addPlayer(new RandomLogic("Random"));
        g.addPlayer(new HighCardLogic("HighCard"));
        g.run();

        // Increment the games won for the winner.
        String winner = g.winner;
        gamesWon.merge(winner, 1, Integer::sum);

        System.out.printf("%s won this game bringing their total wins to %d",
                winner, gamesWon.get(winner));

        HashMap<String, Integer> score = g.getPlayerScore();
        for (Player p: g.players) {
            int playerScore = score.get(p.name);
            totalScore.merge(p.name, playerScore, Integer::sum);
        }
    }

    void playMultipleGames(int gameCount) {
        for (int i = 0; i < gameCount; i++) {
            playGame();
        }
    }

    void printSummary() {
        System.out.printf("\n\nSummary of %d games:\n", gameCounter);
        for (String name: totalScore.keySet()) {
            float ave = (float) totalScore.get(name) / gameCounter;
            System.out.printf("%15s won %d games with an average score of %4.1f\n",
                    name, gamesWon.get(name), ave);
        }
    }

    public static void main(String[] args) {
        System.out.println("Starting up multiple game runner.");

        MultipleGameRunner mgr = new MultipleGameRunner();
        mgr.playMultipleGames(10);
        mgr.printSummary();
    }
}

/*
Summary of 10 games:
         Random won 1 games with an average score of -8.3
         Genero won 1 games with an average score of  7.2
       HighCard won 8 games with an average score of 28.8
 */
