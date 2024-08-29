package com.datastructures.hashing;

import java.util.HashSet;
import java.util.Set;

public class HashingMain {
    public static void main(String[] args) {
        int[] arr = {1, 8, 1, 6, 3, 3, 5, 5, 7, 7};
        System.out.println(countElements(arr));
    }

    /**
     * Check if the Sentence Is Pangram
     * Input: sentence = "leetcode"
     * Output: false
     * <p>
     * Input: sentence = "thequickbrownfoxjumpsoverthelazydog"
     * Output: true
     */
    public static boolean checkIfPangram(String sentence) {
        if (sentence.length() < 26) return false;
        Set<Character> chars = new HashSet<>();
        for (int i = 0; i < sentence.length(); i++) {
            chars.add(sentence.charAt(i));
        }
        return chars.size() == 26;
    }

    /**
     * Counting Elements
     * Input: arr = [1,2,3]
     * Output: 2
     * Explanation: 1 and 2 are counted cause 2 and 3 are in arr.
     *
     * @param arr input array
     * @return element count
     */
    public static int countElements(int[] arr) {
        int count = 0;
        Set<Integer> nums = new HashSet<>();
        for (int val : arr) {
            nums.add(val);
        }
        for (int j : arr) {
            if (nums.contains(j + 1)) {
                count++;
            }
        }
        return count;
    }
}
