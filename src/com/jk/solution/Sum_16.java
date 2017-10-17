package com.jk.solution;

import java.util.Arrays;

public class Sum_16 {

    public static void test() {
        System.out.println("16 Sum Closest:");
        int[] num = new int[]{0, 0, 0};
        int ret = threeSumClosest(num, 1);
        System.out.println("ret = " + ret);
    }

    public static int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return -1;
        }

        Arrays.sort(nums);
        int g_diff = Integer.MAX_VALUE;
        int ans = -1;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || (nums[i] != nums[i - 1])) {
                int l = i + 1;
                int h = nums.length - 1;
                int target2 = target - nums[i];
                while (l < h) {
                    int diff = nums[l] + nums[h] - target2;
                    if (g_diff  >  Math.abs(diff)) {
                        g_diff = Math.abs(diff);
                        ans = nums[l] + nums[h] + nums[i];
                    }

                    if (diff > 0) {
                        h--;
                    } else if (diff < 0) {
                        l++;
                    } else {
                        return target;
                    }
                }
            }
        }
        return ans;
    }


}
