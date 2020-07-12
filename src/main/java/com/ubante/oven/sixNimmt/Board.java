package com.ubante.oven.sixNimmt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * The board controls the cards, all the cards, everywhere.
 */
public class Board {
    Deck deck;
    ArrayList<Player> players = new ArrayList<>(2);
    Row[] rows = new Row[4];  // Tempted to create a RowSet class.
    int initialHandSize = 10;
    boolean debugMode = true;
    int turnCounter = 0;
    Player winner = null;

    Board() {
        reset();
    }

    void addPlayer(Player p) {
        players.add(p);
    }

    void reset() {
        deck = new Deck(104);  // Might parameterize this in the future.

        // Start the rows with a card each.
        deck.shuffle();
        for (int i = 0; i < 4; i++) {
            rows[i] = new Row();
            rows[i].addCard(deck.getCard());
        }

        // Deal 10 cards to each player.
        for (Player p: players) {
            p.emptyHand();
            for (int i = 0; i < initialHandSize; i++) {
                Card c = deck.getCard();
                p.addCard(c);
            }
        }

        turnCounter = 0;
    }

    BoardState getState() {
        HashMap<String, Integer> playerScores = new HashMap<>();
        for (Player p: players) {
            playerScores.put(p.name, p.points);
        }

        return new BoardState(rows, playerScores);
    }

    Row getLowestRow() {
        Row lowestRow = null;
        for (Row r: rows) {
            if (lowestRow == null) {
                lowestRow = r;
            } else {
                if (lowestRow.getHighestValue() > r.getHighestValue()) {
                    lowestRow = r;
                }
            }
        }

        return lowestRow;
    }

    void punishWithBeefHeads(Player p, int rowIndex, Card c) {
        System.out.println(p.name  + " will pick up row #" + (rowIndex+1));

        // Assign the rows beef head score to this player.
        Row row = rows[rowIndex];
        p.points -= row.beefHeadSum;
        System.out.println("Deducting " + row.beefHeadSum + " points from " + p.name);
        System.out.println(p.name + " now has " + p.points + " points");

        // Replace the row with this card.
        row.replaceWith(c);
    }

    void appendChosenCardsToRows(TreeMap<Card, Player> sortedCards) {
        // Loop through all the cards that the player chose for this
        // turn.
        for (Map.Entry<Card, Player> entry: sortedCards.entrySet()) {
            Card c = entry.getKey();

            // For each card, find the correct row.
            System.out.println("Finding a row for card: " + c.faceValue);
            Row winningRow = null;
            int winningIndex = -1;
            for (int i = 0; i < rows.length; i++) {
                if (rows[i].getHighestValue() < c.faceValue) {
                    if (winningRow == null) {
                        winningRow = rows[i];
                        winningIndex = i;
                        continue;
                    }
                    if (winningRow.getHighestValue() < rows[i].getHighestValue()) {
                        winningRow = rows[i];
                        winningIndex = i;
                    }
                }
            }

            if (winningRow == null) {
                System.out.println("There was a fatal problem with the winning row.  Exiting.");
                System.exit(8);
            }

            if (winningRow.nearFull()) {
                System.out.println("Found a row but it's near full.");
                punishWithBeefHeads(entry.getValue(), winningIndex, c);
            } else {
                winningRow.addCard(c);
            }
            display();
        }

    }

    void processTurn(HashMap<Card, Player> cards) {
        turnCounter++;

        // Order the cards.
        TreeMap<Card, Player> sortedCards = new TreeMap<>(cards);
        Card lowestCard = sortedCards.firstKey();
        Player lowestPlayer = sortedCards.get(lowestCard);

        // Print all hands for debugging.
        if (debugMode) {
            for (Player p: players) {
                System.out.println(p.name + " -> " + p.hand);
            }
        }

        System.out.print("-- ordered chosen cards: ");
        for (Map.Entry<Card, Player> entry: sortedCards.entrySet()) {
            System.out.printf("%s (%s), ", entry.getKey(), entry.getValue().name);
        }
        System.out.println();

        // If the lowest valued card is lower than the lowest valued
        // row, then prompt that player to select a row.
        System.out.println("Lowest card: " + lowestCard);
        Row lowestRow = getLowestRow();
        System.out.println("Lowest row:" + lowestRow);
        if (lowestCard.faceValue < lowestRow.getHighestValue()) {
            int chosenRowIndex = lowestPlayer.chooseRow(getState());

            // TODO need to validate chosenRowIndex since player logic is unreliable.

            punishWithBeefHeads(lowestPlayer, chosenRowIndex, lowestCard);
            sortedCards.remove(lowestCard);
        }

        // Append remaining chosen cards to the appropriate rows.
        appendChosenCardsToRows(sortedCards);

        // The winner is determined only at the end of rounds.
        if (turnCounter == initialHandSize) {
            Player topScorer = null;
            boolean isLoserPresent = false;
            for (Player p: players) {
                if (p.points < 0) {
                    isLoserPresent = true;
                }
                if (topScorer == null) {
                    topScorer = p;
                    continue;
                }
                if (p.points > topScorer.points) {
                    topScorer = p;
                }
            }

            if (isLoserPresent) {
                winner = topScorer;
            }
        }
    }

    /**
     * There is a winner only when there is a loser.
     *
     * @return gameWon
     */
    boolean winnerFound() {
        return (winner != null);
    }

    void display() {
        System.out.println("=================================================");
        for (int i = 0; i < 4; i++) {
            System.out.println(i+1 + " " + rows[i].getColumnarRepresentation());
        }
        System.out.println("=================================================");
    }
}
