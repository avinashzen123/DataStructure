package com.avinash.interview;

import java.util.Arrays;

public class FirstLastPosition {
    public static int[] searchRange(int[] nums, int target) {
        if (nums.length == 1) {
            if (nums[0] == target) {
                return new int[] { 0, 0 };
            } else {
                return new int[] { -1, -1 };
            }
        } else if (nums.length == 2) {
            if (nums[0] == target && nums[1] != target)
                return new int[] { 0, 0 };
            if (nums[0] != target && nums[1] == target)
                return new int[] { 1, 1 };
            else if (nums[0] == target && nums[1] == target)
                return new int[] { 0, 1 };
        }
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                int i = mid;
                int j = mid;
                while (i > 0 && nums[i - 1] == target)
                    i--;
                while (j < nums.length - 1 && nums[j + 1] == target)
                    j++;
                return new int[] { i, j };
            } else if (nums[mid] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return new int[] { -1, -1 };
    }

    public static void main(String[] args) {
        // int[] result = searchRange(new int[]{5,7,7,8,8,10}, 8);
        // System.out.println(Arrays.toString(result));

        // int[] result = searchRange(new int[]{1,2,3}, 1);
        // System.out.println(Arrays.toString(result));

        int[] result = searchRange(new int[] { 5, 7, 7, 8, 8, 10 }, 8);
        System.out.println(Arrays.toString(result));
    }
}