package com.work;

import java.util.Objects;

public class SolveQuestions {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer();
        sb.append(
                "In publishing and graphic design, lorem ipsum is a filler text commonly used to demonstrate the graphic elements");
        sb.append(
                " lorem ipsum text has been used in typesetting since the 1960s or earlier, when it was popularized by advertisements");
        sb.append(
                " for Letraset transfer sheets. It was introduced to the Information Age in the mid-1980s by Aldus Corporation, which");

        String document = sb.toString();
        shortestDistance(document.split(" "), "and", "graphic");
        shortestDistance(document.split(" "), "transfer", "it");
        shortestDistance(document.split(" "), "Design", "filler");
    }

    public static int shortestDistance(String[] s, String word1, String word2) {
        int d1 = -1, d2 = -1;
        int ans = Integer.MAX_VALUE;

        // Traverse the string
        for (int i = 0; i < s.length; i++) {
            if (Objects.equals(s[i], word1))
                d1 = i;
            if (Objects.equals(s[i], word2))
                d2 = i;
            if (d1 != -1 && d2 != -1)
                ans = Math.min(ans, Math.abs(d1 - d2));
        }

        // Return the answer
        System.out.println(ans);
        return ans;
    }
}
