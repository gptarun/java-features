package com.designpatterns.singletondp.waystoimplement;

public class EagerLazySingletonImplementation {
    private static final EagerLazySingletonImplementation SINGLETON_IMPLEMENTATION = new EagerLazySingletonImplementation();

    private EagerLazySingletonImplementation() {
    }

    public EagerLazySingletonImplementation getSingletonImplementation() {
        return SINGLETON_IMPLEMENTATION;
    }
}
