package com.jk.solution;


public class String2Integer_8 {

    public static void test() {
        System.out.println("8 String to Integer:");
        System.out.println("int = " + myAtoi("  +093040"));
    }

    public static int myAtoi(String str) {
        if (str == null) {
            return 0;
        }

        // trim beginning
        while (!str.isEmpty()) {
            char c = str.charAt(0);
            if (c == ' ') {
                str = str.substring(1);
            } else {
                break;
            }
        }
        if (str.isEmpty()) {
            return 0;
        }

        int sign = 1;
        char cf = str.charAt(0);
        if (cf == '-' || cf == '+') {
            if (cf == '-') {
                sign = -1;
            }

            str = str.substring(1);
            if (str.isEmpty()) {
                return 0;
            }
        }

        int ret = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c >= '0' && c <= '9') {
                if (ret > Integer.MAX_VALUE / 10) { //overflow
                    if (sign > 0) {
                        return Integer.MAX_VALUE;
                    } else {
                        return Integer.MIN_VALUE;
                    }
                }
                ret *= 10;

                int val = c - 48;
                if (ret > Integer.MAX_VALUE - val) { //overflow
                    if (sign > 0) {
                        return Integer.MAX_VALUE;
                    } else {
                        return Integer.MIN_VALUE;
                    }
                }
                ret += val;
            } else {
                break;
            }
        }

        return ret * sign;
    }

}
