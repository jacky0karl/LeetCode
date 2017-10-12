package com.jk.solution;

public class ContainerWithMostWater_11 {

    public static void test() {
        System.out.println("2 Longest Substring:");
        int[] height = new int[]{44, 33, 1, 1, 1};
        int ret = maxArea(height);
        System.out.println(String.valueOf(ret));
    }


    public static int maxArea(int[] height) {
        if (height == null || height.length < 2) {
            return 0;
        }

        int max = 0;
        for (int i = 0, j = height.length - 1; i < j; ) {
            int area = (j - i) * Math.min(height[i], height[j]);
            max = Math.max(max, area);

            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }

        return max;
    }


}
