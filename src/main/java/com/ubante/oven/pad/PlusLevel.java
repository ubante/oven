package com.ubante.oven.pad;

import java.util.ArrayList;
import java.util.List;

/**
 * ubante 7/25/14 5:43 PM
 * This is very serious business.
 */
public class PlusLevel {
    int level;
    int preFusionLevel;
    int cost = 0;
    int preFusionCost = 0;
    int fusionDepth;
    List<PlusLevel> feeders = new ArrayList<>();

    PlusLevel(int level) {
        this.level = level;
        compute();
    }

    int div(int dividend, int divisor) {
        int quotient = dividend/divisor;

        return quotient;
    }

    void genericCompute(int maxPlusLevel) {
        int remainingLevels = level;

        // First satisfy the part of having at least on plus in each of the six buckets.
        int[] plusValues = { 1, 1, 1, 1, 1, 1 };
        remainingLevels -= 6;

        // Fill each bucket as much as possible with the remaining levels
        int i = 0;
        while (remainingLevels > 0) {
            if (remainingLevels < maxPlusLevel) {
                plusValues[i] += remainingLevels;
                remainingLevels = 0;
            } else {
                plusValues[i] += (maxPlusLevel-1);
                remainingLevels -= (maxPlusLevel-1);
            }

            i++;
        }

        // Make the base first
        preFusionLevel = plusValues[0];
        PlusLevel base = new PlusLevel(preFusionLevel);
        preFusionCost = base.cost;
        cost = preFusionCost;

        // Make feeders of those sizes
        for (int feederIndex=0; feederIndex<5; feederIndex++) {
            PlusLevel feeder = new PlusLevel(plusValues[feederIndex+1]);
            feeders.add(feeder);
            cost += feeder.cost;
        }

        // Now that we have the base and the list of feeders, increase the cost to account
        // for the second level of fusion
        cost += level*1000;

        return;
    }


    void compute() {

        // The trivial case.  This egg popped out this way.
        if (level == 1) {
            preFusionLevel = 1;
            fusionDepth = 0;
            return;
        }

        // One level of fusion.
        if (level <= 6) {
            preFusionLevel = 1;
            fusionDepth = 1;

            // Assign fresh eggs as feeders.
            for (int i=1; i<level; i++) {
                feeders.add(new PlusLevel(1));
                cost = level*1000;
            }
            return;
        }

        // Two levels of fusion.  Use all five feeder slots.  Fill them like overflowing buckets
        // but make sure there is at least one plus in each bucket.
        if (level <= 36) {
            fusionDepth = 2;

            int maxPlusLevel = 6;
            genericCompute(maxPlusLevel);
            return;
        }

        // Three levels of fusion - almost there.
        if (level <= 216) {
            fusionDepth = 3;

            int maxPlusLevel = 36;
            genericCompute(maxPlusLevel);
            return;
        }

        // Highest level of fusion.
        if (level <= 297) {
            fusionDepth = 4;

            int maxPlusLevel = 216;
            genericCompute(maxPlusLevel);
            return;
        }

        System.out.println("Values greater than 297 are not allowed.");

    }


    void display() {

        System.out.printf("+:%-3d FusionDepth:%d, TotalCost:%d, NumFeeders:%d --> %d + ",
                level, fusionDepth, cost, feeders.size(), preFusionLevel);
        for (PlusLevel feeder : feeders) {
            System.out.printf("%d ", feeder.level);
        }
        System.out.println();

    }


    public static void main(String[] args) {
        int[] sizes = { 1, 2, 5, 6, 7, 12, 20, 30, 35, 36, 37, 41, 42, 100, 196, 216, 217,
                218, 250, 290, 297, 300 };
        PlusLevel pl;
        for (int i=0; i<sizes.length; i++) {
            pl = new PlusLevel(sizes[i]);
            pl.display();
        }
    }
}

/*
+:1   FusionDepth:0, TotalCost:0, NumFeeders:0 --> 1 +
+:2   FusionDepth:1, TotalCost:2000, NumFeeders:1 --> 1 + 1
+:5   FusionDepth:1, TotalCost:5000, NumFeeders:4 --> 1 + 1 1 1 1
+:6   FusionDepth:1, TotalCost:6000, NumFeeders:5 --> 1 + 1 1 1 1 1
+:7   FusionDepth:2, TotalCost:9000, NumFeeders:5 --> 2 + 1 1 1 1 1
+:12  FusionDepth:2, TotalCost:20000, NumFeeders:5 --> 6 + 2 1 1 1 1
+:20  FusionDepth:2, TotalCost:37000, NumFeeders:5 --> 6 + 6 5 1 1 1
+:30  FusionDepth:2, TotalCost:59000, NumFeeders:5 --> 6 + 6 6 6 5 1
+:35  FusionDepth:2, TotalCost:70000, NumFeeders:5 --> 6 + 6 6 6 6 5
+:36  FusionDepth:2, TotalCost:72000, NumFeeders:5 --> 6 + 6 6 6 6 6
+:37  FusionDepth:3, TotalCost:101000, NumFeeders:5 --> 32 + 1 1 1 1 1
+:41  FusionDepth:3, TotalCost:113000, NumFeeders:5 --> 36 + 1 1 1 1 1
+:42  FusionDepth:3, TotalCost:116000, NumFeeders:5 --> 36 + 2 1 1 1 1
+:100 FusionDepth:3, TotalCost:292000, NumFeeders:5 --> 36 + 36 25 1 1 1
+:196 FusionDepth:3, TotalCost:584000, NumFeeders:5 --> 36 + 36 36 36 36 16
+:216 FusionDepth:3, TotalCost:648000, NumFeeders:5 --> 36 + 36 36 36 36 36
+:217 FusionDepth:4, TotalCost:853000, NumFeeders:5 --> 212 + 1 1 1 1 1
+:218 FusionDepth:4, TotalCost:857000, NumFeeders:5 --> 213 + 1 1 1 1 1
+:250 FusionDepth:4, TotalCost:957000, NumFeeders:5 --> 216 + 30 1 1 1 1
+:290 FusionDepth:4, TotalCost:1139000, NumFeeders:5 --> 216 + 70 1 1 1 1
+:297 FusionDepth:4, TotalCost:1168000, NumFeeders:5 --> 216 + 77 1 1 1 1
Values greater than 297 are not allowed.
+:300 FusionDepth:0, TotalCost:0, NumFeeders:0 --> 0 +
 */