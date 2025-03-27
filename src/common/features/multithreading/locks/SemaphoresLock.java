package common.features.multithreading.locks;

import java.util.concurrent.Semaphore;

/**
 * ********************************* Read Me *********************************
 * Semaphores are a more advanced form of locks that can be used to control access to a shared resource.
 * They allow multiple threads to acquire the lock simultaneously, but limit the number of threads that can acquire
 * the lock at any given time. This is useful in scenarios where there are limited resources available, such as a pool
 * of connections or a cache.
 */
public class SemaphoresLock {
    private final Semaphore semaphore = new Semaphore(5);

    public void method1() throws InterruptedException {
        semaphore.acquire();
        try {
            // code here
        } finally {
            semaphore.release();
        }
    }
}
