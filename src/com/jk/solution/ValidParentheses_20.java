package com.jk.solution;

import java.util.Stack;

public class ValidParentheses_20 {

    public static void test() {
        System.out.println("20 ValidParentheses:");
        System.out.println(isValid("([s]dd{[})"));
    }

    public static boolean isValid(String s) {
        if (s == null)
            return false;

        if (s.length() == 0)
            return true;

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '{' || c == '[' || c == '(') {
                stack.push(c);
            } else if (c == '}' || c == ']' || c == ')') {
                if (stack.isEmpty()) {
                    return false;
                }

                if (c == '}') {
                    if (stack.pop() != '{') {
                        return false;
                    }
                } else if (c == ']') {
                    if (stack.pop() != '[') {
                        return false;
                    }
                } else if (c == ')') {
                    if (stack.pop() != '(') {
                        return false;
                    }
                }
            }
        }

        return stack.isEmpty();
    }
}
