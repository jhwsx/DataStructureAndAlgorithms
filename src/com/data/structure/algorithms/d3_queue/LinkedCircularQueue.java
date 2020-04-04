package com.data.structure.algorithms.d3_queue;

// 循环列表的链表实现
public class LinkedCircularQueue<E> {
    private int maxSize;
    private static final int DEFAULT_MAX_SIZE = 5;
    // 链表的头节点
    private Node<E> head;
    // 队列头
    private int front = 0;
    // 队列尾
    private int rear = 0;
    public LinkedCircularQueue() {
        this(DEFAULT_MAX_SIZE);
    }

    public LinkedCircularQueue(int maxSize) {
        this.maxSize = maxSize;
        // 创建一个固定大小的单向链表
        head = new Node<>(null, null);
        Node<E> curr = head;
        for (int i = 1; i < maxSize; i++) {
            curr.next = new Node<>(null, null);
            curr = curr.next;
        }
        curr.next = head;
    }
    // 在队列的尾部添加元素
    public E push(E element) {
        if (isFull()) {
            return null;
        }
        Node<E> node = getNodeByIndex(rear);
        node.value = element;
        rear++;
        rear = rear % maxSize;
        return element;
    }

    // 在队列的头部取出元素
    public E poll() {
        if (isEmpty()) {
            return null;
        }
        Node<E> node = getNodeByIndex(front);
        E value = node.value;
        node.value = null;
        front++;
        front = front % maxSize;
        return value;
    }

    // 队列是否已满
    public boolean isFull() {
        return (front == ((rear + 1) % maxSize));
    }

    // 队列是否为空
    public boolean isEmpty() {
        return front == rear;
    }

    public int size() {
        return ((rear - front + maxSize) % maxSize);
    }

    public Node<E> getNodeByIndex(int index) {
        Node<E> curr = head;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        return curr;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        Node<E> curr = head;
        for (int i = 0; i < maxSize; i++) {
            if (curr.value != null) {
                sb.append(curr.value).append(',');
            }
            curr = curr.next;
        }
        sb.append(']');
        sb.append(", size = ");
        sb.append(size());
        sb.append(", isFull() = ");
        sb.append(isFull());
        sb.append(", isEmpty() = ");
        sb.append(isEmpty());
        return sb.toString();
    }

    class Node<E> {
        E value;
        Node<E> next;

        Node(E value, Node<E> next) {
            this.value = value;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        LinkedCircularQueue<Integer> circularQueue = new LinkedCircularQueue<>(5);
        System.out.println(circularQueue);
        System.out.println("添加元素 1：" + circularQueue.push(1));
        System.out.println(circularQueue);
        System.out.println("添加元素 2：" + circularQueue.push(2));
        System.out.println(circularQueue);
        System.out.println("添加元素 3：" + circularQueue.push(3));
        System.out.println(circularQueue);
        System.out.println("取出元素：" + circularQueue.poll());
        System.out.println(circularQueue);
        System.out.println("添加元素 4：" + circularQueue.push(4));
        System.out.println(circularQueue);
        System.out.println("添加元素 5：" + circularQueue.push(5));
        System.out.println(circularQueue);
    }
}
