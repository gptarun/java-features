package com.features.multithreading;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceMain {
    public static void main(String[] args) {
        ExecutorServiceDemo executorServiceDemo = new ExecutorServiceDemo("Testing Executor Service");
        ExecutorService executorService
                = Executors.newFixedThreadPool(4);
        Future<String> result = executorService.submit(executorServiceDemo);
        try {
            System.out.println(result.get());
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        } finally {
            executorService.shutdown();
        }
    }
}
