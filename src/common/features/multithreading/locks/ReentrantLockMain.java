package common.features.multithreading.locks;

import java.util.concurrent.locks.ReentrantLock;

/**
 * ********************************* Read Me *********************************
 * Reentrant locks are a more advanced form of locks that provide more flexibility and control over the locking mechanism.
 * A reentrant lock allows a thread to acquire a lock multiple times and release it multiple times,
 * while a regular lock can only be acquired and released once.
 */
public class ReentrantLockMain {
    private final ReentrantLock lock = new ReentrantLock();

    public void method1() {
        lock.lock();
        try {
            // code here
        } finally {
            lock.unlock();
        }
    }

    public void method2() {
        if (lock.tryLock()) {
            try {
                // code here
            } finally {
                lock.unlock();
            }
        } else {
            // code here
        }
    }
}
