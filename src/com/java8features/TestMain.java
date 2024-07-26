package com.java8features;

public class TestMain {
    public static void main(String[] args) {
        int[] nums = {2, 4, 5, 6, 8, 11, 20};
        System.out.println(searchInsert(nums, 5));
    }

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
}
