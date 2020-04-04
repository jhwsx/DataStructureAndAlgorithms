package com.data.structure.algorithms.d1_linear_list;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public  ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        // copy l1 to result
        ListNode result = null;
        ListNode curr1 = l1;
        ListNode cursor = null;
        while (curr1 != null) {
            if (result == null) {
                result = new ListNode(curr1.val);
                cursor = result;
            } else {
                cursor.next = new ListNode(curr1.val);
                cursor = cursor.next;
            }
            curr1 = curr1.next;
        }
        // loop l2,
        ListNode curr2 = l2;
        ListNode curr = result;
        while (curr2 != null) {
            int value = curr2.val;
            while (curr != null) {
                if (curr.next != null ) {
                    if (value >= curr.val && value <= curr.next.val) {
                        ListNode newNode = new ListNode(value);
                        newNode.next = curr.next;
                        curr.next = newNode;
                        curr = newNode;
                        break;
                    }  
                } else {
                    if (value >= curr.val) {
                        ListNode newNode = new ListNode(value);
                        newNode.next = curr.next;
                        curr.next = newNode;
                        curr = newNode;
                        break;
                    }
                }
                if (value < curr.val) {
                    ListNode newNode = new ListNode(value);
                    newNode.next = curr;
                    result = newNode;
                    curr = newNode;
                    break;
                }
                curr = curr.next;
            }
            curr2 = curr2.next;
        }
        return result;
    }
}