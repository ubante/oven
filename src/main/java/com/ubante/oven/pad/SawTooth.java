package com.ubante.oven.pad;

import java.util.ArrayList;
import java.util.List;

/**
 * ubante 7/14/14 10:48 AM
 * This is very serious business.
 *
 * Resting at 50%: l:10  s:80  xp: 5500  st:0  wst: 0  time:28.13 rest:3.87
 * Resting at 80%: l:10  s:80  xp: 5500  st:2  wst:13  time:20.13 rest:3.07
 *
 */
public class SawTooth {
    int xp = 0;
    int stam = 0;
    int level = 0;
    int levelCost = 13;
    int time = 0;
    int resttime = 0;
    int timePerGame = 4;
    int timePerStam = 10;
    int stoneCount = 0;
    double partialStam = 0;
    int wastedStam = 0;
    List<String> csv = new ArrayList<>();


    void printStatus() {
        System.out.printf("l:%2d  s:%2d  xp:%5d  st:%d  wst:%2d  time:%5.2f rest:%4.2f\n",
                level, stam, xp, stoneCount, wastedStam, time/60.0, resttime/60.0);
        int hour = time/60;
        int min = time % 60;
        csv.add(String.format("%d:%02d,%d\n", hour, min, xp));
    }

    void printCsv() {
        for ( String line : csv ) {
            System.out.print(line);
        }
//        System.out.println(csv);
    }

    void start(int startingStam, int maxXp) {
        stam = startingStam;

        // one shot
        printStatus();
        while ( level < 10 ) {
            stam -= levelCost;
            xp += 6500;
            time += timePerGame;
            if (xp > maxXp) {
                System.out.println("Ding.");
                level++;
                stam = startingStam + level;
                xp -= maxXp;
            }
            printStatus();

            if ( (stam>(levelCost-5)) && (stam<levelCost)) {
                int breakTime = (levelCost - stam) * timePerStam;
                System.out.println("Taking a quick " + breakTime + " min break.");
                time += breakTime;
                stam = levelCost;
                resttime += breakTime;
                printStatus();
            } else if ( (stam<levelCost) && ((1.0*xp/maxXp) > 0.50)) {
                System.out.println("2hr break to not waste a stone.");
                time += (2 * 60);
                resttime += (2 * 6);
                stam += (2 * 6);
                printStatus();
            } else if ( stam<levelCost ) {
                System.out.println("Stoning.");
                wastedStam += stam;
                stam = startingStam + level;
                stoneCount++;
                printStatus();
            }
        }

        System.out.println("Hit lvl10 and exiting.");
        return;
    }

    public static void main(String[] args) {
        System.out.println("Starting...");
        SawTooth s = new SawTooth();
        s.start(70, 43000);
        s.printCsv();
    }
}
