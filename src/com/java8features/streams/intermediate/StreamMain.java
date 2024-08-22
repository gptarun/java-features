package com.java8features.streams.intermediate;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamMain {
    public static void main(String[] args) {
//        printStreamUsingIndex();
        printUniqueChars();
        squareAddOneFindFirst();

        // All stream examples in one
        List<List<String>> listOfLists = Arrays.asList(
                Arrays.asList("Reflection", "Collection", "Stream"),
                Arrays.asList("Structure", "State", "Flow"),
                Arrays.asList("Sorting", "Mapping", "Reduction", "Stream")
        );

        Set<String> intermediateResults = new HashSet<>();

        // Stream pipeline demonstrating various intermediate operations
        List<String> result = listOfLists.stream()
                .flatMap(List::stream)               // Flatten the list of lists into a single stream
                .filter(s -> s.startsWith("S"))      // Filter elements starting with "S"
                .map(String::toUpperCase)            // Transform each element to uppercase
                .distinct()                          // Remove duplicate elements
                .sorted()                            // Sort elements
                .peek(intermediateResults::add) // Perform an action (add to set) on each element
                .toList();       // Collect the final result into a list

        // Print the intermediate results
        System.out.println("Intermediate Results:");
        intermediateResults.forEach(System.out::println);

        // Print the final result
        System.out.println("Final Result:");
        result.forEach(System.out::println);
    }

    /**
     * print list item with index using streams
     * using util.stream.IntStream
     */
    public static void printStreamUsingIndex() {
        List<String> input = Arrays.asList("Testing", "My", "Object");
        IntStream.range(0, input.size()).forEach(index -> System.out.println(index + ": " + input.get(index)));
    }

    /**
     * print unique characters using streams
     */
    public static void printUniqueChars() {
        String myString = "Unique Characters in String";
        myString.chars().distinct().mapToObj(c -> (char) c).forEach(System.out::print);
    }

    /**
     * Group By example in stream
     * Sorting as well
     */
    public static void groupByExample() {
        List<String> value = List.of("Alpha", "Beta", "Gamma", "Alpha", "Beta");
        Map<String, Long> test = value.stream().collect(Collectors.groupingBy(s -> s, Collectors.counting()));
        test.entrySet().forEach(System.out::println);
        value.stream().sorted(Comparator.naturalOrder()).forEach(System.out::println);
    }

    /**
     * Reversing a stream
     */
    public static void reversingStream() {
        List<String> value = List.of("Alpha", "Beta", "Gamma", "Alpha", "Beta");
        value.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
    }

    public static void squareAddOneFindFirst() {
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);
        Optional<Integer> val = nums.stream().map(a -> a * a + 1).filter(num -> num % 2 == 0).findFirst();
        System.out.println();
        System.out.println("c " + val.isPresent());
        System.out.println(val.get());
    }

}
