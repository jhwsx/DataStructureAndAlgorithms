package com.data.structure.algorithms.d4_stack.test01;

import java.util.LinkedList;
/*
思路：
遍历字符串的每个字符，如果字符是左半边的括号（即 (、[ 或者{），将字符压入栈；
如果字符是右半边括号（即 )、] 或者 }），此时首先判断堆栈是否为空，如果栈为空，
则该字符无法找到匹配的括号，返回 false，如果栈不为空，则弹出栈顶元素并与之比较，
如果两个字符不相同，同样返回 false。最后，遍历完整个字符串后，还需要判断堆栈是
否为空，如果为空，则是有效的括号，反之则为无效的括号。
 */
class Solution {
    private static final char LEFT_ROUND_BRACKET = '(';
    private static final char RIGHT_ROUND_BRACKET = ')';
    private static final char LEFT_SQUARE_BRACKET = '[';
    private static final char RIGHT_SQUARE_BRACKET = ']';
    private static final char LEFT_CURLY_BRACKET = '{';
    private static final char RIGHT_CURLY_BRACKET = '}';

    public boolean isValid(String s) {
        String temp = s;
        char[] charArray = temp.toCharArray();
        Stack stack = new Stack();
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            if (c == LEFT_ROUND_BRACKET
                    || c == LEFT_SQUARE_BRACKET
                    || c == LEFT_CURLY_BRACKET) {
                stack.push(c);
            } else {
                if (stack.empty()) {
                    return false;
                } else {
                    char pop = stack.pop();
                    if (!(c == RIGHT_ROUND_BRACKET && pop == LEFT_ROUND_BRACKET
                            || c == RIGHT_SQUARE_BRACKET && pop == LEFT_SQUARE_BRACKET
                            || c == RIGHT_CURLY_BRACKET && pop == LEFT_CURLY_BRACKET)) {
                        return false;
                    }
                }
            }
        }
        return stack.empty();
    }

    class Stack {
        private LinkedList<Character> storage = new LinkedList<>();

        public void push(Character c) {
            storage.addFirst(c);
        }

        public Character peek() {
            return storage.getFirst();
        }

        public Character pop() {
            return storage.removeFirst();
        }

        public boolean empty() {
            return storage.isEmpty();
        }
    }
}
