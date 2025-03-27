package common.features.multithreading;

import common.java8features.threads.concurrent.CompletableFutureExceptionExample;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * ***************************** READ ME *****************************
 * Completable Future refer here {@link CompletableFutureExceptionExample}
 * <p>
 * ***************************** Callable Future *****************************
 * one feature lacking in  Runnable is that we cannot make a thread return result when it terminates,
 * i.e. when run() completes. For supporting this feature, the Callable interface is present in Java.
 * <p>
 * ***************************** Callable vs Runnable *****************************
 * <p>
 * For implementing Runnable, the run() method needs to be implemented which does not return anything,
 * while for a Callable, the call() method needs to be implemented which returns a result on completion.
 * Note that a thread can’t be created with a Callable, it can only be created with a Runnable.
 * Another difference is that the call() method can throw an exception whereas run() cannot.
 * <p>
 * Finds out that we need Callable to return the result and this result will be stored into Future
 * In Summary:
 * Callable is used to define a task that will be executed asynchronously and can return a result.
 * Future is used to represent the outcome of that asynchronous computation, providing methods to retrieve the result or cancel the task.
 * Another point:
 * Callable and Runnable are being used to submit as a task with Executor service
 * </p>
 */
public class CallableAndFutureMain implements Callable<Integer> {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask[] randomNumberTasks = new FutureTask[5];

        for (int i = 0; i < 5; i++) {
            Callable<Integer> callable = new CallableAndFutureMain();
            // Create the FutureTask with Callable
            randomNumberTasks[i] = new FutureTask(callable);

            // As it implements Runnable, create Thread
            // with FutureTask
            Thread t = new Thread(randomNumberTasks[i]);
            t.start();
        }

        for (int i = 0; i < 5; i++) {
            // As it implements Future, we can call get()
            System.out.println(randomNumberTasks[i].get());

            // This method blocks till the result is obtained
            // The get method can throw checked exceptions
            // like when it is interrupted. This is the reason
            // for adding the throws clause to main
        }

    }

    /**
     * Computes a result, or throws an exception if unable to do so.
     *
     * @return computed result
     * @throws Exception if unable to compute a result
     */
    @Override
    public Integer call() throws Exception {
        Random generator = new Random();
        int randomNumber = generator.nextInt(5);
        // To simulate a heavy computation,
        // we delay the thread for some random time
        Thread.sleep(randomNumber * 1000);
        return randomNumber;
    }
}
