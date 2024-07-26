package com.java8features.methodreference;

public interface ITest {
    public void printTest();
    public default TestImpl getTestImpl() {
        return new TestImpl();
    }
}
