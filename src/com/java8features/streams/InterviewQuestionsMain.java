package com.java8features.streams;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class InterviewQuestionsMain {
    public static void main(String[] args) {
        printOnlyNonRepeatedNumber();
    }

    /**
     * Q. Print only repeated numbers in the list
     */
    private static void printOnlyRepeatedNumber() {
        List<Integer> list = Arrays.asList(10, 15, 8, 49, 25, 98, 98, 32, 15, 10);
        list.stream().filter(v -> Collections.frequency(list, v) > 1).distinct().toList().forEach(System.out::println);
    }

    /**
     * Q. Print only non-repeated numbers in the list
     */
    private static void printOnlyNonRepeatedNumber() {
        List<Integer> list = Arrays.asList(10, 15, 8, 49, 25, 98, 98, 32, 15, 10);
        list.stream().filter(val -> Collections.frequency(list, val) == 1).toList().forEach(System.out::println);
    }
}
