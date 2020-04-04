package com.data.structure.algorithms.d1_linear_list;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {
//        ListNode l1 = new ListNode(1);
//        l1.next = new ListNode(2);
//        l1.next.next = new ListNode(3);
//        l1.next.next.next = new ListNode(4);
//        System.out.println(l1);
//
//        ListNode l2 = new ListNode(1);
////        l2.next = new ListNode(3);
////        l2.next.next = new ListNode(4);
////        l2.next.next.next = new ListNode(5);
////        System.out.println(l2);
//        ListNode listNode = swapPairs(l1);
//        System.out.println(listNode);
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(0, 2);
        System.out.println(list);
    }

    public static ListNode swapPairs(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode cursor1 = head;
        ListNode cursor2 = head.next;
        ListNode result = null;
        ListNode pre = null;
        int count = 0;
        while (cursor1 != null && cursor2 != null) {
            cursor1.next = cursor2.next;
            cursor2.next = cursor1;
            if (count == 0) {
                result = cursor2;
            } else {
                pre.next = cursor2;
            }
            count++;
            pre = cursor1;
            cursor1 = cursor1.next;
            cursor2 = cursor1 != null ? cursor1.next : null;
        }
        return result;
    }
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        int size = 0;
        ListNode curr1 = l1;
        while (curr1 != null) {
            size++;
            curr1 = curr1.next;
        }
        ListNode curr2 = l2;
        while (curr2 != null) {
            size++;
            curr2 = curr2.next;
        }
        int[] values = new int[size];
        int index = 0;
        curr1 = l1;
        while (curr1 != null) {
            values[index] = curr1.val;
            index++;
            curr1 = curr1.next;
        }
        curr2 = l2;
        while (curr2 != null) {
            values[index] = curr2.val;
            index++;
            curr2 = curr2.next;
        }
        for (int i = 0; i < size - 1; i++) {
            for (int j = i + 1; j < size; j++) {
                if (values[i] > values[j]) {
                    int temp = values[i];
                    values[i] = values[j];
                    values[j] = temp;
                }
            }
        }
        ListNode result = null;
        ListNode cursor = null;
        for (int i = 0; i < values.length; i++) {
            if (i == 0 ) {
                result = new ListNode(values[0]);
                cursor = result;
            } else {
                cursor.next = new ListNode(values[i]);
                cursor = cursor.next;
            }
        }
        return result;
    }
}
