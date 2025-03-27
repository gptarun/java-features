package common.java8features.functionalinterface;

/**
 * Notes: Functional Interface must have one declared function, it can have multiple default functions as well
 */

@FunctionalInterface
public interface MyInterface1 {
    void printArray();

    default void printString() {

    }

    static void printString1() {

    }
}
