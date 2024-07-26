package com.java8features;

@FunctionalInterface
public interface CustomerFunInterface {
    String value = "";

    abstract void customerData(String customerName);

    default void customerEmail(String customerEmail) {
    }

}
