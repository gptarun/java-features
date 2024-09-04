package com.designpatterns.singletondp.cloneableissue;

public class SuperClass implements Cloneable {
    @Override
    public SuperClass clone() {
        try {
            // Add this throw new CloneNotSupportedException();
            // instead of return super.clone(); this will not allow to create another instance
            throw new CloneNotSupportedException();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
