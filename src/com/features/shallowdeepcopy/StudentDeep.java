package com.features.shallowdeepcopy;

public class StudentDeep implements Cloneable {
    int id;
    Address address;

    @Override
    public StudentDeep clone() {
        try {
            StudentDeep studentDeep = (StudentDeep) super.clone();
            // As here we are cloning the Address objects as well but not doing it in case of Shallow object creation
            studentDeep.address = address.clone();
            return studentDeep;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
