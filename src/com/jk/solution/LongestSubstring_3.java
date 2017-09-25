package com.jk.solution;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstring_3 {

    public static void test() {
        System.out.println("2 Longest Substring:");
        int ret = lengthOfLongestSubstring("abba");
        //   int ret = lengthOfLongestSubstring("pwwkew");
        //  int ret = lengthOfLongestSubstring("abcabcbb");
        System.out.println(String.valueOf(ret));
    }

    // O(n)
    public static int lengthOfLongestSubstring(String s) {
        int ret = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int j = 0, i = 0; j < s.length(); j++) {
            char c = s.charAt(j);
            if (map.containsKey(c)) {
                i = Math.max(map.get(c) + 1, i);
            }
            ret = Math.max(ret, j - i + 1);
            map.put(c, j);
        }
        return ret;
    }

    // O(2n)
    public static int lengthOfLongestSubstring1(String s) {
        if (s == null) {
            return 0;
        }

        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }

    public static int lengthOfLongestSubstring2(String s) {
        if (s == null) {
            return 0;
        }

        int ret = 0;
        StringBuilder sub = new StringBuilder();
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                ret = Math.max(ret, sub.length());
                i = map.get(c);
                sub = new StringBuilder();
                map.clear();
            } else {
                sub.append(c);
                map.put(c, i);
            }
        }

        ret = Math.max(ret, sub.length());
        return ret;
    }
}
