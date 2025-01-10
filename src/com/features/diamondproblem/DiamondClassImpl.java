package com.features.diamondproblem;

public class DiamondClassImpl implements DiamondInterfaceImplBoth, DiamondInterfaceTwo {
    @Override
    public void fun() {
        System.out.println("Diamond problem solved!");
    }

    @Override
    public void funOne() {
        DiamondInterfaceImplBoth.super.funOne();
        DiamondInterfaceTwo.super.funOne();
    }
}
