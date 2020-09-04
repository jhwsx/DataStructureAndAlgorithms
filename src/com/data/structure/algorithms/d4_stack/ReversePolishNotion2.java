package com.data.structure.algorithms.d4_stack;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class ReversePolishNotion2 {


    // 存放操作数的数据结构是一个队列
    private static class Queue<T> {
        private LinkedList<T> list = new LinkedList<>();

        // 入队
        public void enqueue(T element) {
            list.offerLast(element);
        }

        // 出队
        public T dequeue() {
            return list.pollFirst();
        }

        // 队列是否为空
        public boolean isEmpty() {
            return list.isEmpty();
        }

        // 查看队头元素
        public T peek() {
            return list.peekFirst();
        }

        public void output() {
            System.out.println(list);
        }
    }

    // 存放运算符的数据结构是一个栈
    private static class Stack<T> {
        private LinkedList<T> list = new LinkedList<>();

        // 入栈
        public void push(T element) {
            list.push(element);
        }

        // 出栈
        public T poll() {
            return list.pollFirst();
        }

        // 查看栈顶元素
        public T peek() {
            return list.peekFirst();
        }

        // 判断栈是不是为空
        public boolean isEmpty() {
            return list.isEmpty();
        }

        // 打印栈
        public void output() {
            System.out.println(list);
        }
    }

    public static void main(String[] args) {
        Queue<String> operandQueue = new Queue<>();
        Stack<String> operatorStack = new Stack<>();
        String statement = "9 + ( 3 - 1 ) * 3 + 10 / 2";
        String[] elements = statement.split(" ");
        // 1、从左至右扫描一中缀表达式。
        for (String element : elements) {
            if (isNumber(element)) {
                // 2、若读取的是操作数，则判断该操作数的类型，并将该操作数存入操作数堆栈
                operandQueue.enqueue(element);
            } else {
                // 3、若读取的是运算符
                if (ROUND_BRACKET_LEFT.equals(element)) {
                    //   (1) 该运算符为左括号"("，则直接存入运算符堆栈。
                    operatorStack.push(element);
                } else if (ROUND_BRACKET_RIGHT.equals(element)) {
                    //   (2) 该运算符为右括号")"，则输出运算符堆栈中的运算符到操作数堆栈，直到遇到左括号为止，此时抛弃该左括号。
                    while (!ROUND_BRACKET_LEFT.equals(operatorStack.peek())) {
                        String operator = operatorStack.poll();
                        operandQueue.enqueue(operator);
                    }
                    operatorStack.poll(); // 这一步就是抛弃左括号，因为有右括号，一定会有左括号在先。
                } else {
                    //  (3) 该运算符为非括号运算符
                    String stackTopOperator = operatorStack.peek();
                    if (ROUND_BRACKET_LEFT.equals(stackTopOperator)) {
                        // (a) 若运算符堆栈栈顶的运算符为左括号，则直接存入运算符堆栈。
                        operatorStack.push(element);
                    } else {
                        String stackTop = operatorStack.peek();
                        if (isOperatorPriorityHigherThanStackTop(element, stackTop)) {
                            //  (b) 若比运算符堆栈栈顶的运算符优先级高，则直接存入运算符堆栈。
                            operatorStack.push(element);
                        } else {
                            //  (c) 若比运算符堆栈栈顶的运算符优先级低或相等，则输出栈顶运算符到操作数堆栈，
                            //  直至运算符栈栈顶运算符低于（不包括等于）该运算符优先级或为左括号，并将当前运算符压入运算符堆栈。
                            stackTop = operatorStack.poll();
                            do {
                                operandQueue.enqueue(stackTop);
                                stackTop = operatorStack.poll();
                            } while (!isOperatorPriorityHigherThanStackTop(element, stackTop));
                            operatorStack.push(element);
                        }
                    }
                }
            }
        }
        // 4、当表达式读取完成后运算符堆栈中尚有运算符时，则依序取出运算符到操作数堆栈，直到运算符堆栈为空。
        while (operatorStack.peek() != null) {
            operandQueue.enqueue(operatorStack.poll());
        }
        operandQueue.output();
    }

    private static final String ROUND_BRACKET_LEFT = "(";
    private static final String ROUND_BRACKET_RIGHT = ")";
    private static final String OPERATOR_PLUS = "+";
    private static final String OPERATOR_MINUS = "-";
    private static final String OPERATOR_MULTIPLY = "*";
    private static final String OPERATOR_DIVIDE = "/";

    private static final Map<String, Integer> PRIORITY_MAP = new HashMap<>();

    static {
        PRIORITY_MAP.put(ROUND_BRACKET_LEFT, -1);
        PRIORITY_MAP.put(ROUND_BRACKET_RIGHT, -1);
        PRIORITY_MAP.put(OPERATOR_PLUS, 0);
        PRIORITY_MAP.put(OPERATOR_MINUS, 0);
        PRIORITY_MAP.put(OPERATOR_MULTIPLY, 1);
        PRIORITY_MAP.put(OPERATOR_DIVIDE, 1);
    }

    private static boolean isNumber(String element) {
        try {
            Integer.valueOf(element);
        } catch (NumberFormatException ignored) {
            return false;
        }
        return true;
    }

    private static boolean isOperatorPriorityHigherThanStackTop(String element, String stackTop) {
        if (stackTop == null) {
            return true;
        } else {
            Integer priority = PRIORITY_MAP.get(element);
            Integer stackTopPriority = PRIORITY_MAP.get(stackTop);
            return priority > stackTopPriority;
        }
    }
}
