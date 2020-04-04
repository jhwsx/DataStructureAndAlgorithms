package com.data.structure.algorithms.d3_queue;

/**
 * 循环双端队列
 */
class MyCircularDeque {

    /**
     * Initialize your data structure here. Set the size of the deque to be k.
     */
    // 存放数据的数组
    private int[] array;
    // 容量
    private int size;
    // 队列头
    private int front = 0;
    // 队列尾
    private int rear = 0;

    public MyCircularDeque(int k) {
        // 循环队列最多存放 maxSize - 1 个元素，要想存放 k 个元素，则 size 应该为 k + 1.
        size = k + 1;
        array = new int[size];
    }

    /**
     * Adds an item at the front of Deque. Return true if the operation is successful.
     */
    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        // 队头进元素，队头指针减一
        front = (front - 1 + size) % size;
        // 元素从队头进队列
        array[front] = value;
        return true;
    }

    /**
     * Adds an item at the rear of Deque. Return true if the operation is successful.
     */
    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        // 队尾它本身就指的是空闲位置，队尾进元素
        array[rear] = value;
        // 队尾指针加1，取模
        rear = (rear + 1) % size;
        return true;
    }

    /**
     * Deletes an item from the front of Deque. Return true if the operation is successful.
     */
    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        //  队头指针加1，取模
        front = (front + 1) % size;
        return true;
    }

    /**
     * Deletes an item from the rear of Deque. Return true if the operation is successful.
     */
    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        // 队尾指针减1，取模
        rear = (rear - 1 + size) % size;
        return true;
    }

    /**
     * Get the front item from the deque.
     */
    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        return array[front];
    }

    /**
     * Get the last item from the deque.
     */
    public int getRear() {
        if (isEmpty()) {
            return -1;
        }
        // rear 指向的是空闲位置，rear指针减1的位置才是有值的
        return array[(rear - 1 + size) % size];
    }

    /**
     * Checks whether the circular deque is empty or not.
     */
    public boolean isEmpty() {
        return front == rear;
    }

    /**
     * Checks whether the circular deque is full or not.
     */
    public boolean isFull() {
        return (front == ((rear + 1) % size));
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */