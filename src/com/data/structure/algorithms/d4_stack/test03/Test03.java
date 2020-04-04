package com.data.structure.algorithms.d4_stack.test03;

import java.util.LinkedList;

/**
 * 225. Implement Stack using Queues
 * https://leetcode.com/problems/implement-stack-using-queues/
 *
 * @author wangzhichao
 * @since 2020/4/4
 */
public class Test03 {
    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        while (!stack.empty()) {
            System.out.println(stack.pop());
        }
    }
}

/**
 * 思路：用数据队列和辅助队列，模拟栈的先进后出，队列是队尾进队头出，
 * 也就是说每次取值要取队列的队尾元素，数据队列出队到辅助队列，留下最后
 * 一个元素返回，辅助队列再把元素出队到数据队列
 */
class MyStack {
    private Queue<Integer> dataQueue = new Queue<>();

    /** Initialize your data structure here. */
    public MyStack() {

    }

    /** Push element x onto stack. */
    public void push(int x) {
        dataQueue.enqueue(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        Queue<Integer> assistQueue = new Queue<>();
        // 数据队列出队到辅助队列，留下最后一个元素
        int size = dataQueue.size();
        for (int i = 0; i < size-1; i++) {
            assistQueue.enqueue(dataQueue.dequeue());
        }
        // 最后一个元素出队，这就是返回结果
        int result = dataQueue.dequeue();
        // 辅助队列再出队到数据队列
        int assistSize = assistQueue.size();
        for (int i = 0; i < assistSize; i++) {
            dataQueue.enqueue(assistQueue.dequeue());
        }
        return result;
    }

    /** Get the top element. */
    public int top() {
        Queue<Integer> assistQueue = new Queue<>();
        // 数据队列出队到辅助队列，留下最后一个元素
        int size = dataQueue.size();
        for (int i = 0; i < size-1; i++) {
            assistQueue.enqueue(dataQueue.dequeue());
        }
        // 最后一个元素出队，这就是返回结果
        int result = dataQueue.dequeue();
        assistQueue.enqueue(result);
        // 辅助队列再出队到数据队列
        int assistSize = assistQueue.size();
        for (int i = 0; i < assistSize; i++) {
            dataQueue.enqueue(assistQueue.dequeue());
        }
        return result;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return dataQueue.empty();
    }

    static class Queue<T> {
        private LinkedList<T> storage = new LinkedList<>();

        public void enqueue(T item) {
            storage.add(item);
        }

        public T dequeue() {
            return storage.removeFirst();
        }

        public boolean empty() {
            return storage.isEmpty();
        }

        public int size() {
            return storage.size();
        }
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
