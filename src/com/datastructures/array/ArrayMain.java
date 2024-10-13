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
//        int[] nums = {100000000, 100000000, 100000000, 100000000, 100000000, 100000000, 100000000, 100000000, 100000000, 100000000, 100000000, 100000000, 100000000, 100000000, 100000000, 100000000, 100000000, 100000000, 100000000, 100000000, 100000000, 100000000, 100000000, 100000000, 100000000, 100000000, 100000000, 100000000, 100000000, 100000000, 100000000, 100000000, 100000000, 100000000, 100000000, 100000000, 100000000, 100000000, 100000000, 100000000, 100000000, 100000000, 100000000, 100000000, 100000000, 100000000, 100000000, 100000000};
//        Arrays.stream(getAverages(nums, 20)).forEach(System.out::println);

        /*
         * Reversing an Array
         */
        int[] nums = {7, 4, 3, 9, 1, 8, 5, 2, 6};
        Arrays.stream(reverseArray(nums)).forEach(System.out::println);
    }


    /*
     * Reversing an Array
     */
    private static int[] reverseArray(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
        return nums;
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
                ans[i] = (int) value / x;
            }
        }
        return ans;
    }

    /**
     * Searching the target number in nums array with lesser complexity due to n/2
     * <p>
     * BINARY SEARCH
     *
     * @param nums   array of integers
     * @param target find the provided value
     * @return integer position
     */
    public static int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            System.out.println(mid);
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    /**
     * find repeating number in an array
     * Three approaches which are easy to implement:
     * 1. Set -> add -> bool -> false? -> print
     * 2. Map -> put -> getOrDefault -> (get, 0) +1, print map if value > 1
     * 3. int a -> int b + 1 index, now keep the count of each element of a in next index of b => B[A[i]]++;
     */
    public static void findRepeatingElementInArray() {
        int A[] = {1, 6, 4, 6, 4, 8, 2, 4, 1, 1};

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {
            if (A[i] > max)
                max = A[i];
        }

        int B[] = new int[max + 1]; // Here initializing B's index with Max element in A i.e A's max = 200, B.length -> 200

        for (int i = 0; i < A.length; i++) {
            // increment in array B for every integer in A.
            B[A[i]]++;
        }
        for (int i = 0; i <= max; i++) {
            // output only if element is more than 1 time in array A.
            if (B[i] > 1)
                System.out.println(i + "-" + B[i]);
        }
    }
}
