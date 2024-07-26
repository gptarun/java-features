package com.java8features.defaultinterface;

public interface IDefaultInterface {
    public void printString();

    default public void calculateSum(int a, int b) {
        System.out.println(a + b);
    }

}
