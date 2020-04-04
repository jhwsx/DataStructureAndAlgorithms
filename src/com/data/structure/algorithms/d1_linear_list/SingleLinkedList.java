package com.data.structure.algorithms.d1_linear_list;
/*
手写一个单链表，并且实现单链表元素的逆置，（a0, a1,a2,a3,..an）-> (an,an-1,… a1, a0),
算法的空间复杂度和时间复杂度尽可能低
 */
public class SingleLinkedList<T> {
    private Node<T> head;
    public void add(T item) {
        Node newNode = new Node(item);
        if (head == null) {
            head = newNode;
        } else {
            Node next = head;
            while(next.next != null) {
                next = next.next;
            }
            Node tail = next;
            tail.next = newNode;
        }
    }

    public void transverse() {
        Node curr = head;
        while(curr != null) {
            System.out.print(curr.item + ", ");
            curr = curr.next;
        }
        System.out.println();
    }

    public void reverse() {
        Node curr = head;
        Node pre = null;
        while (curr != null) {
            Node next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        head = pre;
    }

    class Node<T> {
        public T item;
        public Node<T> next;
        public Node(T item) {
            this.item = item;
        }
    }

    public static void main(String[] args) {
        SingleLinkedList<Integer> singleLinkedList = new SingleLinkedList<>();
        for (int i = 0; i < 5; i++) {
            singleLinkedList.add(i);
        }
        System.out.println("遍历链表：");
        singleLinkedList.transverse();
        System.out.println("逆置链表并遍历：");
        singleLinkedList.reverse();
        singleLinkedList.transverse();
    }
}
