package com.ubante.oven.sixNimmt;

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

        for (int turn = 1; turn <= board.initialHandSize; turn++ ) {
            System.out.println(roundCounter + "/" + turn);

            State state = board.getState();
            HashMap<Card, Player> turnCards = new HashMap<>();
            for (Player player : players) {
                Card chosenCard = player.chooseCard(state);
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

            if (roundCounter > 1) {
                System.out.println("Exiting because too many rounds.");
                board.display();
                System.exit(2);
            }
        }
    }

    public void printConclusion() {
        System.out.println("That's all, folks.");
    }
}
