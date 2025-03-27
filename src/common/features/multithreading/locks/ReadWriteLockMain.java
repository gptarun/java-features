package common.features.multithreading.locks;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * ********************************* Read Me *********************************
 * Read-write locks are a specialized form of locks that are used to control access to a shared resource.
 * They allow multiple threads to read the shared resource simultaneously, but only one thread can write to it at a time.
 * This can greatly improve the performance of a multithreaded application when the shared resource is read more
 * frequently than it is written.
 */
public class ReadWriteLockMain {
    private final ReadWriteLock lock = new ReentrantReadWriteLock();

    public void method1() {
        lock.readLock().lock();
        try {
            // code here
        } finally {
            lock.readLock().unlock();
        }
    }

    public void method2() {
        lock.writeLock().lock();
        try {
            // code here
        } finally {
            lock.writeLock().unlock();
        }
    }
}
