package com.ubante.oven.twopowercoincidence;

import java.util.ArrayList;
import java.util.List;

/**
 * 10^3 is close to 2^10.  Are there any other bases that have a power that is close to a power of 2?
 */
public class CoincidentPowers {

    static class ComparisionResult {
        Double base, ratio;

        ComparisionResult(Double base, Double ratio) {
            this.base = base;
            this.ratio = ratio;
        }

    }

    static List<Double> getPowers(Double base, int count) {
        List<Double> powers = new ArrayList<Double>();
        for (double i=1; i<=count; i++) {
            powers.add(Math.pow(base,i));
        }
        return powers;
    }

    static ComparisionResult compare(Double currentBestTwoPower, Double bestRatio, Double testThisPower, List<Double> powersList) {
        Double winningBase2Power = 0d;

        for (Double base2Power : powersList) {
            // only care if the binary power is greater, eg 16 > 10
            if (base2Power<testThisPower) { continue; }

            // the first time base2Power gets past the above if is the only power we care about
            Double ratio = base2Power/testThisPower;
            if ( ratio < bestRatio) {
                System.out.printf("found a new best ratio - %f / %f = %f is better than %f\n",
                        base2Power,testThisPower,ratio,bestRatio);
                bestRatio = ratio;
                winningBase2Power = base2Power;
            } else {
                System.out.println("this is not a better ratio");
            }
            break;
        }

        return new ComparisionResult(winningBase2Power,bestRatio);
    }



    public static void main(String[] args) {
        // Was at 10 ^ ? (1000) and 2 ^ ? (1024)
        // This gave a base2 to base-10 ratio of  1.02400
//        Double base = new Double(10);

        // Was at 12 ^ ? (248832) and 2 ^ ? (262144)
        // This gave a base2 to base-12 ratio of  1.05350
//        Double base = new Double(12);

        // Was at 60 ^ ? (60) and 2 ^ ? (64)
        // This gave a base2 to base-60 ratio of  1.06667
        Double base = new Double(60);


        int highestPower = 10;

        // Make a list of powers for the given base
        List<Double> baseList = getPowers(base,highestPower);

        // Make a list of powers of two that is as large as necessary to include the largest power
        // of the given base
        List<Double> twoList = getPowers(new Double(2),20);

        // For each power of the given base
        Double bestTwoPower = 1d;
        Double bestBasePower = 1d;
        Double bestRatio = 1000d; // some big number
        for (Double power : baseList) {

            // Compare this to powers of two
            System.out.printf("Comparing %.0f to the powers of two\n",power);
            ComparisionResult answer = compare(bestTwoPower,bestRatio,power,twoList);

            // Remember if this is better
//            if (bestTwoPower.isNamed(answer)) {
            if (answer.ratio >= bestRatio) {
//                System.out.println("not better");
            } else {
//                System.out.println("this is better");
                bestRatio = answer.ratio;
                bestTwoPower = answer.base;
                bestBasePower = power;
            }
        }

        System.out.printf("\nYou gave this as the base: %.0f\n", base);
        System.out.printf("We checked up till %.0f ^ %d and found the best coincidence\n",
                base,highestPower);
        System.out.printf("Was at %.0f ^ ? (%.0f) ",
                base, bestBasePower);
        System.out.printf("and 2 ^ ? (%.0f)\n",
                bestTwoPower);
//        System.out.printf("Was at %.0f ^ %.0f (%.0f) ",
//                base, 0f, bestBasePower);
//        System.out.printf("and 2 ^ %.0f (%.0f)\n",
//                0f, bestTwoPower);

        System.out.printf("This gave a base2 to base-%.0f ratio of %8.5f\n",
                base, bestRatio);


    }

}
