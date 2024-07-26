package com.java8features.defaultinterface;

public class DefaultInterfaceMain {
    public static void main(String[] args) {
        IDefaultInterface iDefaultInterface = new DefaultImpl();
        iDefaultInterface.calculateSum(5, 6);
        iDefaultInterface.printString();
    }
}
