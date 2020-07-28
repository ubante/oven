package com.ubante.oven.sixNimmt.logics;

import com.ubante.oven.sixNimmt.models.*;

import java.util.*;

/**
 * This is based on HumanLogic as of late July, 2020.
 */
public class CardCountingLogic extends PlayerLogic {
    int previousScore = Settings.startingPoints;
    HashMap<Card, Player> everyonesLastCards = null;
    ArrayList<Integer> playedCards = new ArrayList<>();
    ArrayList<Integer> remainingCards = new ArrayList<>();
    boolean isHandRecorded = false;
    BoardState boardState;

    // These two could be combined.
    ArrayList<Integer> zoneBoundaries = new ArrayList<>();
    HashMap<Integer, Row> zoneMap = new HashMap<>();

    public CardCountingLogic(String name) {
        super(name);

        reset();
    }

    public void reset() {
        playedCards.clear();
        remainingCards.clear();
        for (int i = 1; i <= Settings.deckSize; i++) {
            remainingCards.add(i);
        }
    }

    void printBoard() {
        System.out.println("\nBoard:");
        for (int i = 0; i < 4; i++) {
            String rowLine = String.format("%d (%d): %s", i+1, boardState.rows[i].getBeefHeadSum(),
                    boardState.rows[i].getColumnarRepresentation());
            System.out.println(rowLine);
        }
    }

    /***
     * The four rows form different zones:
     * (A) the cards lower than the lowest row
     * (B) the cards lower than the second lowest row but not in (A)
     * (C) the cards lower than the second highest row but not in (A) or (B)
     * (D) the cards lower than the highest row but not in (A), (B), or (C)
     * (E) the cards higher than the highest row
     *
     * Each zone is divided in to low and high subzones.
     *
     * When choosing a card, you may want to choose the highest card in a zone or
     * the lowest card in a zone.  This is where knowing the number of free spaces
     * in a row is important.
     *
     * The best endgame for a five-player game is to have many cards that are in
     * high B.  Inversely, for the same game, ending a round with many cards in low
     * B is dangerous.
     */
    void setBoardZones() {
        zoneBoundaries.clear();
        zoneMap.clear();
        for (Row r: boardState.rows) {
            Integer highestValueInRow = r.getHighestValue();
            zoneBoundaries.add(highestValueInRow);
            zoneMap.put(highestValueInRow, r);
        }
        Collections.sort(zoneBoundaries);
    }

    void recordHand(Hand hand) {
        if (isHandRecorded) {
            return;
        }

        for (Card c: hand.cards) {
            // Tempted to make a method for these two lines so I can
            // also call it in recordLastChosenCards().
            playedCards.add(c.faceValue);
            remainingCards.remove(c.faceValue);
        }
        isHandRecorded = true;
    }

    void recordLastChosenCards(HashMap<Card, Player> cards) {
        everyonesLastCards = cards;

        if (everyonesLastCards == null) {
            return;
        }

        for (Card c : cards.keySet()) {

            // Since we record our starting cards, make sure we do not
            // record them twice.
            if (! playedCards.contains(c.faceValue)) {
                playedCards.add(c.faceValue);
                Collections.sort(playedCards);  // Should convert these to sets.
            }
            remainingCards.remove(c.faceValue);
        }
    }

    int getInput(int maxValue) {
        Scanner input = new Scanner(System.in);
        int choice;

        do {
            try {
                choice = input.nextInt();
            } catch (InputMismatchException ime) {
                System.out.println("Please input an integer.");
                choice = -2;
            }

            if (choice < 1 || choice > maxValue) {
                System.out.printf("Try again [1-%d]: ", maxValue);
                input.nextLine();
            }

        } while (choice < 1 || choice > maxValue);

        return choice;
    }

    // What are the odds of drawing at least one card of numGoodCards from numCandidates
    // if you have numAttempts?
    float odds(int numGoodCards, int numAttempts, int numCandidates) {
        float oppositeOdds = 1;
        for (int i = 1; i <= numAttempts; i++) {
            oppositeOdds *= (float) (numCandidates - numGoodCards) / numCandidates;
        }

        return (1-oppositeOdds)*100;  // Return a percentage.
    }

