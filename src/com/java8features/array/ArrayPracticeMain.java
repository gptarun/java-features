package com.java8features.array;

import java.util.LinkedHashMap;
import java.util.Map;

public class ArrayPracticeMain {
    public static void main(String[] args) {
        String s = "energy";
//        nonRepeating(s);
        String s1 = "enemy";
//        uncommonCharacter(s, s1);

        int[] nums = {1, 2, 2, 3, 44, 44};
//        removeDuplicate(nums);

        reverseString("testing");
    }

    public static void reverseString(String input) {
        // Reverse the string
        int left = 0;
        int right = input.length() - 1;
        char[] noSpaces = input.toCharArray();
        while (left < right) {
            char temp = noSpaces[left];
            noSpaces[left] = noSpaces[right];
            noSpaces[right] = temp;
            left++;
            right--;
        }
        for (char i : noSpaces) {
            System.out.println(i);
        }
    }

    private static void uncommonCharacter(String s, String s1) {
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (char c : s1.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                System.out.println(entry.getKey());
            }
        }
    }

    private static void nonRepeating(String s) {
        char[] input = s.toCharArray();
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (char c : input) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                System.out.println(entry.getKey());
            }
        }
    }

    private static void removeDuplicate(int[] nums) {
        Map<Integer, Integer> map = new LinkedHashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        map.entrySet().stream().filter(obj -> obj.getValue() == 1).forEach(obj -> System.out.println(obj.getKey()));
    }
}
