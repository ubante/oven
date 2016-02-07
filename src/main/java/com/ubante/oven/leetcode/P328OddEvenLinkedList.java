package com.ubante.oven.leetcode;

import java.util.LinkedHashMap;

/**
 *
 * https://leetcode.com/problems/odd-even-linked-list/
 *
 * Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.
 *
 * You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.
 *
 * Example:
 * Given 1->2->3->4->5->NULL,
 * return 1->3->5->2->4->NULL.
 *
 * Note:
 * The relative order inside both the even and odd groups should remain as it was in the input.
 * The first node is considered odd, the second node even and so on ...
 */
public class P328OddEvenLinkedList {
  public ListNode oddEvenList(ListNode head) {
    // temporary root
    ListNode even = new ListNode(-2);
    ListNode odd = new ListNode(-1);

    ListNode pointer = head;
    while (pointer != null) {
      if ((pointer.val % 2) == 0) {
        even.addTail(new ListNode(pointer.val));
      } else {
        odd.addTail(new ListNode(pointer.val));
      }

      pointer = pointer.next;
    }

    // skip root
    even = even.next;
    odd = odd.next;
    odd.addTail(even);

    return odd;
  }


  public static void main(String[] args) {
    ListNode ln = new ListNode(1);
    for (int i=2; i<=5; i++) {
      ln.addTail(new ListNode(i));
    }

    System.out.printf("Given  ");
    ln.display();

    P328OddEvenLinkedList solution = new P328OddEvenLinkedList();
    ListNode lnX = solution.oddEvenList(ln);

    System.out.printf("return ");
    lnX.display();
  }
}

