package com.ubante.oven.leetcode;

/**
 * Given an integer, write a function to determine if it is a power of three.
 *
 * Follow up:
 * Could you do it without using any loop / recursion?
 */
public class P326PowerOfThree {
  int size;

  P326PowerOfThree(int size) {
    this.size = size;
  }

  public boolean isPowerOfThree(int n) {
    int product = 1;

    while (product <= n) {
      if (product == n) {
        return true;
      }

      product = product * 3;
    }

    return false;
  }

  void run() {
    for (int i=0; i<=size; i++) {
      System.out.printf("%d: %b\n", i, isPowerOfThree(i));
    }
  }

  public static void main(String[] args) {
    P326PowerOfThree solution = new P326PowerOfThree(30);
    solution.run();
  }
}
