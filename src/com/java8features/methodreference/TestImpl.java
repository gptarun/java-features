package com.java8features.methodreference;

public class TestImpl {

    public TestImpl() {
        System.out.println("Constructor is called");
    }

    public static void printTest() {
        System.out.println("Print static function using class reference");
    }

    public void printNonStaticTest() {
        System.out.println("Print non static function using object reference");
    }

    public void callConstructorRef() {
        System.out.println(5 * 5);
    }
}
