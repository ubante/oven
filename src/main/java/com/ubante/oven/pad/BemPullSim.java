package com.ubante.oven.pad;

/**
 * ubante 7/21/14 4:07 PM
 * This is very serious business.
 *
 * Total pulls is 96 after 10 chances
 * Total pulls is 109 after 10 chances
 * Total pulls is 1069 after 100 chances
 * Total pulls is 1103 after 100 chances
 * Total pulls is 11047 after 1000 chances
 * Total pulls is 11043 after 1000 chances
 *
 */
public class BemPullSim {
    public static void main(String[] args) {
        EggMachine bem = new EggMachine(5);
        Collection c;
        int globalPulls = 0;
        int chancesTotal = 1000;

        bem.printMonsterList();

        for (int chance=0; chance<chancesTotal; chance++) {
            c = new Collection(5);

            for (int i = 0; i < 20; i++) {
                Monster pulled = bem.pull();
                globalPulls++;
//                System.out.println("Pulled: " + pulled.name);
                c.add(pulled);

                if (c.isComplete) {
//                    System.out.println("Collection is complete after " + (i + 1) + " pulls.");
                    System.out.printf("%2d: Collection is complete after %d pulls.\n",
                            chance, i+1);
                    break;
                }
            }
        }

        System.out.printf("\nTotal pulls is %d after %d chances\n", globalPulls,
                chancesTotal);

    }
}
