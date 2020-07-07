package com.ubante.oven.sixNimmt;

/**
 * This class uses composition to represent different types of Players.
 *
 * The PlayerLogic is not trustworthy so it should not maintain any state.
 */
public class Player {
    PlayerLogic logic;
    Integer points = 60;
    Hand hand = new Hand();
    String name;

    Player(PlayerLogic pl) {
        logic = pl;
        name = pl.name;
    }

    public String toString() {
        return "Name: " + name + ", points=" + points + ", hand=" + hand;
    }

    void emptyHand() { hand.empty(); }

    void addCard(Card c) { hand.add(c); }

    Card chooseCard(State state) {
        return logic.chooseCard(state, hand.copy());
    }
}
