package indi.latch.algorithm.leet;

import java.util.Objects;

/**
 * Title: MaxMinDemo
 * Description:
 * Copyright: 数禾科技 Copyright(c) 2023/3/5
 * Encoding: UNIX UTF-8
 *
 * @author 徐林
 */
public class MaxMinDemo {

    public static void main(String[] args) {
        int[] nums = new int[]{10, 8, 6, 5, 2, 4, 1, 3, 9, 7};

        MaxMinDemo maxMinDemo = new MaxMinDemo();
        System.out.println(maxMinDemo.findMinMax(nums));
    }

    private String findMinMax(int[] nums) {
        if (Objects.isNull(nums) || nums.length == 0) {
            return "-1";
        }

        int minValue = nums[0];
        int maxValue = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < minValue) {
                minValue = nums[i];
                continue;
            }

            if (nums[i] > maxValue) {
                maxValue = nums[i];
            }
        }

        return minValue + "_" + maxValue;
    }
}