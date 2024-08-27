package com.datastructures.array.twopointers;

public class TwoPointers {
    public static void main(String[] args) {
//        String s = "Let's take LeetCode contest";
        String s = "contest";
        System.out.println(reverseWords(s));
    }

    public static String reverseWords(String s) {
        int left = 0;
        int right = 0;
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ' || i == s.length() - 1) {
                while (right >= left && right > 0) {
                    if (s.charAt(right - 1) != ' ') {
                        ans.append(s.charAt(right - 1));
                    }
                    right--;
                }
                if (i != s.length() - 1) {
                    ans.append(s.charAt(i));
                }
                left = i + 1;
                right = i + 1;
            }
            right++;
        }
        return ans.toString();
    }
}
