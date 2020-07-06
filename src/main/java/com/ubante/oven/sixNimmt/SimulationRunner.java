package com.ubante.oven.sixNimmt;

public class SimulationRunner {

    public static void main(String[] args) {
        System.out.println("Starting up.");

        Game g = new Game();
        g.addPlayer(new Player("P1"));
        g.addPlayer(new Player("P2"));
        g.addPlayer(new Player("P3"));
        g.run();

        g.printConclusion();
    }
}
