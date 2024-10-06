package com.features.multithreading.locks;

import java.util.concurrent.locks.StampedLock;

/**
 * ********************************* Read Me *********************************
 * Stamped locks were introduced in Java 8 as an alternative to read-write locks, they offer more fine-grained control
 * over read and write operations, as well as a try-optimistic-locking mechanism.
 * <p>
 * A stamped lock works by associating a stamp with a lock state, the stamp serves as a token that verifies the lock
 * state when performing operations. The stamped lock provides three modes of operation:
 * <p>
 * 1. Optimistic Read: This mode allows multiple threads to read the shared resource simultaneously without acquiring a lock.
 * 2. Read: This mode allows only one thread to read the shared resource at a time.
 * 3. Write: This mode allows only one thread to write to the shared resource at a time.
 */
public class StampedLocksMainJava8 {

    public void methodOptimisticRead() {
        StampedLock lock = new StampedLock();
        long stamp = lock.tryOptimisticRead();

        if (lock.validate(stamp)) {
            // read shared resource
        } else {
            stamp = lock.readLock();
            try {
                // read shared resource
            } finally {
                lock.unlockRead(stamp);
            }
        }
    }

    public void methodRead() {
        StampedLock lock = new StampedLock();
        long stamp = lock.readLock();
        try {
            // read shared resource
        } finally {
            lock.unlockRead(stamp);
        }
    }

    public void methodWrite() {
        StampedLock lock = new StampedLock();
        long stamp = lock.writeLock();
        try {
            // write to shared resource
        } finally {
            lock.unlockWrite(stamp);
        }
    }
}
