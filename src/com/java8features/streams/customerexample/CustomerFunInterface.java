package com.java8features.streams.customerexample;

@FunctionalInterface
public interface CustomerFunInterface {
    String value = "";

    abstract void customerData(String customerName);

    default void customerEmail(String customerEmail) {
    }

}
