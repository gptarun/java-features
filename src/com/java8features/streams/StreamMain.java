package com.java8features.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamMain {
    public static void main(String[] args) {
//        printStreamUsingIndex();
        printUniqueChars();
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

}
