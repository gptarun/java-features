package com.features.oops.abstractclass;

public class TestClass extends MyClass {

    public TestClass(String val) {
        super(val);
    }

    @Override
    public void displayValue() {
        System.out.println("Yo!");
    }
}
