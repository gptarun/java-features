package com.features.multithreading;

public class ThreadMain {
    public static void main(String[] args) {
        ThreadByRunnable threadByRunnable = new ThreadByRunnable();
        Thread thread = new Thread(threadByRunnable);
        //****************************************************
        //
        // why not threadClass.run() -> this will execute the Runnable.run()
        // which executes the run() method of current thread only
        //
        // on the other hand thread.start() starts the thread that calls the run() method
        // which creates the new thread
        //
        //****************************************************
        thread.start();

        ThreadByClass threadByClass = new ThreadByClass();
        threadByClass.start();

        /**
         * Java 8 way for calling run method from Runnable class
         */
        Runnable runnable = () -> {
            System.out.println("Runnable with Lambda Expression");
        };
        new Thread(runnable).start();
    }
}
