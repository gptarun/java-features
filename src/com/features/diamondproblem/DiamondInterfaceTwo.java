package com.features.diamondproblem;

public interface DiamondInterfaceTwo {
    void fun();

    default void funOne() {
        System.out.println("With default function interface 2!");
    }
}
