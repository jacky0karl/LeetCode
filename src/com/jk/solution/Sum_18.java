package com.jk.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sum_18 {

    public static void test() {
        System.out.println("18 Sum_4:");
        int[] num = new int[]{0, 0, 0, 0};
        List<List<Integer>> ret = fourSum(num, 0);
        System.out.println("ret = " + ret.toString());
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return lists;
        }

        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            if (i == 0 || (nums[i] != nums[i - 1])) {
                int target3 = target - nums[i];
                int[] dest = new int[nums.length - i - 1];
                System.arraycopy(nums, i + 1, dest, 0, nums.length - i - 1);
                List<List<Integer>> lists3 = threeSum(dest, target3);

                for (List<Integer> l : lists3) {
                    l.add(0, nums[i]);
                }
                lists.addAll(lists3);
            }
        }
        return lists;
    }

    private static List<List<Integer>> threeSum(int[] nums, int target3) {
        List<List<Integer>> lists = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return lists;
        }

        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || (nums[i] != nums[i - 1])) {
                int l = i + 1;
                int h = nums.length - 1;
                int target2 = target3 - nums[i];
                while (l < h) {
                    if (nums[l] + nums[h] > target2) {
                        h--;
                    } else if (nums[l] + nums[h] < target2) {
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
