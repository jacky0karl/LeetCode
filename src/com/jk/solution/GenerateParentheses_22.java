package com.jk.solution;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class GenerateParentheses_22 {

    public static void test() {
        System.out.println("22 Generate Parentheses:");
        List<String> ret = generateParenthesis(4);
        System.out.println(ret);
    }

    public static List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        if (n == 1) {
            list.add("()");
            return list;
        }

        HashSet<String> set = new HashSet<>();
        List<String> l = generateParenthesis(n - 1);
        for (String s : l) {
            for (int i = 0; i < s.length(); i++) {
                Character c = s.charAt(i);
                if (c == '(') {
                    set.add(new StringBuilder(s).insert(i+1, "()").toString());
                }
            }
            set.add("()" + s);
        }

        list.addAll(set);
        return list;
    }
}
