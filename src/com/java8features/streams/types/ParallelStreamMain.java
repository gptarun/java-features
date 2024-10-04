package com.java8features.streams.types;

public class ParallelStreamMain {
    public static void main(String[] args) {
        String input = "Different order everytime";
        input.chars().parallel().mapToObj(c -> (char) c).filter(c -> c != 'e').forEach(System.out::print);
    }
}
