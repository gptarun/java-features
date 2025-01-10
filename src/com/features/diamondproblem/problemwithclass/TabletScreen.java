package com.features.diamondproblem.problemwithclass;

public interface TabletScreen extends ScreenInterface {
    @Override
    public default void display() {
        System.out.println("Displaying tablet screen");
    }
}