package com.java8features.streams.intermediate;

import java.util.List;

public class FilterMain {
    public static void main(String[] args) {
        /*
         * Filter takes the Predicate
         */
        List<String> value = List.of("Alpha", "Beta", "Gamma", "Alpha", "Beta");
        value.stream().filter(s -> s.equalsIgnoreCase("Alpha")).forEach(System.out::print);
    }
}
