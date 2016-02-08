package com.ubante.oven.leetcode;

/**
 * Given an integer array nums, find the sum of the elements between indices i and j (i ? j), inclusive.
 *
 * Example:
 * Given nums = [-2, 0, 3, -5, 2, -1]
 *
 * sumRange(0, 2) -> 1
 * sumRange(2, 5) -> -1
 * sumRange(0, 5) -> -3
 * Note:
 * You may assume that the array does not change.
 * There are many calls to sumRange function.
 *
 * https://leetcode.com/problems/range-sum-query-immutable/
 */
public class P303RangeSumQuery {
  int[] nums;

  public P303RangeSumQuery(int[] nums) {
    this.nums = nums;
  }

  public int sumRange(int i, int j) {
    int sum = 0;

    for (int index=i; index<=j; index++) {
      sum = sum + nums[index];
    }

    return sum;
  }

  public static void main(String[] args) {
    int[] nums = {-2, 0, 3, -5, 2, -1};

    P303RangeSumQuery P303RangeSumQuery = new P303RangeSumQuery(nums);
    System.out.println("total of 0..1: " + P303RangeSumQuery.sumRange(0, 1));
    System.out.println("total of 1..2: " + P303RangeSumQuery.sumRange(1, 2));
    System.out.println("total of 0..5: " + P303RangeSumQuery.sumRange(0, 5));
  }
}


// Your P303RangeSumQuery object will be instantiated and called as such:
// P303RangeSumQuery P303RangeSumQuery = new P303RangeSumQuery(nums);
// P303RangeSumQuery.sumRange(0, 1);
// P303RangeSumQuery.sumRange(1, 2);