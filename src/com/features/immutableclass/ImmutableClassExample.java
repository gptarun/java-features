package com.features.immutableclass;

public final class ImmutableClassExample {
    final int i;
    final String name;

    public ImmutableClassExample(int i, String name) {
        this.i = i;
        this.name = name;
    }

    public int getI() {
        return i;
    }

    public String getName() {
        return name;
    }
}
