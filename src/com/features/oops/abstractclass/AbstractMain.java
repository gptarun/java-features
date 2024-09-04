package com.features.oops.abstractclass;

public class AbstractMain {
    public static void main(String[] args) {
        MyClass myClass = new MyClass("vv") {
            public void displayValue() {
                System.out.println("Hello");
            }
        };
        TestClass testClass = new TestClass("v");
        testClass.displayValue();
        myClass.displayValue();
    }
}

