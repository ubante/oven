package com.ubante.oven.leetcode;

/**
 * Created by J on 2/7/2016.
 */
class ListNode {
  int val;
  ListNode next;
  ListNode(int x) { val = x; }

  void display() {
    System.out.printf("%d->", val);

    if (next != null) {
      next.display();
    } else {
      System.out.println("NULL");
    }
  }

  void addTail(ListNode tail) {
    if (next != null) {
      next.addTail(tail);
    } else {
      next = tail;
    }
  }

}
