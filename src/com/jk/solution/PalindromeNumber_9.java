package com.jk.solution;


public class PalindromeNumber_9 {

    public static void test() {
        System.out.println("9 Palindro meNumber:");
        System.out.println(isPalindrome(2145412));
    }

    public static boolean isPalindrome(int x) {
        if (x < 0)
            return false;

        int revert = 0, tmp = x;
        while (tmp > 0) {
            int tail = tmp % 10;
            revert = revert * 10 + tail;
            tmp /= 10;
        }

        return revert == x;
    }

}
