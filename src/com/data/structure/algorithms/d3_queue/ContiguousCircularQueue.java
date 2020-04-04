package com.data.structure.algorithms.d3_queue;

/**
 * 循环队列的顺序表实现
 * 插入数据的一端叫队尾，
 * 取出数据的一端叫队头。
 * 循环队列解决了队列假溢出的问题。
 */
public class ContiguousCircularQueue<E> {
    // 队列的长度
    private int maxSize;
    private static final int DEFAULT_MAX_SIZE = 5;
    private E[] array;
    // 队列头
    private int front = 0;
    // 队列尾
    private int rear = 0;

    public ContiguousCircularQueue() {
        this(DEFAULT_MAX_SIZE);
    }

    public ContiguousCircularQueue(int maxSize) {
        this.maxSize = maxSize;
        array = (E[]) new Object[maxSize];
    }

    // 在队列的尾部添加元素
    public E push(E element) {
        // 先判断队列是否已满
        if (isFull()) {
            return null;
        }
        array[rear] = element;
        rear++;
        rear = rear % maxSize; // 避免越界
        return element;
    }

    // 在队列的头部取出元素
    public E poll() {
        // 先判断队列是否为空
        if (isEmpty()) {
            return null;
        }
        E value = array[front];
        array[front] = null;
        front++;
        front = front % maxSize; // 避免越界
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null) {
                sb.append(array[i]).append(',');
            }
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

    public static void main(String[] args) {
        ContiguousCircularQueue<Integer> circularQueue = new ContiguousCircularQueue<>(5);
        System.out.println("空队列：");
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
        System.out.println("取出元素：" + circularQueue.poll());
        System.out.println(circularQueue);
        System.out.println("添加元素 5：" + circularQueue.push(5));
        System.out.println(circularQueue);
        System.out.println("取出元素：" + circularQueue.poll());
        System.out.println(circularQueue);
        System.out.println("取出元素：" + circularQueue.poll());
        System.out.println(circularQueue);
        System.out.println("取出元素：" + circularQueue.poll());
        System.out.println(circularQueue);

    }
}
