package com.ubante.oven.pad;

/**
 * Going from +25 to +145 in steps of 5 will cost ~2.125M.
 */
public class PlusSim {
    int startLevel;
    int currentLevel;
    int initialBudget;
    int availableBudget;
    int increment;
    int levelCounter = 0;
    boolean doVerbosePrint = false;

    PlusSim(int startLevel, int initialBudget, int increment) {
        this.startLevel = startLevel;
        this.initialBudget = initialBudget;
        this.increment = increment;
    }

    void compute() {
        currentLevel = startLevel;
        availableBudget = initialBudget;

        while (availableBudget > ((currentLevel + increment) * 1000)) {
            levelCounter++;
            int cost = (currentLevel + increment) * 1000;
            availableBudget -= cost;
            currentLevel += increment;
            if (doVerbosePrint) {
                System.out.printf("IncCtr:%2d Pay:%6d Rem:%7d NewPlusLvl:%3d\n",
                        levelCounter, cost, availableBudget, currentLevel);
            }
        }

        System.out.printf("\nStarting at %d and incrementing %d at a time with a budget of %d:\n",
                startLevel, increment, initialBudget);
        System.out.printf("IncCtr:%2d Rem:%7d NewPlusLvl:%3d\n",
                levelCounter, availableBudget, currentLevel);
        System.out.printf("The efficiency of this setup is %3d per plus level.\n",
                (initialBudget-availableBudget)/(currentLevel-startLevel));
    }

    public static void main(String[] args) {
        PlusSim p1 = new PlusSim(20, 2200000, 5);
        p1.compute();
        PlusSim p2 = new PlusSim(20, 2200000, 10);
        p2.compute();
        PlusSim p3 = new PlusSim(20, 2200000, 30);
        p3.compute();
        PlusSim p4 = new PlusSim(20, 2200000, 50);
        p4.compute();
    }

}
