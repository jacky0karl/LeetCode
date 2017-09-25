package com.jk.solution;

import java.util.HashMap;

public class LongestSubstring_3 {

    public static void test() {
        System.out.println("2 Longest Substring:");
        int ret = lengthOfLongestSubstring("sbdvdf");
       // int ret = lengthOfLongestSubstring("xgpdwwklew");
      //   int ret = lengthOfLongestSubstring("abcabcbb");
        System.out.println(String.valueOf(ret));
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s == null) {
            return 0;
        }

        int n = s.length();
        HashMap<Character, Integer> map = new HashMap<>();
        int ret = 0, left = 0, right = 0;
        while (left < n && right < n) {
            char c = s.charAt(right);
            if (map.containsKey(c)) {
                map.remove(s.charAt(left));
                left++;
            } else {
                map.put(c, right);
                right++;
                ret = Math.max(ret, right - left);
            }
        }
        return ret;
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
