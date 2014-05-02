package com.ubante.oven.enums;
/**
 * ubante 1/24/14 12:56 PM
 * This is very serious business.
 * - Make a big list of ints with the same number of digits and no leading zeros.
 * - Find their ave
 * - Find the ave of their div10 x 10 + 5
 * - Find the ave of their div100 x 100 + 50
 * - Find the ave of their div1000 x 1000 + 500
 * - Compare the values
 *
 */
public class Approximater {
    static double DIGITS = 7;
    static int LISTSIZE = 10;

    static int[] getList() {
        int[] list = new int[LISTSIZE];
        for (int i=0; i<LISTSIZE; i++) {
            int r = (int) Math.random()*100000;
            list[i] = r;
            System.out.println(r);
        }

        return list;
    }

    static int[] getList2() {
        int min = (int) Math.pow(10.0,DIGITS);
        int max = (int) Math.pow(10.0,DIGITS+1)-1;
        int[] list = new int[LISTSIZE];
        for (int i=0; i<LISTSIZE; i++) {
            int r = min + (int) (Math.random() *
                    ((max - min) + 1));
            list[i] = r;
            System.out.println(r);
        }
        return list;
    }

    static double getAverage(int[] list) {
        int sum = 0;

        for (int num : list) {
            sum += num;
        }

        return sum / list.length;
    }

    static int[] shiftList(int[] list) {
        int[] newList = new int[LISTSIZE];
        for (int i=0; i<LISTSIZE; i++) {
            int shiftedNum = list[i] / 10;
            newList[i] = shiftedNum;
        }

        return newList;
    }

    public static void main(String[] args) {
        // Make the list
        int[] list = getList2();

        // Find ave
        double ave = getAverage(list);
        System.out.printf("Average(10^0) is \t%f%n", ave);

        // Find the ave of their div10 x 10 + 5
        list = shiftList (list);
        ave = getAverage(list);
        System.out.printf("Average(10^1) is \t%f%n", ave*10+5);

        // Find the ave of their div100 x 100 + 50
        list = shiftList (list);
        ave = getAverage(list);
        System.out.printf("Average(10^2) is \t%f%n", ave*100+50);

        // Find the ave of their div1000 x 1000 + 50
        list = shiftList (list);
        ave = getAverage(list);
        System.out.printf("Average(10^3) is \t%f%n", ave*1000+500);

        // Find the ave of their div10000 x 10000 + 50
        list = shiftList (list);
        ave = getAverage(list);
        System.out.printf("Average(10^4) is \t%f%n", ave*10000+5000);
    }
}

