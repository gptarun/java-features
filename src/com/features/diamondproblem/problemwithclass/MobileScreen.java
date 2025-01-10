package com.features.diamondproblem.problemwithclass;

public interface MobileScreen extends ScreenInterface {
    @Override
    public default void display() {
        System.out.println("Displaying Mobile screen");
    }
}
