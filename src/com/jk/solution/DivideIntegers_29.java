package com.jk.solution;

public class DivideIntegers_29 {

    public static void test() {
        System.out.println("29 Divide Integers:");
        System.out.println("result = " + divide(2147483647, 727665511));
    }

    public static int divide(int dividend, int divisor) {
        //Reduce the problem to positive long integer to make it easier.
        //Use long to avoid integer overflow cases.
        int sign = 1;
        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0))
            sign = -1;
        long ldividend = Math.abs((long) dividend);
        long ldivisor = Math.abs((long) divisor);

        //Take care the edge cases.
        if (ldivisor == 0) return Integer.MAX_VALUE;
        if ((ldividend == 0) || (ldividend < ldivisor)) return 0;

        long lans = ldivide1(ldividend, ldivisor);

        int ans;
        if (lans > Integer.MAX_VALUE) { //Handle overflow.
            ans = (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        } else {
            ans = (int) (sign * lans);
        }
        return ans;
    }

    private static long ldivide(long ldividend, long ldivisor) {
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

    private static long multiply(long target, long multiplier) {
        long result = 0;
        for (; multiplier > 0; multiplier--) {
            result += target;
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
