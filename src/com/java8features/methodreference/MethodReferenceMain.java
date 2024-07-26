package com.java8features.methodreference;

public class MethodReferenceMain {
    public static void main(String[] args) {

//     * *****************************************
//     * Static function method reference
//     * *****************************************
        ITest iTest = TestImpl::printTest;
        iTest.printTest();

//     * *****************************************
//     * Non-Static function Object reference
//     * *****************************************
        TestImpl test = new TestImpl();
        ITest iTest1 = test::printNonStaticTest;
        iTest1.printTest();

//     * *****************************************
//     * Constructor reference
//     * *****************************************
        ITest iTest3 = TestImpl::new;
        iTest3.getTestImpl().callConstructorRef();
    }
}
