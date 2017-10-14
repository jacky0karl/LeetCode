package com.jk.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sum_15 {

    public static void test() {
        System.out.println("15 Sum_3:");
        int[] num = new int[]{-4, -2, -2, -2, 0, 1, 2, 2, 2, 3, 3, 4, 4, 6, 6};
        List<List<Integer>> ret = threeSum(num);
        System.out.println("ret = " + ret.toString());
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return lists;
        }

        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || (nums[i] != nums[i - 1])) {
                int l = i + 1;
                int h = nums.length - 1;
                int target = 0 - nums[i];
                while (l < h) {
                    if (nums[l] + nums[h] > target) {
                        h--;
                    } else if (nums[l] + nums[h] < target) {
                        l++;
                    } else {
                        List<Integer> ret = new ArrayList<>();
                        ret.add(nums[i]);
                        ret.add(nums[l]);
                        ret.add(nums[h]);
                        lists.add(ret);

                        while (l < h && nums[l] == nums[l + 1]) l++;
                        l++;

                        while (l < h && nums[h] == nums[h - 1]) h--;
                        h--;
                    }
                }
            }
        }
        return lists;
    }


}
