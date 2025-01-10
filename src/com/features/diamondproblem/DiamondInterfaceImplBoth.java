package com.features.diamondproblem;

public interface DiamondInterfaceImplBoth extends DiamondInterfaceOne, DiamondInterfaceTwo {
    @Override
    default void fun() {

    }

    @Override
    default void funOne() {
        DiamondInterfaceOne.super.funOne();
    }
}
