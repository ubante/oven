package com.ubante.oven.hackerrank;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * From https://www.hackerrank.com/tests/info/faq
 *
 * Problem Statement
 * Write a program that adds two numbers prints the sum to STDOUT. Read the input from STDIN. The first line of your
 * input will contain an integer (N) that tells you how many more lines there are in the input. Each of the subsequent
 * N lines contain 2 integers). You need to print the sum of each pair on a separate line of STDOUT.

 Sample Input
 3
 1 5
 3 10
 999 -34343

 Sample Output
 6
 13
 -33344

 */
public class Solution {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("src\\main\\java\\com\\ubante\\oven\\hackerrank\\inputFile.txt"));
    String countLine = br.readLine();
    int numLines = Integer.valueOf(countLine);
//    System.out.printf("Found %d lines:\n", numLines);

    String line;
    for (int i=1; i<=numLines; i++) {
      line = br.readLine();
      String[] nums = line.split(" ");
      System.out.println(Integer.valueOf(nums[0]) + Integer.valueOf(nums[1]));
    }

    System.out.printf("");
  }
}
