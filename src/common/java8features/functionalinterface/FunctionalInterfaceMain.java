package common.java8features.functionalinterface;

public class FunctionalInterfaceMain implements MyInterface2 {

    /**
     * This is coming from Parent Interface MyInterface1
     */
    @Override
    public void printString() {
        MyInterface2.super.printString();
    }

    /**
     * This is coming from Parent Interface MyInterface2
     */
    @Override
    public void printArray() {

    }

    /**
     * This is coming from Parent Interface MyInterface1
     */
    @Override
    public void yo() {
        MyInterface2.super.yo();
    }

    /**
     * This is coming from Parent Interface MyInterface1
     */
    //@Override STATIC method cannot be overridden
    static void printing() {

    }
}
