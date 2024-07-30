package com.features.concrete;

public abstract class CalculationAbstract implements CalculationInterface {
    @Override
    public int product(int a, int b) {
        return a * b;
    }

    final void printNumbers(int a, int b) {
        System.out.println("Numbers are: " + a + " and " + b);
    }
}
