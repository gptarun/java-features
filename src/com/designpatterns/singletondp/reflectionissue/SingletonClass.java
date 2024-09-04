package com.designpatterns.singletondp.reflectionissue;

public class SingletonClass {
    // Eager way of creating singleton object
    public static SingletonClass singletonClass = new SingletonClass();

    // Won't allow creating instance in another class
    private SingletonClass() {
        if (singletonClass != null) {
            // This Exception will prevent creating a new instance from constructor.newInstance();
            throw new RuntimeException("You are trying to create another instance");
        }
    }

    // Lazy way of creating singleton object
    public static SingletonClass getInstance() {
        if (singletonClass == null) {
            // Adding thread Safety
            synchronized (SingletonClass.class) {
                singletonClass = new SingletonClass();
            }
        }
        return singletonClass;
    }

    public void displayYo() {
        System.out.println("Yo");
    }
}
