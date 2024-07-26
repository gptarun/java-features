package com.java8features.threads.concurrent;

import java.util.concurrent.*;

public class FutureMain {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<String> future = executorService.submit(() -> {
            Thread.sleep(1000);
            return "Test";
        });

        /*
         * Exception Handling:
         *
         * Future: Exception handling is done using try-catch blocks around the get() method.
         */
        try {
            /*
             * Completion and Blocking:
             *
             * Future: You need to call future.get() to retrieve the result, which blocks the calling thread until the result is available.
             * CompletableFuture: Provides non-blocking methods like thenApply, thenAccept, and thenRun to handle the result asynchronously.
             */
            String res = future.get();
            System.out.println(res);
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
