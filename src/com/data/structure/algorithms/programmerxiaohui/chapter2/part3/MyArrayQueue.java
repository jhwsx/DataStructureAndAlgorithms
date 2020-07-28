package com.data.structure.algorithms.programmerxiaohui.chapter2.part3;

import com.data.structure.algorithms.programmerxiaohui.chapter2.part1.MyArray;

/**
 * 队列的数组实现
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
     * @param data
     * @throws Exception
     */
    public void enqueue(int data) throws Exception {

    }

    /**
     * 出队操作
     * @return
     * @throws Exception
     */
    public int dequeue() throws Exception {
        return 0;
    }

//    public boolean isFull() {
//        return (rear + 1) % capacity
//    }
}
