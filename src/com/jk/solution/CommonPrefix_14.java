package com.jk.solution;

import java.util.stream.StreamSupport;

public class CommonPrefix_14 {

    public static void test14() {
        System.out.println("14 Longest Common Prefix:");
        String[] strs = new String[]{"ads", "abd", "abcg"};
        System.out.println(longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length < 1) {
            return "";
        }

        String target = strs[0];
        if (target.length() < 1) {
            return "";
        }

        for (int i = 1; i <= target.length(); i++) {
            String t = target.substring(0, i);
            for (String str : strs) {
                if (!str.startsWith(t)) {
                    return target.substring(0, i - 1);
                }
            }
        }
        return target;
    }
}
