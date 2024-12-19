package com.datastructures.gsprep;

class SingletonExample {
    private final static SingletonExample SINGLETON_EXAMPLE = new SingletonExample();

    private SingletonExample() {
    }

    public static SingletonExample getSingletonExample() {
        return SINGLETON_EXAMPLE;
    }
}

class TestSingleton {
    public static void main(String[] args) {

    }
}