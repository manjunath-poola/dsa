package com.manju.interview.questions.leetcode;

import java.util.Objects;

public class AddTwoNumbers {
    /*
        You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
        You may assume the two numbers do not contain any leading zero, except the number 0 itself.
        Example 1:


        Input: l1 = [2,4,3], l2 = [5,6,4]
        Output: [7,0,8]
        Explanation: 342 + 465 = 807.
        Example 2:

        Input: l1 = [0], l2 = [0]
        Output: [0]
        Example 3:

        Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
        Output: [8,9,9,9,0,0,0,1]


        Constraints:

        The number of nodes in each linked list is in the range [1, 100].
        0 <= Node.val <= 9
        It is guaranteed that the list represents a number that does not have leading zeros.
*/
    public static void main(String[] args) {
//     l1= [2,4,3], l2 = [5,6,4]
        ListNode l1 = new ListNode(2);
        ListNode l11 = new ListNode(4);
        l1.next = l11;
        l11.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        ListNode l21 = new ListNode(6);
        l2.next = l21;
        l21.next = new ListNode(4);
        ListNode l3 = addTwoNumbers(l1, l2);
        print(l3);

    }

    static void print(ListNode tmp) {
        ListNode l = tmp;
        while (Objects.nonNull(l)) {
            System.out.print(l.val + " ");
            l = l.next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (Objects.isNull(l1) || Objects.isNull(l2)) {
            return l1;
        }
        if (Objects.nonNull(l1) && Objects.isNull(l2)) {
            return l1;
        }
        if (Objects.nonNull(l2) && Objects.isNull(l1)) {
            return l2;
        }
        ListNode header = null, tail = null;
        int val = 0, carry = 0;
        while (Objects.nonNull(l1) || Objects.nonNull(l2)) {
            val = (Objects.nonNull(l1) ? l1.val : 0) + (Objects.nonNull(l2) ? l2.val : 0) + carry;
            if (val > 9) {
                carry = val / 10;
                val %= 10;
            } else {
                carry = 0;
            }
            ListNode newNode = new ListNode(val);
            if (Objects.isNull(header)) {
                tail = header = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
            if (Objects.nonNull(l1)) {
                l1 = l1.next;
            }
            if (Objects.nonNull(l2)) {
                l2 = l2.next;
            }

        }
        if (carry > 0) {
            tail.next = new ListNode(carry);
        }
        return header;
    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

}