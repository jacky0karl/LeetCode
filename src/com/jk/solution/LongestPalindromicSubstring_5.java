package com.jk.solution;

public class LongestPalindromicSubstring_5 {

    public static void test() {
        System.out.println("5 Longest Palindromic Substring:");
        long t0 = System.currentTimeMillis();
        longestPalindrome1("zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz");
        long t1 = System.currentTimeMillis();
        System.out.println("time: " + String.valueOf(t1 - t0));
    }

    static int scount = 0;

    public static String longestPalindrome(String s) {
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        System.out.println("scount:" + scount);
        return s.substring(start, end + 1);
    }

    private static int expandAroundCenter(String s, int left, int right) {

        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            scount++;
            L--;
            R++;
        }
        return R - L - 1;
    }

    public static String longestPalindrome1(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }
        if (s.length() <= 1) {
            return s;
        }

        String ret = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; i - j >= 0 && i + j < s.length(); j++) {
                if (s.charAt(i - j) == s.charAt(i + j)) {
                    if ((j * 2 + 1) > ret.length()) {
                        ret = s.substring(i - j, i + j + 1);
                        if (s.length() == ret.length()) {
                            return ret;
                        }
                    }
                } else {
                    break;
                }
            }
        }

        for (int i = 0; i < s.length() - 1; i++) {
            String seed = s.substring(i, i + 2);
            if (seed.charAt(0) == seed.charAt(1)) {
                if (seed.length() > ret.length()) {
                    ret = seed;
                }
            } else {
                continue;
            }

            for (int j = 0; i - j >= 0 && i + j < s.length() - 1; j++) {
                if (s.charAt(i - j) == s.charAt(i + j + 1)) {
                    if ((j * 2 + 2) > ret.length()) {
                        ret = s.substring(i - j, i + j + 2);

                        if (s.length() == ret.length()) {
                            return ret;
                        }
                    }
                } else {
                    break;
                }
            }
        }

        return ret;
    }
}
