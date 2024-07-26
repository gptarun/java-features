package com.java8features.threads;

public class ThreadMain {
    public static void main(String[] args) {
        ThreadByRunnable threadClass = new ThreadByRunnable();
        Thread thread = new Thread(threadClass);
        //****************************************************
        //
        // why not threadClass.run() -> this will execute the Runnable.run()
        // which executes the run() method of current thread only
        //
        // on the other hand thread.start() starts the thread that calls the run() method
        // which creates the new thread
        //
        //****************************************************
//         thread.start();

        ThreadByClass threadByClass = new ThreadByClass();
        threadByClass.start();
    }
}
