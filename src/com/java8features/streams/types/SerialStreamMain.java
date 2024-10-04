package com.java8features.streams.types;

public class SerialStreamMain {
    public static void main(String[] args) {
        String input = "Order of execution will be same";
        input.chars().mapToObj(c -> (char) c).forEach(System.out::print);
    }
}
