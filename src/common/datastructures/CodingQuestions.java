package common.datastructures;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CodingQuestions {
    public static void main(String[] args) {
//        System.out.println(squareRoot(2));
        System.out.println(minimalSteps("ABCDABCE"));
        System.out.println(minimalSteps("ABCABCE"));
        Set<String> aaa = new TreeSet<>();
        aaa.add(null);
        aaa.add(null);
        aaa.forEach(System.out::println);
    }


    // Calculating Square Root using Binary search
    public static double squareRoot(int number) {
        double start = 0;
        double mid = 0;
        double end = number;
        double precision = 0.005;
        int count = 0;

        while ((end - start) > precision) {
            mid = (start + end) / 2;
            if (mid * mid > number) {
                end = mid;
            } else {
                start = mid;
            }
            count++;
        }
        System.out.println(count);
        return mid;
    }

    /*
     * Implement a run length encoding function.
     * For a string input the function returns output encoded as follows:
     *
     * "a"     -> "a1"
     * "aa"    -> "a2"
     * "aabbb" -> "a2b3"
     */
    public static void rle(String input) {
        StringBuilder sb = new StringBuilder();
        char start = input.charAt(0);
        int charCount = 1;
        for (int i = 1; i < input.length(); i++) {
            if (start == input.charAt(i)) {
                charCount++;
            } else {
                sb.append(start).append(charCount);
                start = input.charAt(i);
                charCount = 1;
            }
        }
        sb.append(start).append(charCount);
        System.out.println(sb);
    }

    /**
     * Finds the first character that does not repeat anywhere in the input string
     * Given "apple", the answer is "a"
     * Given "racecars", the answer is "e"
     **/
    public static char findFirst(String input) {
        Map<Character, Long> countChars =
                input.chars().mapToObj(c -> (char) c).collect(Collectors.toMap(
                        Function.identity(),
                        c -> 1L,
                        Long::sum,
                        LinkedHashMap::new
                ));
        char c = countChars.entrySet().stream().filter(o -> o.getValue() == 1).findFirst().get().getKey();
        System.out.println(c);
        return ('a');
    }

    public static int pascal(int col, int row) {
        if (col < 0 || row < 0 || col > row) {
            throw new IllegalArgumentException("Invalid position");
        }
        return factorial(row) / (factorial(col) * factorial(row - col));
    }

    private static int factorial(int n) {
        int result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static String reverseStr(String str) {
        int left = 0;
        int right = str.length() - 1;
        char[] reverse = str.toCharArray();
        while (left <= right) {
            char temp = reverse[left];
            reverse[left] = reverse[right];
            reverse[right] = temp;
            left++;
            right--;
        }
        return Arrays.toString(reverse);
    }

    /**
     * You have an integer array.
     * Starting from arr[startIndex], follow each element to the index it points to.
     * Continue to do this until you find a cycle.
     * Return the length of the cycle. If no cycle is found return -1
     * <p>
     * System.out.println(countLengthOfCycle(new int[]{1, 0}, 0));
     * System.out.println(countLengthOfCycle(new int[]{1, 2, 0}, 0));
     * System.out.println(countLengthOfCycle(new int[]{1, 3, 3, 1}, 0));
     */
    public static int countLengthOfCycle(int[] arr, int startIndex) {
        Set<Integer> integerSet = new HashSet<>();
        int count = 0;
        for (int i = startIndex; i < arr.length; i++) {
            if (integerSet.add(arr[i])) {
                count++;
            } else {
                return count;
            }
            if (i == arr.length - 1) {
                if (integerSet.contains(arr[i])) { //1,0 -> index = 0
                    return count;
                }
            }
        }

        return -1;
    }

    /**
     * Returns true if x is a power-of-10.
     * Test Cases
     * System.out.println(isPowerOf10(50));
     * System.out.println(isPowerOf10(3));
     * System.out.println(isPowerOf10(0));
     * System.out.println(isPowerOf10(1000000));
     * System.out.println(isPowerOf10(1));
     */
    public static boolean isPowerOf10(int x) {
        if (x <= 0) return false;
        while (x % 10 == 0) {
            x /= 10;
        }
        return x == 1;
    }

    /**
     * Given two arrays of integers, returns the dot product of the arrays
     */
    public static int dotProduct(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) {
            throw new IllegalArgumentException("Arrays must have the same length.");
        }

        int dotProduct = 0;
        for (int i = 0; i < arr1.length; i++) {
            dotProduct += arr1[i] * arr2[i];
        }

        return dotProduct;
    }

    /**
     * Question:
     * Combine ingredients in a specific order, any of which may be repeated
     * <p>
     * As an example, consider the following
     * (A,B,C,D) in 11 steps: A, B, A, B, C, A, B, A, B, C, E
     * <p>
     * Encode the string above using only 6 characters: A,B,*,C,*,E
     * <p>
     * Implement function that takes as input an un-encoded potion and returns the
     * minimum number of characters required to encode
     */
    static Integer minimalSteps(String ingredients) {
        int[] dp = new int[ingredients.length()];
        dp[0] = 1;
        for (int i = 1; i < ingredients.length(); i++) {
            if ((i + 1) % 2 == 0) {
                if (ingredients.substring(0, i / 2 + 1).equals(ingredients.substring(i / 2 + 1, i + 1))) {
                    dp[i] = Math.min(dp[i / 2], dp[i - 1]) + 1;
                } else {
                    dp[i] = dp[i - 1] + 1;
                }
            } else {
                dp[i] = dp[i - 1] + 1;
            }
        }
        return dp[dp.length - 1];
    }
}
