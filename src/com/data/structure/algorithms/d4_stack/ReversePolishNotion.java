package com.data.structure.algorithms.d4_stack;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 逆波兰表达式
 *
 * @author wangzhichao
 * @since 2020/4/3
 */
public class ReversePolishNotion {
    private static final String OPERATOR_ADD = "+";
    private static final String OPERATOR_SUBSTRACT = "-";
    private static final String OPERATOR_MULTIPLY = "*";
    private static final String OPERATOR_DIVIDE = "/";
    private static final String LEFT_BRACKET = "(";
    private static final String RIGHT_BRACKET = ")";
    private static final Map<String, Integer> PRIORITY_DICT =
            new HashMap<>();

    static {
        PRIORITY_DICT.put(OPERATOR_ADD, 0);
        PRIORITY_DICT.put(OPERATOR_SUBSTRACT, 0);
        PRIORITY_DICT.put(OPERATOR_MULTIPLY, 1);
        PRIORITY_DICT.put(OPERATOR_DIVIDE, 1);
    }

    public static void main(String[] args) {
        // 操作数队列，先进先出
        Queue<String> numberQueue = new Queue<>();
        // 操作符栈，后进先出
        Stack<String> operatorStack = new Stack<>();
        // 从左至右扫描一中缀表达式
        String expression = "9 + ( 3 - 1 ) * 3 + 10 / 2";
        String[] elements = expression.split(" ");
        for (String element : elements) {
            if (isNumber(element)) {
                // 若读取的是操作数，则判断该操作数的类型，并将该操作数存入操作数堆栈
                numberQueue.offer(element);
            } else {
                // 若读取的是运算符
                if (element.equals(LEFT_BRACKET)) {
                    //  该运算符为左括号"("，则直接存入运算符堆栈
                    operatorStack.push(element);
                } else if (element.equals(RIGHT_BRACKET)) {
                    // 该运算符为右括号")"，则输出运算符堆栈中的运算符到操作数堆栈，
                    // 直到遇到左括号为止，此时抛弃该左括号。
                    while (!LEFT_BRACKET.equals(operatorStack.peek())) {
                        numberQueue.offer(operatorStack.pop());
                    }
                    operatorStack.pop();
                } else {
                    // 该运算符为非括号运算符
                    if (LEFT_BRACKET.equals(operatorStack.peek())) {
                        //  (a) 若运算符堆栈栈顶的运算符为左括号，则直接存入运算符堆栈。
                        operatorStack.push(element);
                    } else {
                        Integer currPriority = PRIORITY_DICT.get(element);
                        Integer topPriority = getStackTopPriority(operatorStack);
                        if (currPriority > topPriority) {
                            //  (b) 若比运算符堆栈栈顶的运算符优先级高，则直接存入运算符堆栈。
                            operatorStack.push(element);
                        } else {
                            //   (c) 若比运算符堆栈栈顶的运算符优先级低或相等，则输出栈顶运算符到操作数堆栈，
                            //   直至运算符栈栈顶运算符低于（不包括等于）该运算符优先级或为左括号，并将当前运算符压入运算符堆栈。
                            do {
                                numberQueue.offer(operatorStack.pop());
                            } while (!(LEFT_BRACKET.equals(operatorStack.peek()) || getStackTopPriority(operatorStack) < currPriority));
                            operatorStack.push(element);
                        }
                    }
                }
            }
        }
        // 4、当表达式读取完成后运算符堆栈中尚有运算符时，则依序取出运算符到操作数堆栈，直到运算符堆栈为空。
        while (!operatorStack.empty()) {
            numberQueue.offer(operatorStack.pop());
        }

        // 打印
        while (numberQueue.peek() != null) {
            System.out.print(numberQueue.pop() + " ");
        }
    }

    private static Integer getStackTopPriority(Stack<String> operatorStack) {
        return operatorStack.peek() == null ? -1 : PRIORITY_DICT.get(operatorStack.peek());
    }

    private static boolean isNumber(String element) {
        try {
            Integer.valueOf(element);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}

// 栈：后进先出的数据结构
class Stack<T> {
    private LinkedList<T> storage = new LinkedList<>();

    public void push(T t) {
        storage.addFirst(t);
    }

    public T peek() {
        return storage.peek();
    }

    public T pop() {
        return storage.removeFirst();
    }

    public boolean empty() {
        return storage.isEmpty();
    }
}

// 队列：先进先出的数据结构
class Queue<T> {
    private LinkedList<T> storage = new LinkedList<>();

    public void offer(T t) {
        storage.offer(t);
    }

    public T peek() {
        return storage.peek();
    }

    public T pop() {
        return storage.pop();
    }
}
