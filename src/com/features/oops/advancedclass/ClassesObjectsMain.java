package com.features.oops.advancedclass;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Ways to create objects
 */
public class ClassesObjectsMain {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        /*
         * Default way
         */
        DummyClass dummyClass = new DummyClass();
        dummyClass.displayNothing();

        /*
         * Using class for name
         */
        DummyClass obj = (DummyClass) Class.forName("com.features.oops.advancedclass.DummyClass").newInstance();
        obj.displayNothing();

        /*
         * Using constructor class
         */
        Constructor<DummyClass> constructor = DummyClass.class.getConstructor();
        DummyClass dummyClass1 = constructor.newInstance();
        dummyClass1.displayNothing();

        /*
         * Using clone: Need to implement the Cloneable interface
         */
        DummyClass dummyClass2 = dummyClass1.clone();
        dummyClass2.displayNothing();
    }
}
