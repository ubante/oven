package com.ubante.oven.sixNimmt.models;

import com.ubante.oven.sixNimmt.logics.PlayerLogic;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * The game controls the points that players have lost in past rounds.  Since
 * the board needs to know about players, then the board will track the points
 * lost in the current round.
 */
public class Game {
    ArrayList<Player> players = new ArrayList<>(2);
    Board board = new Board();  // Seems wasteful since I will immediately replace it.
    int roundCounter;
    String winner;

    Game () {

    }

    public void addPlayer(PlayerLogic pl) {
        Player p = new Player(pl);
        players.add(p);
        board.addPlayer(p);
    }

    void reset() {
        board.reset();
    }

    void runRound() {
        reset();

        // TODO when the players have one card left, they don't need to choose.
        for (int turn = 1; turn <= board.initialHandSize; turn++ ) {
            System.out.println("Round #" + roundCounter + " / Turn #" + turn);

            BoardState state = board.getState();
            HashMap<Card, Player> turnCards = new HashMap<>();
            for (Player player : players) {
                Card chosenCard = player.chooseCard(state);

                // TODO need to validate chosenCard since player logic is unreliable.

                turnCards.put(chosenCard, player);
            }
            board.processTurn(turnCards);
        }
    }

    public void run() {
        // Play rounds until there is a winner.
        roundCounter = 0;
        while (! board.winnerFound()) {
            roundCounter++;
            System.out.println("Round " + roundCounter);

            runRound();

            if (roundCounter > 20) {
                System.out.println("Exiting because too many rounds.");
                board.display();
                System.exit(2);
            }
        }

        winner = board.winner.name;
    }

    public void printConclusion() {
        System.out.printf("That's all, folks.  The winner is %s.\n", winner);

        for (Player p: players) {
            System.out.println(p);
        }
    }

    HashMap<String, Integer> getPlayerScore() {
        HashMap<String, Integer> score = new HashMap<>();
        for (Player p: players) {
            score.put(p.name, p.points);
        }

        return score;
    }
}
