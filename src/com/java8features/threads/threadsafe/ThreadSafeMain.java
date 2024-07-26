package com.java8features.threads.threadsafe;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ThreadSafeMain {
    public static void main(String[] args) {
        Thread t1 = new Thread();
        Thread t2 = new Thread();
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

}
