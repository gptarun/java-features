package com.java8features.functionalinterface;


/**
 * Notes: If you extends the functional interface i.e MyInterface1 then base interface i.e MyInterface2 will
 * also behaves as Functional Interface
 * IMP: You may or may not override the parent interface functions
 */
@FunctionalInterface
public interface MyInterface2 extends MyInterface1 {
    void printArray();
    static void printing() {

    }
    default void yo() {
        System.out.println("printing yo");
    }
}
