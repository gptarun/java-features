package com;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PracticeAreaMain {
    public static void main(String[] args) {
        String input = "aabcccdl";
        Map<Character, Long> output = input.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        output.entrySet().stream().filter(k -> k.getValue() == 1).forEach(System.out::println);
    }
}