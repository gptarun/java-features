package com.java8features.defaultinterface.defaultmethods;

public class DefaultMain implements IDefaultMethods {
    public static void main(String[] args) {
        IDefaultMethods iDefaultMethods = new DefaultMain();
        iDefaultMethods.justSayHello();
    }
}
