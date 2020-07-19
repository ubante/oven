package com.ubante.oven.sixNimmt.models;

import com.ubante.oven.sixNimmt.logics.*;

public class SingleGameRunner {

    public static void main(String[] args) {
        System.out.println("Starting up.");

        Game g = new Game();
        g.addPlayer(new PlayerLogic("Genero"));
        g.addPlayer(new RandomLogic("Random"));
        g.addPlayer(new HighCardLogic("HighCard"));
        g.addPlayer(new HumanLogic("TheCond"));
        g.addPlayer(new CardCountingLogic("TheCount"));
        g.run();

        g.printConclusion();
    }
}
