package common.datastructures.gsprep;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PracticeQuestions {
    //done but not coded:
    // Find smallest, find 2nd smallest(sort or find smallest then 2nd smallest)
    public static void main(String[] args) {
        int[] arr = {900, 940, 950, 1100, 1500, 1800};
        int[] dep = {910, 1200, 1120, 1130, 1900, 2000};
        int[] nums = {73, 74, 75, 71, 69, 72, 76, 73};
//        System.out.println(longestUniqueCharacters("abcbdamop"));
        topThreeVideos();
    }

    /**
     * Input: arr[] = {9:00, 9:40, 9:50, 11:00, 15:00, 18:00},
     * dep[] = {9:10, 12:00, 11:20, 11:30, 19:00, 20:00}
     */
    public static void findPlatform(int[] arr, int[] dep, int length) {
        Arrays.sort(arr);
        int platformRequired = 1;
        int result = 1;
        int arrCounter = 1;
        int depCounter = 0;

        while (arrCounter < length && depCounter < length) {
            if (arr[arrCounter] <= dep[depCounter]) {
                platformRequired++;
                arrCounter++;
            } else if (arr[arrCounter] > dep[depCounter]) {
                platformRequired--;
                depCounter++;
            }

            if (platformRequired > result) {
                result = platformRequired;
            }
        }
        System.out.println(result);
    }

    public static int whoIsElectedRecursion(int n, int k) {
        int ans = 0;
        int index = 0;
        k--;
        List<Integer> students = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            students.add(i);
        }
        eliminateStudent(students, k, index);
        // Return required answer
        return ans + 1;

    }

    private static void eliminateStudent(List<Integer> students, int k, int index) {
        if (students.size() == 1) {
            System.out.println(students.getFirst() + 1);
            return;
        }
        index = (index + k) % students.size();
        students.remove(index);
        eliminateStudent(students, k, index);
    }

    public static int whoIsElected(int n, int k) {
        int i = 1, ans = 0;
        while (i <= n) {
            ans = (ans + k) % i;
            i++;
        }
        return ans + 1;
    }

    // aabbbcca
    static int[] longestUniformSubstring(String input) {
        int longestStart = 0;
        int longestLength = 1;
        int maxLength = 1;
        char currentChar = input.charAt(0);
        for (int i = 1; i < input.length(); i++) {
            if (currentChar == input.charAt(i)) {
                maxLength++;
                if (i == input.length() - 1 && maxLength > longestLength) {
                    longestLength = maxLength;
                    longestStart = i - longestLength + 1;
                }
            } else {
                currentChar = input.charAt(i);
                if (maxLength > longestLength) {
                    longestLength = maxLength;
                    longestStart = i - maxLength;
                }
                maxLength = 1;
            }
        }
        System.out.println(longestStart + " - " + longestLength);
        // your code goes here
        return new int[]{longestStart, longestLength};
    }

    public static String findMissingLetters(String sentence) {
        Map<Character, Long> characterMap = new HashMap<>(26);
        for (char c = 'a'; c <= 'z'; c++) {
            characterMap.put(c, 0L);
        }
        sentence = sentence.toLowerCase();
        for (int i = 0; i < sentence.length(); i++) {
            if (sentence.charAt(i) != ' ')
                characterMap.put(sentence.charAt(i), (characterMap.get(sentence.charAt(i)) + 1));
        }
        StringBuilder sb = new StringBuilder();
        characterMap.entrySet().stream().filter(o -> o.getValue() == 0L).forEach(c -> sb.append(c.getKey()));
        return sb.toString();
    }

    public static ArrayList<Integer> primeFactorization(int n) {
        ArrayList<Integer> primeFactors = new ArrayList<>();
        while (n % 2 == 0) {
            primeFactors.add(2);
            n /= 2;
        }

        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            while (n % i == 0) {
                primeFactors.add(i);
                n /= i;
            }
        }
        if (n > 2) {
            primeFactors.add(n);
        }
        return primeFactors;
    }

    //    "cat dog tac sat tas god dog"
    public static void printAnagrams(String input) {
        Map<String, List<String>> anagramGroups = new HashMap<>();
        for (String word : List.of(input.split(" "))) { //cat
            char[] charArray = word.toCharArray(); // c a t
            Arrays.sort(charArray); // a c t
            String sortedWord = new String(charArray); // act

            if (!anagramGroups.containsKey(sortedWord)) {
                anagramGroups.put(sortedWord, new ArrayList<>());
            }
            anagramGroups.get(sortedWord).add(word);
        }
        for (List<String> value : anagramGroups.values()) {
            System.out.println(value);
        }
    }

    public static int[] addFractions(int[] fraction1, int[] fraction2) {
        int numerator1 = fraction1[0];
        int denominator1 = fraction1[1];
        int numerator2 = fraction2[0];
        int denominator2 = fraction2[1];

        int numerator = (numerator1 * denominator2) + (numerator2 * denominator1);
        int denominator = denominator1 * denominator2;

        int gcd = gcd(numerator, denominator);

        return new int[]{numerator / gcd, denominator / gcd};
    }

    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static double calculateSquareRoot(double number) {
        if (number == 0) {
            return 0;
        }
        double start = 0;
        double last = number;
        double precision = 0.0005;
        double mid = 0;
        while ((last - start) > precision) {
            mid = (last + start) / 2;
            if (mid * mid == number) {
                return mid;
            } else if (mid * mid > number) {
                last = mid;
            } else {
                start = mid;
            }
        }

        return mid;
    }

    /**
     * You have an integer array.
     * Starting from arr[startIndex], follow each element to the index it points to.
     * Continue to do this until you find a cycle.
     * Return the length of the cycle. If no cycle is found return -1
     * Test Cases:
     * System.out.println(countLengthOfCycle(new int[]{1, 0}, 0));
     * System.out.println(countLengthOfCycle(new int[]{1, 2, 0}, 0));
     * System.out.println(countLengthOfCycle(new int[]{1, 3, 3, 1}, 0));
     */
    public static int countLengthOfCycle(int[] arr, int startIndex) {
        HashSet<Integer> cycleSet = new HashSet<>();
        int count = 0;
        for (int i = startIndex; i < arr.length; i++) {
            if (cycleSet.add(arr[i])) {
                count++;
            }
            if (i == arr.length - 1 && !cycleSet.add(arr[i])) {
                return count;
            }
        }
        return -1;
    }

    public static int countLengthOfCycleSlowFast(int[] arr, int startIndex) {
        if (arr.length == 1) return -1;
        int fast = arr[arr[startIndex]];
        int slow = arr[startIndex];
        int count = 1;
        while (fast != slow) {
            if (fast >= arr.length) return -1;
            count++;
            int x = arr[fast];
            if (x > arr.length) return -1;
            fast = arr[x];
            slow = arr[slow];
        }
        return count;
    }

    public static int minEncodingLength(String ingredients) { //ABABCABABCE
        int n = ingredients.length();
        if (n == 0) {
            return 0;
        }
        StringBuilder magicPotion = new StringBuilder();
        magicPotion.append(ingredients.charAt(0));

        for (int i = 1; i < n; i++) {
            if (i * 2 <= n) {
                String stringToCompare = ingredients.substring(0, i);
                if (stringToCompare.equals(ingredients.substring(i, 2 * i))) {
                    magicPotion.append("*");
                    i = 2 * i - 1; //a -1 here as there is already a ++i in for loop
                } else {
                    magicPotion.append(ingredients.charAt(i));
                }
            } else { //i*2 has crossed n, simply add the characters
                magicPotion.append(ingredients.charAt(i));
            }
        }
        System.out.println(ingredients + "\t" + magicPotion);

        return magicPotion.length();
    }

    public static HashSet<String> uniqueTuples(String inputString, int length) throws IllegalArgumentException {
        HashSet<String> hs = new HashSet<String>();
        int inputStringLen = 0;

        if (inputString == null || inputStringLen == 0 || length <= 0 || length > inputStringLen) {
            if (inputString == null) {
                throw new IllegalArgumentException("Input string cannot be null.");
            } else {
                inputStringLen = inputString.length();
            }
            if (inputStringLen == 0) {
                throw new IllegalArgumentException("Input string cannot be of zero length.");
            }
            if (length <= 0) {
                throw new IllegalArgumentException("Length of tuples has to be greater than zero.");
            }
            if (length > inputStringLen) {
                throw new IllegalArgumentException(
                        "Length of the tuple cannot be more than the length of the input string.");
            }
        }

        for (int i = 0; i < (inputStringLen - length + 1); i++) {
            hs.add(inputString.substring(i, (i + length)));
        }

        return hs;
    }

    public static HashSet<String> uniqueTuples1(String input, int len) {
        HashSet<String> result = new HashSet<String>();
        createTuples(input, "", len, result);
        return result;
    }

    private static void createTuples(String input, String subStr, int len, HashSet<String> result) {
        if (subStr.length() == len) {
            result.add(subStr);
            return;
        }
        if (input.isEmpty()) { //this should be checked after above if statement, else you will miss few combinations
            return;
        }
        for (int i = 0; i < input.length(); i++) {
            char cur = input.charAt(i);
            input = input.substring(i + 1); //take only the leftover string, unless you want
            //to generate all possible combinations like 'ba'
            createTuples(input, subStr, len, result); //current not considered
            createTuples(input, subStr + cur, len, result); //current considered
        }
    }

    public static int atoi(String str) {
        int isNegative = 1;
        int ans = str.chars().filter(c -> c > 47 && c < 58).map(c -> c - '0').reduce(0, (a, b) -> a * 10 + b);

        if (str.charAt(0) == '-') {
            isNegative = -1;
        }
        System.out.println(ans * isNegative);


        boolean isNeg = str.charAt(0) == '-';
        if (isNeg) {
            return Integer.parseInt(str.substring(1)) * -1;
        } else {
            return Integer.parseInt(str);
        }
    }

    /**
     * find Sub array length if sum of sub array >= target
     * Brute force O(n^2)
     */
    public static int subArrayExceedsSum(int[] arr, int target) {
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            int count = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                count++;
                if (sum >= target) {
                    ans = Math.min(ans, count);
                    break;
                }
            }
            if (i == arr.length - 1 & ans != Integer.MAX_VALUE) {
                return ans;
            }
        }
        return -1;
    }

    /**
     * Sliding window
     */
    public static int subArrayExceedsSumSlidingWindow(int[] arr, int target) {
        int left = 0;
        int sum = 0;
        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            while (sum >= target) {
                answer = Math.min(answer, i - left + 1);
                sum -= arr[left];
                left++;
            }
        }
        if (answer == Integer.MAX_VALUE) return -1;

        return answer;
    }

    public double findMaxAverage(int[] nums, int k) {
        double sum = 0.0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        double currentSum = sum; // 35
        for (int i = k; i < nums.length; i++) {
            sum += nums[i] - nums[i - k];
            currentSum = Math.max(sum, currentSum);
        }
        return sum / k;
    }

    public static int longestOnes(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int zeroCount = 0;
        int result = 0;
        while (right < nums.length) {
            if (nums[right] == 0) {
                zeroCount++;
                while (zeroCount > k) {
                    if (nums[left] == 0) {
                        zeroCount--;
                    }
                    left++;
                }
            }
            result = Math.max(result, right - left + 1);
            right++;
        }
        return result;
    }

    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    private static int armstrong(int num) {
        int sum = 0;
        int current = num;
        while (num > 0) {
            int val = num % 10;
            sum += val * val * val;
            num /= 10;
        }
        if (sum == current) System.out.println("yo");
        else System.out.println("no");
        return num;
    }

    public static void powerOfTen(int n) {
        while (n % 10 == 0) {
            n /= 10;
        }
        if (n == 1) System.out.println("true");
        else System.out.println("false");
    }

    public static void printCamelCase(String input) {
        StringBuilder sb = new StringBuilder();
        boolean isCap = false;
        if (input.charAt(0) != ' ') {
            sb.append(input.substring(0, 1).toLowerCase());
        }
        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i) == ' ') {
                isCap = true;
            } else {
                if (isCap) {
                    sb.append(input.substring(i, i + 1).toUpperCase());
                } else {
                    sb.append(input.substring(i, i + 1).toLowerCase());
                }
                isCap = false;
            }
        }
        System.out.println(sb);
    }

    public static void passwordChecker(String password) {
        Map<String, Boolean> condition = new LinkedHashMap<>();
        condition.put("c1", false);
        condition.put("c2", false);
        condition.put("c3", false);
        condition.put("c4", false);
        condition.put("c5", false);

        if (password.length() > 8) {
            condition.replace("c3", true);
        }
        for (int i = 0; i < password.length(); i++) {
            if (Character.isLowerCase(password.charAt(i))) {
                condition.replace("c4", true);
            }
            if (Character.isUpperCase(password.charAt(i))) {
                condition.replace("c2", true);
            }

            if (password.charAt(i) - '0' >= 97 && password.charAt(i) - '0' <= 123) {
                condition.replace("c1", true);
            }
            char special = password.charAt(i);
            if (special == '!' || special == '@' || special == '#' || special == '$' || special == '%') {
                condition.replace("c5", true);
            }
        }
        condition.entrySet().forEach(System.out::println);
    }

    public static void allPairs(int[] a) {
        int sum = 0;
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i + 1; j < a.length; j++) {
                sum += (a[i] * a[j]);
            }
        }
        System.out.println(sum);
    }

    public static void countFibonacciInRange(int L, int R) {
        if (R < 0 || L > R) {
            return;
        }
        int a = 0, b = 1;
        int count = 0;
        while (a <= R) {
            if (a >= L && a <= R) {
                count++;
            }
            int next = a + b;
            a = b;
            b = next;
        }

        System.out.println(count);
    }

    public static void printStaircase(int n) {
        for (int i = 1; i <= n; i++) {
            int k;

            if (i % 2 != 0) {
                k = i + 1;
            } else {
                k = i;
            }
            for (int j = 0; j < k; j++) {
                System.out.print(" * ");
            }
            System.out.println();
        }
    }

    public static void topThreeVideos() {
        Map<String, Integer> map = new HashMap<>();
        map.put("Apple", 40);
        map.put("Banana", 20);
        map.put("Orange", 30);
        map.put("Mango", 10);
        map.put("Tomato", 10);
        map.put("Peach", 100);
        map.put("Kiwi", 90);

        map.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, _) -> e1, LinkedHashMap::new)).entrySet().forEach(System.out::println);


