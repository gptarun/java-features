package com.java8features.defaultinterface;

public class DefaultImpl implements IDefaultInterface {
    //****************************************************
    //
    // here we do not need to implement the default method calculateSum(a, b)
    // that's why default methods has been added to overcome "if a new method is added then we need to provide an implementation
    // in existing class"
    //
    //****************************************************
    @Override
    public void printString() {
        System.out.println("Yo! This is an abstract function");
    }
}
