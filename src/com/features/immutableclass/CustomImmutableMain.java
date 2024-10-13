package com.features.immutableclass;

public class CustomImmutableMain {
    public static void main(String[] args) {
        ImmutableClassExample immutableClassExample = new ImmutableClassExample(1, "Test");
        System.out.println(immutableClassExample.getI());
    }
}