//        List<Map.Entry<String, Integer>> videoList = new ArrayList<>(map.entrySet());
//        videoList.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
//
//        Map<String, Integer> sortedMap = new LinkedHashMap<>();
//        for (Map.Entry<String, Integer> val : videoList) {
//            sortedMap.put(val.getKey(), val.getValue());
//        }
//
//        sortedMap.entrySet().forEach(System.out::println);
    }

    public static void secondSmallestInUnsortedArray(int[] a) {
        // 3, 2, 5, 8, 1, 10
        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;
        for (int n : a) {
            if (n < smallest) {
                secondSmallest = smallest;
                smallest = n;
            } else if (secondSmallest > n && n > smallest) {
                secondSmallest = n;
            }
        }
        System.out.println(secondSmallest);
    }

    public static void findMinimumWordDistance(String[] words, String w1, String w2) {
        int minDistance = Integer.MAX_VALUE;
        int index1 = -1;
        int index2 = -1;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equalsIgnoreCase(w1)) {
                index1 = i;
                if (index2 != -1) {
                    minDistance = Math.min(minDistance, Math.abs(i - index2));
                }
            }

            if (words[i].equalsIgnoreCase(w2)) {
                index2 = i;
                if (index1 != -1) {
                    minDistance = Math.min(minDistance, Math.abs(i - index1));
                }
            }
        }
        System.out.println(minDistance);
    }

    public static int[] findWaitDays(int[] temperatures) {
        int length = temperatures.length;
        int[] waitDays = new int[length];
        Stack<Integer> integers = new Stack<>();
        for (int i = 0; i < length; i++) {
            while (!integers.isEmpty() && temperatures[i] > temperatures[integers.peek()]) {
                int previous = integers.pop();
                waitDays[previous] = i - previous;
            }
            integers.push(i);
        }
        return waitDays;
    }

    public static int[] findWaitDaysBruteForce(int[] temperatures) {
        int n = temperatures.length;
        int[] waitDays = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (temperatures[j] > temperatures[i]) {
                    waitDays[i] = j - i;
                    break;
                }
            }
        }
        return waitDays;
    }

    //"Let's take this example"
    public static void reverseWordsOnlyInString(String input) {
        int left = 0;
        int right = 0;

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == ' ' || i == input.length() - 1) {
                while (right >= left && right > 0) {
                    if (input.charAt(right - 1) != ' ') {
                        sb.append(input.charAt(right - 1));
                    }
                    right--;
                }
                if (i != input.length() - 1) {
                    sb.append(input.charAt(i));
                }
                left = i + 1;
                right = i + 1;
            }
            right++;
        }
        System.out.println(sb);
    }

    public static void occurrenceCharacter(String input) {
        // 2 ways: aaabbca > a3b2c1a1
        char running = input.charAt(0);
        int charCount = 1;
        if (input.length() == 1) {
            System.out.println(running + "" + charCount);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i) == running) {
                charCount++;
            } else {
                sb.append(running);
                if (charCount > 1) {
                    sb.append(charCount);
                }
                running = input.charAt(i);
                charCount = 1;
            }
            if (i == input.length() - 1) {
                sb.append(running);
                if (charCount > 1) {
                    sb.append(charCount);
                }
            }
        }
        System.out.println(sb);
        // 2 ways: aaabbca > a4b2c1
        input.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().forEach(System.out::println);
    }

    /**
     * String[][] students = new String[4][4];
     * students[0][0] = "A";
     * students[0][1] = "200";
     * students[1][0] = "B";
     * students[1][1] = "100";
     * students[2][0] = "A";
     * students[2][1] = "100";
     * students[3][0] = "C";
     * students[3][1] = "80";
     */
    public static void studentAverageMarks(String[][] students) {
        double average = 0.0;
        Map<String, int[]> studentMap = new HashMap<>();
        for (int i = 0; i < students.length; i++) {
            if (!studentMap.containsKey(students[i][0])) {
                studentMap.put(students[i][0], new int[]{1, Integer.parseInt(students[i][1])});
            } else {
                studentMap.get(students[i][0])[0]++;
                studentMap.get(students[i][0])[1] += Integer.parseInt(students[i][1]);
            }
        }
        for (int[] i : studentMap.values()) {
            double tempAverage = (double) i[1] / i[0];
            average = Math.max(average, tempAverage);
        }
        System.out.println(average);
    }

    public static void bestAvgGrade() {
        StudentMarks s1 = new StudentMarks("A", 85);
        StudentMarks s2 = new StudentMarks("B", 3);
        StudentMarks s = new StudentMarks("A", -91);
        StudentMarks s3 = new StudentMarks("C", 100);
        StudentMarks s4 = new StudentMarks("C", -50);
        List<StudentMarks> list = List.of(s1, s2, s3, s4, s); // Input

        Map<String, List<Integer>> map = new HashMap<>();
        for (StudentMarks value : list) {
            if (!map.containsKey(value.name)) {
                map.put(value.name, new ArrayList<>());
            }
            map.get(value.name).add(value.marks);
        }
        double ans = 0.0;
        for (Map.Entry<String, List<Integer>> value : map.entrySet()) {
            int sum = 0;
            double average = 0.0;
            for (Integer v : value.getValue()) {
                sum += v;
            }
            average = (double) sum / value.getValue().size();
            ans = Math.max(average, ans);
        }
        System.out.println(ans);
    }

    /*
    A function to check if a given string can be formed using a single row of keyboard.

    Input: "alaska" Upper1 middle, lower
    Output: true
    Explanation: All characters of "alaska" fall in second alphabetic row (a,s,d...l) of keyboard.

    Input: "olive"
    Output: false
    Explanation: All characters of "olive" fall in different rows of keyboard.
    */
    public static boolean checkWordExistsInKeyword(String input) {
        String upper = "qwertyuiop";
        String middle = "asdfghjkl"; // alaska
        String lower = "zxcvbnm";
        Set<Character> upperSet = new HashSet<>();
        Set<Character> middleSet = new HashSet<>();
        Set<Character> lowerSet = new HashSet<>();
        Set<Character> inputSet = new HashSet<>();
        for (int i = 0; i < upper.length(); i++) {
            upperSet.add(upper.charAt(i));
        }

        for (int i = 0; i < middle.length(); i++) {
            middleSet.add(middle.charAt(i));
        }

        for (int i = 0; i < lower.length(); i++) {
            lowerSet.add(lower.charAt(i));
        }
        for (int i = 0; i < input.length(); i++) {
            inputSet.add(input.charAt(i));
        }
        return upperSet.containsAll(inputSet) || middleSet.containsAll(inputSet) || lowerSet.containsAll(inputSet);
    }

    /**
     * abbac -> c i.e. removing adjacent duplicates -> bb -> aac -> repeat the same -> ans: c
     * @param input string
     */
    public static void removeAdjacentDuplicates(String input) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            if (!sb.isEmpty() && sb.charAt(sb.length() - 1) == input.charAt(i)) {
                sb.deleteCharAt(sb.length() - 1);
            } else {
                sb.append(input.charAt(i));
            }
        }
        System.out.println(sb);
    }


    public static int maxVowels(String s, int k) {
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        int l = 0;
        int vCount = 0;
        int max = Integer.MIN_VALUE;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            if (sb.length() > k) {
                if (vowels.contains(sb.charAt(0))) {
                    vCount--;
                }
                sb.deleteCharAt(0);
            }
            if (vowels.contains(s.charAt(i))) {
                vCount++;
            }
            max = Math.max(max, vCount);
        }
        return max;
    }

    /**
     * int[][] grid1 = {
     * {0, 0, 0, 0, 5},
     * {0, 1, 1, 1, 0},
     * {2, 0, 0, 0, 0}
     * };
     */
    public static int optimalPath(int[][] arr) {
        int row = arr.length;
        int col = arr[0].length;
        int ans = 0;
        int[][] dp = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = col - 1; j >= 0; j--) {
                if (i == 0 && j == col - 1) {
                    dp[i][j] = arr[i][j];
                } else if (i == 0) {
                    dp[i][j] = arr[i][j] + dp[i][j + 1];
                } else if (j == col - 1) {
                    dp[i][j] = arr[i][j] + dp[i - 1][j];
                } else {
                    dp[i][j] = arr[i][j] + Math.max(dp[i - 1][j], dp[i][j + 1]);
                }
            }
        }
        return dp[row - 1][0];
    }

    /**
     * Go for the running sum, easy sol
     * * Instructions to candidate.
     * *  1) Given an array of non-negative integers representing the elevations
     * *     from the vertical cross section of a range of hills, determine how
     * *     many units of snow could be captured between the hills.
     * *
     * *     See the example array and elevation map below.
     * *                                 ___
     * *             ___                |   |        ___
     * *            |   |        ___    |   |___    |   |
     * *         ___|   |    ___|   |   |   |   |   |   |
     * *     ___|___|___|___|___|___|___|___|___|___|___|___
     * *     {0,  1,  3,  0,  1,  2,  0,  4,  2,  0,  3,  0}
     * *                                 ___
     * *             ___                |   |        ___
     * *            |   | *   *  _*_  * |   |_*_  * |   |
     * *         ___|   | *  _*_|   | * |   |   | * |   |
     * *     ___|___|___|_*_|___|___|_*_|___|___|_*_|___|___
     * *     {0,  1,  3,  0,  1,  2,  0,  4,  2,  0,  3,  0}
     * *
     * *     Solution: In this example 13 units of snow (*) could be captured.
     * *
     * *  2) Consider adding some additional tests in doTestsPass().
     * *  3) Implement computeSnowpack() correctly.
     */
    public static int computeSnowpack(int[] height) {
        int leftMax, rightMax, left, right;
        leftMax = 0;
        rightMax = 0;
        left = 0;
        right = height.length - 1;
        int vol = 0;
        while (left + 1 < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            int cur = Math.min(leftMax, rightMax);
            if (leftMax < rightMax) {
                cur -= height[left + 1];
                left++;
            } else {
                cur -= height[right - 1];
                right--;
            }
            if (cur > 0) vol += cur;
        }
        return vol;
    }

    /**
     * Option 2: Running Sum
     */
    static int findWater(int[] arr) {
        int n = arr.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int res = 0;
        left[0] = arr[0];
        for (int i = 1; i < n; i++) {
            left[i] = Math.max(left[i - 1], arr[i]);
        }
        right[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], arr[i]);
        }
        for (int i = 1; i < n - 1; i++) {
            int minOf2 = Math.min(left[i - 1], right[i + 1]);
            if (minOf2 > arr[i]) {
                res += minOf2 - arr[i];
            }
        }
        return res;
    }

    /**
     * * There is a staircase with 'n' number of steps. A child
     * * walks by and wants to climb up the stairs, starting at
     * * the bottom step and ascending to the top.instead
     * * of taking 1 step at a time, it will vary between taking
     * * either 1, 2 or 3 steps at a time.
     * * Given 'n' number of steps below method should find
     * * number of
     * * unique combinations the child could traverse.
     * * An example would be countSteps(3) == 4:
     * * 1 1 1
     * * 2 1
     * * 1 2
     * * 3
     */
    public static int countSteps(int n) {
        if (n <= 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return countSteps(n - 1) + countSteps(n - 2) + countSteps(n - 3);
    }

    /**
     * int[] arr1 = {-5, 3, 6, 12, 15};
     * int[] arr2 = {-12, -10, -6, -3, 4, 10};
     * Output: 3
     * how to calculate Median:
     * 1. Odd: n/2
     * 2. Even: ((n/2) + (n/2 + 1))/2 => 1,2,3,4 => (2 + 3)/2 = 2.5
     */
    public static double findMedianSortedArrays(int[] input1, int[] input2) {
        int[] merged = new int[input1.length + input2.length];
        System.arraycopy(input1, 0, merged, 0, input1.length);
        System.arraycopy(input2, 0, merged, input1.length, input2.length);
        Arrays.sort(merged);

        int n = merged.length;
        if (n % 2 == 0) {
            int mid1 = n / 2;
            int mid2 = mid1 - 1;
            return (merged[mid1] + merged[mid2]) / 2.0;
        } else {
            return merged[n / 2];
        }
    }

    /**
     * TreeNode n = null;
     * n = addTreeNode(n, 5);
     * n = addTreeNode(n, 10);
     * n = addTreeNode(n, 15);
     * n = addTreeNode(n, 4);
     * n = addTreeNode(n, 2);
     * n = addTreeNode(n, 3);
     * n = addTreeNode(n, 8);
     */
    public static TreeNode addTreeNode(TreeNode n, int key) {
        if (n == null) {
            return new TreeNode(key);
        }

        if (n.value == key) {
            return n;
        }

        if (n.value > key) {
            n.left = addTreeNode(n.left, key);
        } else {
            n.right = addTreeNode(n.right, key);
        }
        return n;
    }

    /**
     * traverseTreeNode(n); //2,3,4,5,8,10,15
     */
    public static void traverseTreeNode(TreeNode n) {
        if (n != null) {
            traverseTreeNode(n.left);
            System.out.println(n.value);
            traverseTreeNode(n.right);
        }
    }

    /**
     * System.out.println(containsTreeNode(n, 5));//true
     * System.out.println(containsTreeNode(n, 8));//true
     * System.out.println(containsTreeNode(n, 1));//false
     * System.out.println(containsTreeNode(n, 0));//false
     */
    public static boolean containsTreeNode(TreeNode n, int value) {
        if (n != null) {
            if (value == n.value) {
                return true;
            }
            if (value < n.value) {
                return containsTreeNode(n.left, value);
            } else {
                return containsTreeNode(n.right, value);
            }
        }
        return false;
    }


    /**
     * Distance Between Strings
     * <p>
     * private static final String _paragraph;
     * static{
     * StringBuffer sb = new StringBuffer();
     * sb.append("In publishing and graphic design, lorem ipsum is a filler text commonly used to demonstrate the graphic elements");
     * sb.append(" lorem ipsum text has been used in typesetting since the 1960s or earlier, when it was popularized by advertisements");
     * sb.append(" for Letraset transfer sheets. It was introduced to the Information Age in the mid-1980s by Aldus Corporation, which");
     * <p>
     * _paragraph = sb.toString();
     * }
     * <p>
     * public static boolean doTestsPass() {
     * return  shortestDistance(_paragraph, "and", "graphic") == 6d &&
     * shortestDistance(_paragraph, "transfer", "it") == 14d &&
     * shortestDistance(_paragraph, "Design", "filler" ) == 25d;
     * }
     * <p>
     * ===============> Main method:
     * if (doTestsPass()) {
     * System.out.println("All tests pass");
     * } else {
     * System.out.println("There are test failures");
     * }
     */
    public static double shortestDistance(String paragraph, String wordOne, String wordTwo) {
        String[] paraWords = paragraph.split("[,. ]");
        double shortestDistance = Integer.MAX_VALUE;
        double wordOneIndex = 0;
        double wordTwoIndex = 0;
        int wordIndex = 0;

        for (String word : paraWords) {
            if (word.equalsIgnoreCase(wordOne)) {
                wordOneIndex = wordIndex + word.length() / 2d;
            } else if (word.equalsIgnoreCase(wordTwo)) {
                wordTwoIndex = wordIndex + word.length() / 2d;
            }

            if (wordOneIndex > 0 && wordTwoIndex > 0) {
                double current = Math.abs(wordOneIndex - wordTwoIndex);
                if (current < shortestDistance) {
                    shortestDistance = current;
                }
            }
            wordIndex += word.length() + 1;
        }
        return shortestDistance;
    }


    /**
     * System.out.println(longestUniqueCharacters("abcbdamop"));
     * System.out.println(longestUniqueCharacters("abab"));
     * System.out.println(longestUniqueCharacters("a"));
     * System.out.println(longestUniqueCharacters(""));
     */
    public static String longestUniqueCharacters(String a) {
        if (a.isEmpty()) return "";
        HashSet<Character> seen = new HashSet<>();
        int left = 0;
        int maxLength = 0;
        int maxStart = 0;
        for (int right = 0; right < a.length(); right++) {
            while (seen.contains(a.charAt(right))) {
                seen.remove(a.charAt(left));
                left++;
            }
            seen.add(a.charAt(right));
            if (right - left + 1 > maxLength) {
                maxLength = right - left + 1;
                maxStart = left;
            }
        }
        return a.substring(maxStart, maxStart + maxLength);
    }

    /*
     ** Get the size of the tree with root index rootIndex
     */
    public static Integer getTreeSize(final Map<Integer, List<Integer>> parentToChild, final Integer rootIndex) {
        Integer result = 0;
        final Stack<Integer> nodes = new Stack<>();
        nodes.push(rootIndex);
        while (!nodes.empty()) {
            final Integer index = nodes.pop();
            for (final Integer childIndex : parentToChild.getOrDefault(index, new ArrayList<>())) {
                nodes.push(childIndex);
                result++;
            }
        }
        return result;
    }

    /*
     **  Find the largest tree.
     */
    public static Integer largestTree(final Map<Integer, Integer> immediateParent) {
        Integer maxTreeSize = 0;
        Integer minRootId = 0;
        final Map<Integer, List<Integer>> parentToChild = new HashMap<>();
        final List<Integer> rootIndexes = new ArrayList<>();
        for (final Map.Entry<Integer, Integer> childToParent : immediateParent.entrySet()) {
            final Integer childIndex = childToParent.getKey();
            final Integer parentIndex = childToParent.getValue();
            parentToChild.putIfAbsent(parentIndex, new ArrayList<>());
            parentToChild.get(parentIndex).add(childIndex);
            if (!immediateParent.containsKey(parentIndex)) {
                rootIndexes.add(parentIndex);
            }
        }
        for (final Integer rootIndex : rootIndexes) {
            final Integer treeSize = getTreeSize(parentToChild, rootIndex);
            if (treeSize > maxTreeSize) {
                maxTreeSize = treeSize;
                minRootId = rootIndex;
            } else if (treeSize == maxTreeSize) {
                minRootId = Math.min(minRootId, rootIndex);
            }
        }

        return minRootId;
    }

    static boolean check(int A[], int N) {
        Stack<Integer> S = new Stack<Integer>();
        int B_end = 0;
        for (int i = 0; i < N; i++) {
            if (!S.empty()) {
                int top = S.peek();
                while (top == B_end + 1) {
                    B_end = B_end + 1;
                    S.pop();
                    if (S.empty()) break;
                    top = S.peek();
                }
                if (S.empty()) {
                    S.push(A[i]);
                } else {
                    top = S.peek();
                    if (A[i] < top) {
                        S.push(A[i]);
                    } else {
                        return false;
                    }
                }
            } else {
                S.push(A[i]);
            }
        }
        return true;
    }
}

class StudentMarks {
    String name;
    int marks;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public StudentMarks(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }
}