    /**
     * This evaluates a single card for each row.
     *
     * To avoid creating a Safety class, this returns an ArrayList the numeric and text evaluations.
     *
     * The greater the numeric evaluation, the safer the card.
     * Safety above 5 is good.  Safety below 5 is not good.
     *
     * @param cardValue is the face value of that card
     * @param zoneBoundary is boundary for that row
     * @param turn is the game's current turn
     * @return ArrayList of a float score and a human-readable string score.
     */
    ArrayList<Object> measureSafety(int cardValue, int zoneBoundary, int turn) {
        // A cardGap of 1 means you have the next card and no one can
        // squeeze in.
        int cardGap = cardValue - zoneBoundary;
        int freeSpaces = zoneMap.get(zoneBoundary).getFreeSpaces();
        int numPlayers = boardState.playerCount();
        StringBuilder explanation = new StringBuilder();

        // Return both a number and string.
        ArrayList<Object> safetyValue = new ArrayList<>();

        // If this card doesn't belong in this boundary, return empty
        // string so caller can try again.
        int index = zoneBoundaries.indexOf(zoneBoundary);
        if (index < zoneBoundaries.size()-1) {
            int nextZoneBoundary = zoneBoundaries.get(index+1);
            if (cardValue > nextZoneBoundary) {
                return null;
            }
        }

        for (int seenCard: playedCards) {
            if (zoneBoundary < seenCard && seenCard < cardValue) {
                cardGap--;
            }
        }

        // Unless this row is picked up, guaranteed safe.
        // For the future, tiebreakers should be the row's beefHeadSum.
        if (cardGap <= freeSpaces) {
            safetyValue.add(9f);
            safetyValue.add("+");
            return safetyValue;
        }

        /*
         If there are less than 5 players, you can safely choose a
         row with just one card.  Of course, you have to watch for
         someone going under.
        */
        if (numPlayers <= freeSpaces) {
            safetyValue.add(8f);
            safetyValue.add("+ row can fit all players");
            return safetyValue;
        }

        // Row is almost full and you have the next card.  You will
        // pick up this row unless someone goes under and picks this row.
        if (cardGap == 1 && freeSpaces == 0) {
            safetyValue.add(1f);
            safetyValue.add("--");
            return safetyValue;
        }

        // If the row is almost full, what are the odds that someone
        // squeeze in and take the row instead of you if you play this
        // card?
        if (freeSpaces == 0) {
            safetyValue.add(2f);
            safetyValue.add("-   You will pick up this row if there are no squeezes.");
            return safetyValue;
        }

        // You pick up the row if someone squeezes in.
        if (cardGap == 2 && freeSpaces == 1) {
            safetyValue.add(3f);
            safetyValue.add("-   If someone has the single card that can squeeze, they will probably play it now.");
            return safetyValue;
        }

        if (freeSpaces == 1) {
            // To compute odds, we need to consider the number of cards held by other players.
            int cardsHeld = (11-turn) * (numPlayers-1);
            float squeezeOdds = odds(cardGap-1, cardsHeld, remainingCards.size());
            explanation.append(String.format("#    -> There is one space; %2.1f%% chance that someone can squeeze.  ",
                    squeezeOdds));
            safetyValue.add(4f + (100-squeezeOdds)/100);
            safetyValue.add(String.valueOf(explanation));
            return safetyValue;
        }

        if (cardValue > zoneBoundary) {
            // Compute the likelihood that this row will bust.
            explanation.append(String.format("?    -> %d/%d other players have to play %d/%d cards for you to bust.  " +
                            "%d unknowns",
                    freeSpaces, numPlayers-1, freeSpaces, cardGap-1, remainingCards.size()));

            safetyValue.add(2f);
            safetyValue.add(String.valueOf(explanation));
        }

        // Return null if none of the above applies so caller can keep trying.
        // TODO This is a problem because a score of 1, which is real bad, is
        //  worse than no score, which is just average.
        return null;
    }

    public Card chooseCard(BoardState boardState, Hand hand) {
        this.boardState = boardState;
        float defaultCardValue = 5f;
        String defaultCardDescription = "This card has no description.";

        recordHand(hand);
        recordLastChosenCards(boardState.lastChosenCards);

        System.out.println("\\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/");
        int myScore = boardState.scores.get(name);
        if (myScore < previousScore) {
            System.out.println("*******************************************************");
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            System.out.println("You have lost " + (previousScore-myScore) + " points!\n");
            previousScore = myScore;
        }
        System.out.println("Opponents:");
        for (String name: boardState.scores.keySet()) {
            System.out.println(String.format("%20s: %d", name, boardState.scores.get(name)));
        }

        printBoard();
        setBoardZones();
        System.out.printf("There are %d unknown cards and %d cards shown: ", remainingCards.size(), playedCards.size());
        System.out.println(playedCards);

        // Using a loop because the other methods don't pad.
        StringBuilder zones = new StringBuilder();
        for (Integer zb: zoneBoundaries) {
            zones.append(String.format("|%2s", zb));
        }
        System.out.printf("   |  %s|\n", zones);
        ArrayList<Card> cards = hand.getCards();
        ArrayList<Object> safety;
        int bestCardIndex = 0;
        float bestSafetyNumber = 0f;
        for (int i = 1; i <= cards.size(); i++) {
            int cardValue = cards.get(i-1).faceValue;

            StringBuilder zonePadding = new StringBuilder();
            String safetyLevel = "";
            float safetyNumber;
            for (int zb: zoneBoundaries) {
                if (cardValue <= zb) {
                    continue;
                }
                zonePadding.append("   ");

                // Decide how safe this card is.
                if (safetyLevel.equals("")) {
                    safety = measureSafety(cardValue, zb, 10-hand.size()+1);
                    if (safety == null) {
                        // If this card didn't give it a safety description,
                        // assign it the default value.
                        safetyNumber = defaultCardValue;
                        safetyLevel = defaultCardDescription;
                    } else {
                        safetyNumber = (float) safety.get(0);
                        safetyLevel = (String) safety.get(1);
                    }

                    if (safetyNumber > bestSafetyNumber) {
                        bestSafetyNumber = safetyNumber;
                        bestCardIndex = i;
                    }
                }
            }

            System.out.printf("%2d: %s%2d %s\n", i, zonePadding.toString(), cardValue, safetyLevel);
        }

        System.out.printf("CCL choosing a card: [1-%s] {%s}\n", cards.size(), bestCardIndex);
        int cardChoice = bestCardIndex;
        if (bestCardIndex == 0) {
            // If there are no safety suggestions, then all the cards are in zone A.
            // Choose the highest valued card.  This could be improved.
            cardChoice = cards.size();
        }

        return hand.get(cardChoice-1);
    }

    // The default row to choose is the first row.
    public int chooseRow(BoardState boardState) {
        this.boardState = boardState;
        printBoard();
        int lowestPoints = 99;
        int lowestPointRow = -1;
        for (int i = 0; i < 4; i++) {
            if (boardState.rows[i].getBeefHeadSum() < lowestPoints) {
                lowestPointRow = i;
            }
        }

        System.out.println("CCL choose row " + lowestPointRow);
        return lowestPointRow - 1;
    }

}
