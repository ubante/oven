package com.ubante.oven.sixNimmt;

public class SimulationRunner {

    public static void main(String[] args) {
        System.out.println("Starting up.");

        Game g = new Game();
        g.addPlayer(new PlayerLogic("P1"));
        g.addPlayer(new RandomLogic("P2"));
        g.addPlayer(new PlayerLogic("P3"));
        g.addPlayer(new PlayerLogic("P4"));
        g.run();

        g.printConclusion();
    }
}
