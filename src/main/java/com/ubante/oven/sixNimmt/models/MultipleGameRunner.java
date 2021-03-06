package com.ubante.oven.sixNimmt.models;

import com.ubante.oven.sixNimmt.logics.CardCountingLogic;
import com.ubante.oven.sixNimmt.logics.HighCardLogic;
import com.ubante.oven.sixNimmt.logics.PlayerLogic;
import com.ubante.oven.sixNimmt.logics.RandomLogic;

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
        g.addPlayer(new CardCountingLogic("TheCount"));

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
            int wins = 0;
            if (gamesWon.containsKey(name)) {
                wins = gamesWon.get(name);
            }

            System.out.printf("%15s won %d games with an average score of %4.1f\n",
                    name, wins, ave);
        }
    }

    public static void main(String[] args) {
        System.out.println("Starting up multiple game runner.");

        MultipleGameRunner mgr = new MultipleGameRunner();
        mgr.playMultipleGames(1000);
        mgr.printSummary();
    }
}

/*
After giving cards without a safety description, a middle value, CCL improved.
Summary of 1000 games:
         Random won 74 games with an average score of  3.1
       TheCount won 428 games with an average score of 25.6
         Genero won 73 games with an average score of  3.1
       HighCard won 425 games with an average score of 26.4

Summary of 1000 games:
         Random won 56 games with an average score of  2.7
       TheCount won 398 games with an average score of 24.4
         Genero won 58 games with an average score of  3.2
       HighCard won 488 games with an average score of 28.9

Summary of 10 games:
         Random won 1 games with an average score of -8.3
         Genero won 1 games with an average score of  7.2
       HighCard won 8 games with an average score of 28.8
 */
