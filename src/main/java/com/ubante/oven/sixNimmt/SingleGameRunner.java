package com.ubante.oven.sixNimmt;

public class SingleGameRunner {

    public static void main(String[] args) {
        System.out.println("Starting up.");

        Game g = new Game();
        g.addPlayer(new PlayerLogic("Genero"));
        g.addPlayer(new RandomLogic("Random"));
        g.addPlayer(new HighCardLogic("HighCard"));
//        g.addPlayer(new HumanLogic("TheCond"));
        g.run();

        g.printConclusion();
    }
}
