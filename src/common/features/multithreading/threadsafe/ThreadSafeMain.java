package common.features.multithreading.threadsafe;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ThreadSafeMain {
    public static void main(String[] args) {
        Thread t1 = new Thread();
        Thread t2 = new Thread();
        threadLocalTest();
    }
    ArrayList<Integer> list = new ArrayList<>(); //Not thread safe
    List<Integer> listThreadSafe = new CopyOnWriteArrayList<>(); //thread safe

    //****************************************************
    //
    // volatile keyword is use to make variable thread safe
    //
    //****************************************************
    private volatile int sharedVariable;

    public void increment() {
        synchronized (this) {
            sharedVariable++;
        }
    }

    /**
     * Since Java 1.2
     * Variable -> Copy for each thread, visibility to single thread only
     */
    private static void threadLocalTest() {
        ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
        threadLocal.set(1);
        System.out.println(threadLocal.get());
        threadLocal.remove();
        System.out.println(threadLocal.get());
    }
}
