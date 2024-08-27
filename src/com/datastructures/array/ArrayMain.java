package com.datastructures.array;

import java.util.Arrays;

/**
 * Solving Array related LeetCode questions
 */
public class ArrayMain {
    public static void main(String[] args) {
        /*
         * Problem No: 1 (EASY)
         * runningSum
         * int[] nums = {1, 2, 3, 4};
         * Arrays.stream(runningSum(nums)).forEach(System.out::println);
         */

        /*
         * Problem No: 2 (NORMAL)
         * Minimum Value to Get Positive Step by Step Sum
         * Test Case 1: int[] nums = {-3, 2, -3, 4, 2};
         * Test Case 2: [2,3,5,-5,-1]
         * int[] nums = {1, 2, 3, 4};
         * System.out.println(minStartValue(nums));
         */

        /*
         * Problem No: 3 (HARD)
         * K Radius Subarray Averages
         * Test Case 1: int[] nums = {7, 4, 3, 9, 1, 8, 5, 2, 6};
         */
        int[] nums = {100000000, 100000000, 100000000, 100000000, 100000000, 100000000, 100000000, 100000000, 100000000, 100000000, 100000000, 100000000, 100000000, 100000000, 100000000, 100000000, 100000000, 100000000, 100000000, 100000000, 100000000, 100000000, 100000000, 100000000, 100000000, 100000000, 100000000, 100000000, 100000000, 100000000, 100000000, 100000000, 100000000, 100000000, 100000000, 100000000, 100000000, 100000000, 100000000, 100000000, 100000000, 100000000, 100000000, 100000000, 100000000, 100000000, 100000000, 100000000};
        Arrays.stream(getAverages(nums, 20)).forEach(System.out::println);
    }

    /*
     * Prefix Sum Algorithm
     * Difficulty EASY
     * https://leetcode.com/problems/running-sum-of-1d-array/description/
     *
     * nums array of integer number
     * @return array of int which includes the sum of all the elements in an array
     */
    public static int[] runningSum(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[i] + nums[i - 1];
        }
        return nums;
    }

    /*
     * Minimum Value to Get Positive Step by Step Sum
     * Difficulty NORMAL
     */
    public static int minStartValue(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        Arrays.sort(nums);
        int ans = nums[0];
        if (ans >= 1) {
            return 1;
        } else {
            return Math.abs(nums[0] - 1);
        }
        /*
         * Better Solution from LeetCode
         *         int res=0;
         *         int sum=0;
         *         for(int i:arr){
         *             sum+=i;
         *             res=Math.min(res,sum);
         *         }
         *         return 1-res;
         */
    }

    /*
     * K Radius Subarray Averages
     * Difficulty HARD
     */
    public static int[] getAverages(int[] nums, int k) {
        if (k == 0) return nums;
        if (nums.length < k || nums.length <= 2 * k) {
            int[] arr = new int[nums.length];
            Arrays.fill(arr, -1);
            return arr;
        }
        int x = 2 * k + 1;
        if (x > nums.length) {
            int[] arr = new int[nums.length];
            Arrays.fill(arr, -1);
            return arr;
        }
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i < k || (i + k) >= nums.length) {
                ans[i] = -1;
            } else {
                long value = 0;
                int left = i - k;
                int right = i + k;
                while (left <= right) {
                    value += nums[left];
                    left++;
                }
                System.out.println(value);
                ans[i] = (int)value / x;
            }
        }
        return ans;
    }
}
