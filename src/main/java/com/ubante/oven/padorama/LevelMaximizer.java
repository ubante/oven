package com.ubante.oven.padorama;

/**
 * Created by ubante on 6/14/14.
 */
public class LevelMaximizer {



    public static void main(String[] args) {
        int cost;

        // This fuses a single +1 to a base monster
        Monster baseMonsterA = new Monster("Dragon");
        Monster a = new Monster(3);

        baseMonsterA.printStatus();
        a.printStatus();

        cost = baseMonsterA.fuse(a);
        System.out.println("\nAfter fusing (" + cost + "):");
        baseMonsterA.printStatus();
        a.printStatus();

        // This fuses a list of five +1 monsters to a base monster
        Monster baseMonsterB = new Monster("Pingwin");
        MonsterList listB = new MonsterList();
        for (int i=1; i<=5; i++) {
            listB.add(new Monster(1));
        }
        cost = baseMonsterB.fuse(listB);
        System.out.printf("\nAfter fusing %d monsters (%d)\n",
                listB.getSize(),cost);
        baseMonsterB.printStatus();

        // This fuses three +1 to a +1.  Repeat five times then fuse the
        // resulting five +4 to a +1 resulting in a +21.
        int costPelican = 0;
        System.out.println();
        Monster baseMonsterC = new Monster("Pelican");
        MonsterList outerList = new MonsterList();
        for (int i=1; i<=5; i++) {
            Monster intermediate = new Monster(1);
            MonsterList innerList = new MonsterList();
            for (int j=1; j<=3; j++) {
                innerList.add(new Monster(1));
            }
            costPelican += intermediate.fuse(innerList);
            System.out.printf("After %d inner fuses, cost is %d and intermediate has skill %d\n",
                    i,costPelican,intermediate.skillLevelHp);

            outerList.add(intermediate);
        }

        int costPelicanOuterFusion = baseMonsterC.fuse(outerList);
        costPelican += costPelicanOuterFusion;
        System.out.printf("When we combine the %d intermediates with the base," +
                " we get a skill level of %d with a cost of %d and a total cost " +
                        "of %d\n",
                outerList.getSize(),
                baseMonsterC.skillLevelHp,
                costPelicanOuterFusion,
                costPelican
                );

        // Find the sum of 1 to final skill level
        int basicSum = (1 + baseMonsterC.skillLevelHp) * baseMonsterC.skillLevelHp / 2;
        System.out.printf("\nThe simple approach would have cost %d\n" +
                        "So the cascading approach has a savings of %2.0f%%\n",
                basicSum*1000,
//                72.3);
                (1-((float) costPelican/(basicSum*1000)))*100);
//                1-(costPelican/basicSum*1000));

    }
}


/**

 */