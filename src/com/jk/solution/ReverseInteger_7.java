package com.jk.solution;

public class ReverseInteger_7 {

    public static void test() {
        System.out.println("7 ReverseInteger:");
        System.out.println(ReverseInteger_7.reverse(153426));
    }

    public static int reverse(int x) {
        int left = x;
        int ret = 0;
        while (left != 0) {
            if (Math.abs(ret) > Integer.MAX_VALUE / 10) { //overflow
                return 0;
            }
            ret *= 10;

            int remainder = left % 10;

            if (ret > 0 && ret > Integer.MAX_VALUE - remainder
                    || ret < 0 && ret < Integer.MIN_VALUE - remainder) { //overflow
                return 0;
            }
            ret += remainder;

            left = left / 10;
        }

        return ret;
    }
}
