package com.data.structure.algorithms.programmerxiaohui.chapter2.part3;

import com.data.structure.algorithms.programmerxiaohui.chapter2.part1.MyArray;

/**
 * 栈的数组实现
 * @author wangzhichao
 * @date 7/28/20
 */
public class MyArrayStack {

    private MyArray array;
    private int stackSize;

    public MyArrayStack(int stackSize) {
        this.stackSize = stackSize;
        array = new MyArray(stackSize);
    }
    /**
     * 入栈操作
     * @param data
     */
    public void push(int data) throws Exception {
        if (array.getSize() + 1 > stackSize) {
            throw new IllegalStateException("栈已经满了");
        }
        array.insert(data, array.getSize());
    }

    /**
     * 出栈操作
     * @return
     */
    public int pop() throws Exception {
        if (array.isEmpty()) {
            throw new IllegalStateException("栈已经空了");
        }
        return array.delete(array.getSize() - 1);
    }

    public void output() {
        array.print();
    }

    public static void main(String[] args) throws Exception {
        MyArrayStack myArrayStack = new MyArrayStack(5);
        System.out.println("入栈操作：");
        myArrayStack.push(1);
        myArrayStack.output();
        myArrayStack.push(2);
        myArrayStack.output();
        myArrayStack.push(4);
        myArrayStack.output();
        myArrayStack.push(5);
        myArrayStack.output();
        myArrayStack.push(6);
        myArrayStack.output();
        try {
            myArrayStack.push(8);
            myArrayStack.output();
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("出栈操作：");
        System.out.println(myArrayStack.pop() + " 出栈");
        myArrayStack.output();
        System.out.println(myArrayStack.pop() + " 出栈");
        myArrayStack.output();
        System.out.println(myArrayStack.pop() + " 出栈");
        myArrayStack.output();
        System.out.println(myArrayStack.pop() + " 出栈");
        myArrayStack.output();
        System.out.println(myArrayStack.pop() + " 出栈");
        myArrayStack.output();
        try {
            System.out.println(myArrayStack.pop() + " 出栈");
            myArrayStack.output();
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
