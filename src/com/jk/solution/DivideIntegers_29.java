package com.jk.solution;

public class DivideIntegers_29 {

    public static void test() {
        System.out.println("29 Divide Integers:");
        // System.out.println("result = " + divide(Integer.MAX_VALUE, 3));
        System.out.println("multiply result = " + multiply(4, 88));
    }

    private static long multiply(long target, long multiplier) {
        if (multiplier <= 0) {
            return 0;
        }

        long sum = 0;
        long ret = 0;
        long multiplied = 0;
        while (multiplied < multiplier) {
            ret++;
            multiplied = (1L << ret);
            sum = target << ret;
        }

        sum >>= 1;
        ret--;
        multiplied = (1L << ret);
        return sum + multiply(target, multiplier - multiplied);
    }

    public static int divide(int dividend, int divisor) {
        int sign = 1;
        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0))
            sign = -1;

        long ldividend = Math.abs((long) dividend);
        long ldivisor = Math.abs((long) divisor);

        if (ldivisor == 0)
            return Integer.MAX_VALUE;
        if ((ldividend == 0) || (ldividend < ldivisor))
            return 0;

        long lret = ldivide(ldividend, ldivisor);
        int ret;
        if (lret > Integer.MAX_VALUE) {
            ret = (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        } else {
            ret = (int) (sign * lret);
        }
        return ret;
    }

    private static int count = 0;
    private static long ldivide(long ldividend, long ldivisor) {
        count++;
        if (ldividend < ldivisor) {
            System.out.println(" count = " + count);
            return 0;
        }

        long sum = 0;
        long ret = 0;
        while (sum < ldividend) {
            ret++;
            sum = ldivisor << ret;
        }

        sum >>= 1;
        ret--;
        return (1L << ret) + ldivide(ldividend - sum, ldivisor);
    }

    private static long ldivide0(long ldividend, long ldivisor) {
        // Recursion exit condition
        if (ldividend < ldivisor) return 0;

        //  Find the largest multiple so that (divisor * multiple <= dividend),
        //  whereas we are moving with stride 1, 2, 4, 8, 16...2^n for performance reason.
        //  Think this as a binary search.
        long sum = ldivisor;
        long multiple = 1;
        while ((sum + sum) <= ldividend) {
            sum += sum;
            multiple += multiple;
        }
        //Look for additional value for the multiple from the reminder (dividend - sum) recursively.
        return multiple + ldivide(ldividend - sum, ldivisor);
    }

    public static long ldivide1(long dividend, long divisor) {
        int overrun = 0;
        long result = 0;
        long minDiff = Integer.MAX_VALUE;
        long ret = dividend >> 1;
        long min = 0, max = dividend;
        long step;
        while (min < max) {
            if (overrun > 1) {
                break;
            }

            long diff = multiply(ret, divisor) - dividend;
            if (Math.abs(diff) < minDiff && diff < 0) {
                minDiff = Math.abs(diff);
                result = ret;
            }

            if (diff == 0) {
                return ret;
            } else if (diff > 0) {
                max = ret;
                step = (max - min) >> 1;
                if (step < 1) {
                    overrun++;
                    step = 1;
                }
                ret -= step;
            } else {
                min = ret;
                step = (max - min) >> 1;
                if (step < 1) {
                    overrun++;
                    step = 1;
                }
                ret += step;
            }

        }

        return result;
    }

    public static long ldivide2(long dividend, long divisor) {
        if (divisor == 0) {
            return 0;
        }
        if (divisor > dividend) {
            return 0;
        }
        if (divisor == dividend) {
            return 1;
        }

        int run = 0;
        int overrun = 0;

        long result = 0;
        long minDiff = Long.MAX_VALUE;
        long ret = dividend >> 1;
        long min = 0, max = dividend;
        long step;
        while (min < max) {
            run++;
            if (overrun > 3) {
                break;
            }

            long diff = ret * divisor - dividend;
            System.out.println("diff = " + diff);
            if (Math.abs(diff) < minDiff && diff < 0) {
                minDiff = Math.abs(diff);
                result = ret;

                System.out.println(" ----- ");
                System.out.println("minDiff = " + minDiff);
                System.out.println("result = " + result);
            }

            if (diff == 0) {
                return ret;
            } else if (diff > 0) {
                System.out.println(" -- diff > 0");
                System.out.println(" ret = " + ret);

                max = ret;
                step = (max - min) >> 1;
                if (step < 1) {
                    overrun++;
                    step = 1;
                }
                ret -= step;

                System.out.println("step = " + step);
                System.out.println("after ret = " + ret);
                System.out.println("min = " + min);
                System.out.println("max = " + max);

            } else {
                System.out.println(" -- diff < 0");
                System.out.println(" ret = " + ret);

                min = ret;
                step = (max - min) >> 1;
                if (step < 1) {
                    overrun++;
                    step = 1;
                }
                ret += step;

                System.out.println("step = " + step);
                System.out.println("after ret = " + ret);
                System.out.println("min = " + min);
                System.out.println("max = " + max);
            }

        }

        System.out.println("run = " + run);
        System.out.println("overrun = " + overrun);
        return result;
    }
}
