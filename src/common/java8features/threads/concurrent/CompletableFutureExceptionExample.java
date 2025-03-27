package common.java8features.threads.concurrent;

import common.solid.Employee;

import java.util.concurrent.*;

public class CompletableFutureExceptionExample {
    /**
     * Async Methods of CompletableFuture
     * <p>
     * CompletableFuture provides a set of asynchronous methods to execute multiple tasks concurrently and
     * process the results as soon as they become available. These methods allow you to create a chain of dependent
     * tasks and execute them in parallel, improving the performance of your application.
     * <p>
     * Here are some examples of the async methods available in
     * Reference link: https://medium.com/javarevisited/java-completablefuture-c47ca8c885af
     * <p>
     * ForkJoinPool theory: ForkJoinPool is a type of ExecutorService in Java that is designed to handle a large number
     * of tasks in a highly efficient manner. It uses a divide-and-conquer approach to break down complex tasks into
     * smaller, more manageable tasks. This approach helps to reduce the overhead associated with task execution and helps
     * to optimize performance.
     * How does ForkJoinPool work?
     * The basic idea behind the ForkJoinPool is to divide a task into smaller subtasks and execute them concurrently.
     * The pool is comprised of a set of worker threads, each of which is responsible for executing a single subtask.
     * The subtasks can be further divided into smaller subtasks, and so on, until they are small enough to be executed
     * in a single thread.
     */
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        String test = null;
        executeEmployeeCron();
//        cfIntegerExceptionallyTest();
//        moreCompletableFuturePracticeInteger(50);
//        completableFutureAllOtherFunctions();

//        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
//            if (true) throw new RuntimeException("Exception in task");
//            return "Hello from CompletableFuture!";
//        });
//        completableFuture.exceptionally(ex -> "Error: " + ex.getMessage()).thenAccept(System.out::println);
    }

    public static void runnableEmployeeExample() throws ExecutionException, InterruptedException {
        ExecutorService es = Executors.newSingleThreadExecutor();
        EmployeeCronJob employeeCronJob = new EmployeeCronJob();
        Future<Employee> emps = es.submit(() -> employeeCronJob.fetchEmployee());
        System.out.println(emps.get());
        es.shutdown();
    }

    public static void executeEmployeeCron() {
        ExecutorService es = Executors.newSingleThreadExecutor();
        EmployeeCronJob employeeCronJob = new EmployeeCronJob();
        es.execute(employeeCronJob);
        es.shutdown();
    }

    public static void runnableWithScheduledJob() {
        EmployeeCronJob employeeCronJob = new EmployeeCronJob();
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);
        scheduledExecutorService.scheduleAtFixedRate(employeeCronJob, 1, 1, TimeUnit.SECONDS);
    }

    public static void completableFutureWithExecutorsTP() {
        ExecutorService es = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            int a = i;
            CompletableFuture.supplyAsync(() -> a * a, es);
        }
    }

    /**
     * Example 1: thenApplyAsync
     * <p>
     * This method is used to process the result of a task asynchronously and return a new CompletableFuture with the
     * transformed result. The processing is done by a separate thread in the
     * ForkJoinPool.commonPool()
     */
    public static void thenApplyAsyncExample() {
        ExecutorService es = Executors.newSingleThreadExecutor();
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "Hello");

        CompletableFuture<Integer> transformedFuture = future.thenApplyAsync(s -> {
            System.out.println("Thread: " + Thread.currentThread().getName());
            return s.length();
        });

        transformedFuture.thenAcceptAsync(length -> {
            System.out.println("Thread: " + Thread.currentThread().getName());
            System.out.println("Length of Hello: " + length);
        }, es);
    }

    /**
     * Example 2: thenAcceptAsync
     * <p>
     * This method is used to consume the result of a task asynchronously, without returning a value.
     * The processing is done by a separate thread in the ForkJoinPool.commonPool()
     */
    public static void thenAcceptAsyncExample() {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "Hello");

        CompletableFuture<Integer> transformedFuture = future.thenApplyAsync(s -> {
            System.out.println("Thread: " + Thread.currentThread().getName());
            return s.length();
        });

        transformedFuture.thenAcceptAsync(length -> {
            System.out.println("Thread: " + Thread.currentThread().getName());
            System.out.println("Length of Hello: " + length);
        });
    }

    /**
     * Example 3: runAsync
     * <p>
     * This method is used to execute a task asynchronously, without returning a value.
     * The processing is done by a separate `thread `in the ForkJoinPool.commonPool()
     * <p>
     * In this example, we’re using the runAsync() method to execute a task asynchronously that prints a message to the console using a separate thread.
     * <p>
     * The output of this code will vary depending on the number of available threads in the ForkJoinPool, but it will look something like this:
     * Output ->
     * Thread: ForkJoinPool.commonPool-worker-1
     * Hello from async task
     */
    public static void runAsyncExample() {
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            System.out.println("Thread: " + Thread.currentThread().getName());
            System.out.println("Hello from async task");
        });
    }

    /**
     * Example 4: thenComposeAsync
     * <p>
     * thenComposeAsync() is a method in CompletableFuture that allows you to chain multiple asynchronous tasks together
     * in a non-blocking way. This method is used when you have one CompletableFuture object that returns another
     * CompletableFuture object as its result, and you want to execute the second task after the first one has completed.
     * <p>
     * The thenComposeAsync() method takes a Function object as its argument, which takes the result of the first
     * CompletableFuture object as its input and returns another CompletableFuture object as its result. The second task
     * is executed when the first one completes, and its result is passed to the next stage of the pipeline.
     */
    public static void thenComposeAsyncExample() {
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> "Hello");
        CompletableFuture<String> future2 = future1.thenComposeAsync(s -> CompletableFuture.supplyAsync(() -> s + " World"));
        future2.thenAccept(result -> System.out.println(result));
    }

    public static void moreCompletableFuturePractice() {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            return "Testing";
        });
        future.thenAccept(output -> {
            if (output.equalsIgnoreCase("Testing")) {
                System.out.println("Seems like testing is working fine");
            } else {
                System.out.println("Invalid Operations");
            }
        });
    }

    public static void allOfTesting(String input) {
        CompletableFuture<String> c1 = CompletableFuture.supplyAsync(() -> "C1");
        c1.thenApplyAsync(String::toLowerCase);
        CompletableFuture<String> c2 = CompletableFuture.supplyAsync(() -> {
            if (input.equalsIgnoreCase("Test")) return "Done";
            else return "Nope";
        });
        CompletableFuture<String> c3 = CompletableFuture.supplyAsync(() -> "C3");

        CompletableFuture<Void> allCompletableFuture = CompletableFuture.allOf(c1, c2, c3);
        allCompletableFuture.thenRun(() -> {
            // All futures completed
            String result1 = c1.join();
            String result2 = c2.join();
            String result3 = c3.join();
            System.out.println(result1 + ", " + result2 + ", " + result3);
        }).exceptionally(ex -> {
            System.out.println("Exception occurred: " + ex.getMessage());
            return null; // Default value to return if there's an exception
        });
    }

    public static void moreCompletableFuturePracticeInteger(int number) {
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> number).
                thenApplyAsync(v -> v / 5).thenApplyAsync(v -> v * v);
        future.thenAccept(System.out::println).thenRun(() -> System.out.println("Yo, I am running"));
    }

    /**
     * Completable Future other functions
     */
    public static void completableFutureAllOtherFunctions() {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "Hello");

        CompletableFuture<Integer> transformedFuture = future.thenApplyAsync(s -> {
            System.out.println("Thread: " + Thread.currentThread().getName());
            return s.length();
        });

        CompletableFuture cc = transformedFuture.thenAccept(length -> {
            System.out.println("Thread: " + Thread.currentThread().getName());
            System.out.println("Length of Hello: " + length);
        });
    }
}
