package com.ubante.oven.sixNimmt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * The board controls the cards, all the cards, everywhere.
 */
public class Board {
    Player winner = null;
    Deck deck;
    ArrayList<Player> players = new ArrayList<>(2);
    Row[] rows = new Row[4];
    int initialHandSize = 10;

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
    }

    State getState() {
        return new State();  // TODO: uh
    }

    Row getLowestRow() {
        Row lowestRow = null;
        for (Row r: rows) {
            if (lowestRow == null) {
                lowestRow = r;
            } else {
                if (lowestRow.getHighestValue().faceValue > r.getHighestValue().faceValue) {
                    lowestRow = r;
                }
            }
        }

        return lowestRow;
    }

    void punishWithBeefHeads(Player p, int rowIndex, Card c) {
        System.out.println(p.name  + " will pick up row #" + rowIndex);

        // Assign the rows beef head score to this player.

        // Replace the row with this card.
    }

    void appendChosenCardsToRows(TreeMap<Card, Player> sortedCards) {
        
    }

    void processTurn(HashMap<Card, Player> cards) {
//        System.out.print("processing: ");
//        for (Card c: cards.keySet()) {
//            System.out.print(c + " ");
//        }
//        System.out.println();

        // Order the cards.
        TreeMap<Card, Player> sortedCards = new TreeMap<>(cards);
        Card lowestCard = sortedCards.firstKey();
        Player lowestPlayer = sortedCards.get(lowestCard);

        System.out.print("-- ordered: ");
        for (Map.Entry<Card, Player> entry: sortedCards.entrySet()) {
            System.out.print(entry.getKey() + " ");
        }
        System.out.println();

        // If the lowest valued card is lower than the lowest valued
        // row, then prompt that player to select a row.
        System.out.println("Lowest card: " + lowestCard);
        Row lowestRow = getLowestRow();
        System.out.println("Lowest row:" + lowestRow);
        if (lowestCard.faceValue < lowestRow.getHighestValue().faceValue) {
            int chosenRowIndex = lowestPlayer.chooseRow(getState());
            punishWithBeefHeads(lowestPlayer, chosenRowIndex, lowestCard);
            cards.remove(lowestCard);
        }

        // Append remaining chosen cards to the appropriate rows.
        appendChosenCardsToRows(sortedCards);

    }

    boolean winnerFound() {
        return winner != null;
    }

    void display() {
        for (Player p: players) {
            System.out.println(p);
        }
    }
}
