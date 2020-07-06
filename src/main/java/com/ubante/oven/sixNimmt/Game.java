package com.ubante.oven.sixNimmt;

import java.util.ArrayList;

public class Game {
    ArrayList<Player> players = new ArrayList<>(2);

    Game () {

    }

    public void addPlayer(Player p) {
        players.add(p);
    }

    public void run() {

    }

    public void printConclusion() {
        System.out.println("That's all, folks.");
    }
}
