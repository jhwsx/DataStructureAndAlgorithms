package com.data.structure.algorithms.d4_stack.test01;

import java.util.LinkedList;

/**
 * @author wangzhichao
 * @since 2020/4/4
 */
public class Solution2 {
    public boolean isValid(String s) {
        Stack stack = new Stack();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '{') {
                stack.push('}');
            } else if (stack.empty() || c != stack.pop()) {
                return false;
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
