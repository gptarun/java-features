package com.java8features.threads.concurrent;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureMain {
    public static void main(String[] args) {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Hello from CompletableFuture!";
        });
        /*
         * Manual Completion:
         *
         * Future: Cannot be manually completed.
         * CompletableFuture: Can be manually completed using methods like complete().
         * future.complete("It's completed"); // then it won't print Line No 24.
         *
         * CompletableFuture: Provides methods like exceptionally and handle to handle exceptions in a non-blocking manner.
         */
        future.thenAccept(System.out::println);
        future.join();

        /*
         * Key functions provided by CompletableFuture in Java
         */
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> "supplyAsync example").thenApplyAsync(String::toUpperCase);
        future1.thenAccept(System.out::println);
        future1.join();

        /*
         * EXCEPTIONALLY in CompletableFuture
         */
        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> 5 / 0);
        future2.exceptionally(throwable -> {
//            throwable.printStackTrace();
            return 0;
        });


        CompletableFuture<Integer> future3 = CompletableFuture.supplyAsync(() -> {
            // Some long-running operation
            return 10;
        });

        CompletableFuture<Integer> future4 = CompletableFuture.supplyAsync(() -> {
            int result = 10 / 0; // Causes an ArithmeticException
            return result;
        });

        CompletableFuture<Integer> future5 = CompletableFuture.supplyAsync(() -> {
            // Some long-running operation
            return 20;
        });

        CompletableFuture<Void> allFutures = CompletableFuture.allOf(future3, future4, future5);

        allFutures.exceptionally(ex -> {
            System.out.println("Exception occurred: " + ex.getMessage());
            return null; // Default value to return if there's an exception
        }).thenRun(() -> {
            // All futures completed
            int result1 = future3.join();
            int result2 = future4.join();
            int result3 = future5.join();
            System.out.println(result1 + ", " + result2 + ", " + result3);
        });
    }
}
