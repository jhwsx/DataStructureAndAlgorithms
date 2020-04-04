package com.data.structure.algorithms.d1_linear_list;
/*
手写双向链表， 实现增删改查，同时对比自己的 LinkedList 和源码 LinkedList的异同点
 */
public class DoubleLinkedList<E> {
    private Node<E> head = null;
    private Node<E> tail = null;

    public void add(E item) {
        if (head == null) {
            head = new Node(item, null, null);
            tail = head;
        } else {
            Node<E> newNode = new Node<>(item, tail, null);
            tail.next = newNode;
            tail = newNode;
        }
    }

    public void add(int index, E item) {
        // 找到目标位置的前节点和后节点
        Node<E> curr = head;
        int count = 0;
        while (curr != null) {
            if (count == index) {
                break;
            }
            count++;
            curr = curr.next;
        }
        Node<E> pre = curr.pre;
        Node<E> next = curr;
        // 开始连接
        Node<E> newNode = new Node<>(item, pre, next);
        pre.next = newNode;
        next.pre = newNode;
    }

    public E set(int index, E item) {
        // 找到目标位置
        Node<E> curr = head;
        int count = 0;
        while (curr != null) {
            if (count == index) {
                break;
            }
            count++;
            curr = curr.next;
        }
        E oldItem = curr.item;
        curr.item = item;
        return oldItem;
    }

    public E get(int index) {
        // 找到目标位置
        Node<E> curr = head;
        int count = 0;
        while (curr != null) {
            if (count == index) {
                break;
            }
            count++;
            curr = curr.next;
        }
        return curr.item;
    }

    public E remove(E item) {
        // 找到对应的节点
        Node<E> curr = head;
        Node<E> target = null;
        while (curr != null) {
            if (curr.item.equals(item)) {
                target = curr;
                break;
            }
            curr = curr.next;
        }
        if (target == null) {
            return null;
        }
        // 删除对应的节点
        target.pre.next = target.next;
        target.next.pre = target.pre;
        return target.item;
    }

    public void transverse() {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.item + ", ");
            curr = curr.next;
        }
        System.out.println();
    }

    public void reverseTransverse() {
        Node curr = tail;
        while (curr != null) {
            System.out.print(curr.item + ", ");
            curr = curr.pre;
        }
        System.out.println();
    }
    private static class Node<E> {
        E item;
        Node<E> pre;
        Node<E> next;

        public Node(E item, Node<E> pre, Node<E> next) {
            this.item = item;
            this.pre = pre;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        DoubleLinkedList<Integer> linkedList = new DoubleLinkedList();
        for (int i = 0; i < 5; i++) {
            linkedList.add(i);
        }
        System.out.println("正向遍历：");
        linkedList.transverse();
        System.out.println("反向遍历：");
        linkedList.reverseTransverse();
        System.out.println("删除元素 2，结果返回：" + linkedList.remove(2));
        System.out.println("正向遍历：");
        linkedList.transverse();
        System.out.println("在索引 2 处插入元素 2：");
        linkedList.add(2, 2);
        System.out.println("正向遍历：");
        linkedList.transverse();
        System.out.println("修改索引 2 处的元素为 -2，结果返回：" + linkedList.set(2, -2));
        System.out.println("正向遍历：");
        linkedList.transverse();
        System.out.println("获取索引 2 处的元素：" + linkedList.get(2));
    }
}
