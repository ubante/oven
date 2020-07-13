package com.ubante.oven.sixNimmt.models;

import com.ubante.oven.sixNimmt.logics.HighCardLogic;
import com.ubante.oven.sixNimmt.logics.HumanLogic;
import com.ubante.oven.sixNimmt.logics.PlayerLogic;
import com.ubante.oven.sixNimmt.logics.RandomLogic;

public class SingleGameRunner {

    public static void main(String[] args) {
        System.out.println("Starting up.");

        Game g = new Game();
        g.addPlayer(new PlayerLogic("Genero"));
        g.addPlayer(new RandomLogic("Random"));
        g.addPlayer(new HighCardLogic("HighCard"));
        g.addPlayer(new HumanLogic("TheCond"));
        g.run();

        g.printConclusion();
    }
}
