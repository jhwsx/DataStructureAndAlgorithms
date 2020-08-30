package com.data.structure.algorithms.programmerxiaohui.chapter2.part3;

import com.data.structure.algorithms.programmerxiaohui.chapter2.part1.MyArray;

import java.util.Arrays;

/**
 * 循环队列的数组实现
 *
 * @author wangzhichao
 * @date 7/28/20
 */
public class MyArrayQueue {
    private int[] array;
    /**
     * 队列的容量
     */
    private int capacity;
    /**
     * 队头元素的索引
     */
    private int front;
    /**
     * 队尾元素的索引
     */
    private int rear;

    public MyArrayQueue(int capacity) {
        this.capacity = capacity;
        array = new int[capacity];
    }

    /**
     * 入队操作
     *
     * @param data
     * @throws Exception
     */
    public void enqueue(int data) throws Exception {
        if (isFull()) {
            throw new IllegalArgumentException("队列已满");
        }
        array[rear] = data;
        rear++;
        rear = rear % capacity;
    }

    /**
     * 出队操作
     *
     * @return
     * @throws Exception
     */
    public int dequeue() throws Exception {
        if (isEmpty()) {
            throw new IllegalArgumentException("队列已空");
        }
        int result = array[front];
        array[front] = 0;
        front++;
        front = front % capacity;
        return result;
    }

    /**
     * 队列是否已满
     *
     * @return
     */
    public boolean isFull() {
        return (rear + 1) % capacity == front;
    }

    /**
     * 队列是否已空
     *
     * @return
     */
    public boolean isEmpty() {
        return rear == front;
    }

    /**
     * 队列的长度
     *
     * @return
     */
    public int length() {
        return (rear - front + capacity) % capacity;
    }

    /**
     * 输出元素
     * <p>
     * 只输出有效的元素
     */
    public void output() {
        int current = front;
        int length = length();
        StringBuffer sb = new StringBuffer("[");
        for (int i = 0; i < length; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(array[current]);
            current++;
            current = current % capacity;
        }
        sb.append("]");
        System.out.println(sb);
    }

    public void output2() {
        for (int i = front; i != rear; i = (i + 1) % array.length) {
            System.out.println(array[i]);
        }
    }

    // 测试代码
    public static void main(String[] args) throws Exception {
        MyArrayQueue queue = new MyArrayQueue(5);
        System.out.println("入队操作：");
        queue.enqueue(1);
        queue.output();
        queue.enqueue(2);
        queue.output();
        queue.enqueue(3);
        queue.output();
        queue.enqueue(4);
        queue.output();
        try {
            queue.enqueue(5);
            queue.output();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("出队操作：");
        System.out.println("出队：" + queue.dequeue());
        queue.output();
        System.out.println("出队：" + queue.dequeue());
        queue.output();
        System.out.println("出队：" + queue.dequeue());
        queue.output();
        System.out.println("出队：" + queue.dequeue());
        queue.output();
        try {
            System.out.println("出队：" + queue.dequeue());
            queue.output();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.dequeue();
        queue.dequeue();
        queue.output();
        queue.enqueue(5);
        queue.enqueue(6);
        queue.output();
    }
}
