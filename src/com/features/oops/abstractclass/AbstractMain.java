package com.features.oops.abstractclass;

public class AbstractMain {
    public static void main(String[] args) {
        MyAbstractClass myClass = new MyAbstractClass("vv") {
            public void displayValue() {
                System.out.println("Hello");
            }
        };
        TestClass testClass = new TestClass("v");
        testClass.displayValue();
        myClass.displayValue();
    }
}

