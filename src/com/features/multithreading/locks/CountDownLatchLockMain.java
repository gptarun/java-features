package com.features.multithreading.locks;

import java.util.concurrent.CountDownLatch;

/**
 * ********************************* Read Me *********************************
 * A CountDownLatch is a synchronization aid that allows one or more threads to wait for a set of operations to complete.
 * It is initialized with a count, and the count is decremented each time a thread completes an operation.
 * When the count reaches zero, all threads waiting on the latch are released.
 */
public class CountDownLatchLockMain {
    private final CountDownLatch latch = new CountDownLatch(3);

    public void method1() {
        // code here
        latch.countDown();
    }

    public void method2() throws InterruptedException {
        latch.await();
        // code here
    }
}
