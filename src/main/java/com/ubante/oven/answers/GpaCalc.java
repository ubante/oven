package com.ubante.oven.answers;

/**
 * Created by J on 9/29/2014.
 */
public class GpaCalc {

  public static void main(String[] args) {
    String studentName = "Kenneth Logger";
    int pendingGPA = 4;

    System.out.print(studentName + " - ");
    yup(pendingGPA);
  }

  public static void yup(int pendingGPA) {
    if (pendingGPA == 4) {
      System.out.print("A");
    } else if (pendingGPA == 3) {
      System.out.print("B");
    } else if (pendingGPA == 2) {
      System.out.print("C");
    } else if (pendingGPA == 1) {
      System.out.print("D");
    } else {
      System.out.print("Invalid");
    }

  }
}
