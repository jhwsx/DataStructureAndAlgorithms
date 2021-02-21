package com.data.structure.algorithms;

public class Test {
    public static void main(String[] args) {
        int length = 10;
        for (int i = 0; i < 100; i++) {
            System.out.println("i & (length- 1) = " + (i & (length - 1)));
        }
    }
}
