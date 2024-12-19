package com.java8features.threads.concurrent;

public class VolatileAtomicMain {
    int counter = 0;

    public void increment() {
        counter++;
        System.out.println("Thread: " + Thread.currentThread());
        System.out.println(counter);
    }

    public void runThread() {
        for (int i = 0; i < 50; i++) {
            increment();
        }
    }

    public static void main(String[] args) {
        VolatileAtomicMain atomicMain = new VolatileAtomicMain();
        Thread t1 = new Thread(atomicMain::runThread);
        Thread t2 = new Thread(atomicMain::runThread);
        t1.start();
        t2.start();
    }
}
