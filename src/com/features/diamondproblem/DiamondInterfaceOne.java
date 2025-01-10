package com.features.diamondproblem;

public interface DiamondInterfaceOne {
    void fun();

    default void funOne() {
        System.out.println("With default function interface 1!");
    }
}
