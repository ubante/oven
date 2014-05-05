package com.ubante.oven.uvaonlinejudge;

/**
 * Created by J on 5/4/2014.
 */
public class ThreeNPlusOne {
    int n;
    int cycleLength = 0;

    ThreeNPlusOne(int input) { this.n = input; }

    void run() {

//        System.out.printf("%d ", n);
        cycleLength++;

        while (n != 1) {
            if ( (n%2) == 1 ) {
                n = 3*n +1;
            } else {
                n = n/2;
            }
//            System.out.printf("%d ", n);
            cycleLength++;
        }
//        System.out.println();
    }

    static void demo() {
        int input = 22;
        ThreeNPlusOne problem = new ThreeNPlusOne(input);
        problem.run();

        System.out.printf("\nCycle length of %d is %d\n",input,problem.cycleLength);
    }

    public static void main(String[] args) {
//        demo();

//        int i = 10; int j = 200;
//        int i = 201; int j = 210;
//        int i = 900; int j = 1000;
        int i = Integer.parseInt(args[0]);
        int j = Integer.parseInt(args[1]);
        int maxCycleLength = 0;
        ThreeNPlusOne problem;
        for (int ctr=i; ctr<=j; ctr++) {
            problem = new ThreeNPlusOne(ctr);
            problem.run();
            if (problem.cycleLength > maxCycleLength) {
                maxCycleLength = problem.cycleLength;
//                System.out.printf("Found a new winner: %d has a cycle-length of %d\n",ctr,maxCycleLength);
            }
        }

//        System.out.printf("The max cycle-length for integers from %d to %d (inclusive) is %d\n", i, j, maxCycleLength);
        System.out.printf("%d %d %d\n",i,j,maxCycleLength);
    }

}
