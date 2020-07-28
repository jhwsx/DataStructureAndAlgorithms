package com.data.structure.algorithms.programmerxiaohui.chapter2.part3;

import com.data.structure.algorithms.programmerxiaohui.chapter2.part2.MyLinkedList;

/**
 * 栈的链表实现
 *
 * @author wangzhichao
 * @date 7/28/20
 */
public class MyLinkedListStack {
    private MyLinkedList linkedList;
    /**
     * 栈容量
     */
    private int stackSize;

    public MyLinkedListStack(int stackSize) {
        this.stackSize = stackSize;
        linkedList = new MyLinkedList();
    }
    /**
     * 入栈操作
     * @param data
     */
    public void push(int data) throws Exception {
        if (linkedList.getSize() + 1 > stackSize) {
            throw new IllegalStateException("栈已经满了");
        }
        linkedList.insert(linkedList.getSize(), data);
    }

    /**
     * 出栈操作
     * @return
     */
    public int pop() throws Exception {
        if (linkedList.isEmpty()) {
            throw new IllegalStateException("栈已经空了");
        }
        return linkedList.delete(linkedList.getSize() - 1);
    }

    public void output() {
        linkedList.output();
    }

    public static void main(String[] args) throws Exception {
        MyLinkedListStack stack = new MyLinkedListStack(5);
        System.out.println("入栈操作：");
        stack.push(1);
        stack.output();
        stack.push(2);
        stack.output();
        stack.push(4);
        stack.output();
        stack.push(5);
        stack.output();
        stack.push(6);
        stack.output();
        try {
            stack.push(8);
            stack.output();
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("出栈操作：");
        System.out.println(stack.pop() + " 出栈");
        stack.output();
        System.out.println(stack.pop() + " 出栈");
        stack.output();
        System.out.println(stack.pop() + " 出栈");
        stack.output();
        System.out.println(stack.pop() + " 出栈");
        stack.output();
        System.out.println(stack.pop() + " 出栈");
        stack.output();
        try {
            System.out.println(stack.pop() + " 出栈");
            stack.output();
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
