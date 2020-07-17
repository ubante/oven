package com.ubante.oven.sixNimmt.models;

import com.ubante.oven.sixNimmt.logics.PlayerLogic;

/**
 * This class uses composition to represent different types of Players.
 *
 * The PlayerLogic is not trustworthy so it should not maintain any state.
 */
public class Player {
    PlayerLogic logic;
    Integer points = Settings.startingPoints;
    Hand hand = new Hand();
    String name;

    Player(PlayerLogic pl) {
        logic = pl;
        name = pl.name;
    }

    public String toString() {
        return "Name: " + name + ", points=" + points + ", hand=" + hand;
    }

    void reset() {
        emptyHand();
        logic.reset();

    }
    void emptyHand() { hand.empty(); }

    void addCard(Card c) { hand.add(c); }

    Card chooseCard(BoardState state) {
        String beforeHand = hand.toString();
        Card chosenCard = logic.chooseCard(state, hand.copy());

        // Validate chosenCard since player logic is unreliable.
        boolean found = hand.remove(chosenCard);
        if (! found) {
            System.out.printf("%s chose card %d.\n", name, chosenCard.faceValue);
            System.out.printf("Their hand was %s\n", beforeHand);
            System.out.println("This is an error - exiting.");
            System.exit(91);
        }

        return chosenCard;
    }

    /**
     * Call this to get the players last card instead of asking player to choose
     * a card.
     *
     * @return Card
     */
    Card getLastCard() {
       Card last = hand.get(0);
       hand.remove(last);

       return last;
    }

    int chooseRow(BoardState state) {
        int choice = logic.chooseRow(state);
        // Internally, rows start at 0.  This might be confusing.
        // Validate player choice because it is unreliable.
        if (choice < 0 || Settings.rowCount+1 < choice) {
            System.out.printf("%s chose row %d.\n", name, choice);
            System.out.printf("Valid choices are 0-%d inclusive - exiting.", Settings.rowCount-1);
            System.exit(92);
        }
        return choice;
    }
}
