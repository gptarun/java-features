package com.designpatterns.singletondp.cloneableissue;

public class SingletonClass extends SuperClass {
    public static SingletonClass instance = new SingletonClass();

    private SingletonClass() {
        // private constructor
    }
}
