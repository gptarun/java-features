package com.datastructures.gsprep;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ExecutorFrameworkPractice {
    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();

        scheduledExecutorService.scheduleAtFixedRate(() -> printMessage(), 0, 10, TimeUnit.SECONDS);

//        scheduledExecutorService.shutdown();
    }

    public static void printMessage() {
        System.out.println("yo");
    }
}
