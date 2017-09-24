package com.jk.solution;

import java.util.Arrays;
import java.util.HashMap;

public class Sum_1 {

    public static void test() {
        System.out.println("2 Sum:");
        int[] num = new int[]{11, 2, 7, 15};
        int[] ret = twoSum(num, 26);
        System.out.println("ret = " + Arrays.toString(ret));
    }

    public static int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            if (map.containsKey(target - nums[i])) {
                int[] ret = new int[2];
                ret[0] = map.get(target - nums[i]);
                ret[1] = i;
                return ret;
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
