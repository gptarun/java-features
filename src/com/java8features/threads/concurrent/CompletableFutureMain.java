package com.java8features.threads.concurrent;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureMain {
    public static void main(String[] args) {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
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
         * future.complete("It's completed"); // then it won't print Line No 22.
         *
         * CompletableFuture: Provides methods like exceptionally and handle to handle exceptions in a non-blocking manner.
         */
        future.thenAccept(System.out::println);
        future.join();
    }
}
