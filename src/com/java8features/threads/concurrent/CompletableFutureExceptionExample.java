package com.java8features.threads.concurrent;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureExceptionExample {
    public static void main(String[] args) {
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
            // Simulate a task that throws an exception
            if (true) {
                throw new RuntimeException("Exception in task");
            }
            return "Hello from CompletableFuture!";
        });

        // Handle the exception
        completableFuture
                .exceptionally(ex -> "Error: " + ex.getMessage())
                .thenAccept(System.out::println);
    }
}
