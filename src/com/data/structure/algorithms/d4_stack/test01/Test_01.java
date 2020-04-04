package com.data.structure.algorithms.d4_stack.test01;


import java.util.LinkedList;

/**
 * 20. Valid Parentheses
 * https://leetcode.com/problems/valid-parentheses/
 *
 * @author wangzhichao
 * @since 2020/4/3
 */
/*

*/
public class Test_01 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Solution2 solution2 = new Solution2();
//        Example 1:
//        Input: "()"
//        Output: true
        String input1 = "()";
        System.out.println(solution.isValid(input1));
        System.out.println(solution2.isValid(input1));
//        Example 2:
//        Input: "()[]{}"
//        Output: true
        String input2 = "()[]{}";
        System.out.println(solution.isValid(input2));
//        Example 3:
//        Input: "(]"
//        Output: false
        String input3 = "(]";
        System.out.println(solution.isValid(input3));
//        Example 4:
//        Input: "([)]"
//        Output: false
        String input4 = "([)]";
        System.out.println(solution.isValid(input4));
//        Example 5:
//        Input: "{[]}"
//        Output: true
        String input5 = "{[]}";
        System.out.println(solution.isValid(input5));

    }
}


