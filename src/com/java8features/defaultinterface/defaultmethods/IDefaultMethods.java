package com.java8features.defaultinterface.defaultmethods;

public interface IDefaultMethods {
    default void justSayHello() {
        System.out.println("Hello");
    }
}
