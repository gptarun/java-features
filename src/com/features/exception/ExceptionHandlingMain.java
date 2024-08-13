package com.features.exception;

/**
 * NOTES: if finally block contains return then try/catch will not return only the 'finally' block will return
 * MORE INFO: Refer below functions
 */
public class ExceptionHandlingMain {
    public static void main(String[] args) {
        /* *********** CASE 1 *************/
        System.out.println("try-finally-Test");
        System.out.println(tryFinallyTest());

        /* *********** CASE 2 *************/
        System.out.println("try-catch-finally-Test");
        System.out.println(tryCatchFinally());

        /* *********** CASE 3 *************/
        System.out.println("try-catch-finally-without-exception-Test");
        System.out.println(tryCatchFinallyWithoutException());

        /* *********** CASE 4 *************/
        System.out.println("try-finally-unhandled-exception-Test");
        System.out.println(tryCatchFinallyUnhandledException());
    }

    /**
     * NOTES: Function will not throw the exception "divide by Zero"
     * Output:
     * Test1
     * Test2
     * 2
     */
    static int tryFinallyTest() {
        try {
            System.out.println("Test1");
            int i = 1 / 0;
            return i;
        } finally {
            System.out.println("Test2");
            return 2;
        }
    }

    /**
     * NOTES: Function will not throw the exception "divide by Zero", catch block will also get executed
     * Output:
     * Test11
     * Test12
     * Test13
     * 13
     */
    static int tryCatchFinally() {
        try {
            System.out.println("Test11");
            int i = 1 / 0;
            return i;
        } catch (Exception e) {
            System.out.println("Test12");
            return 12;
        } finally {
            System.out.println("Test13");
            return 13;
        }
    }

    /**
     * NOTES: Function will not throw the exception "divide by Zero", catch block will also get executed
     * Output:
     * Test11
     * Test12
     * Test13
     * 12
     */
    static int tryCatchFinallyWithoutException() {
        try {
            System.out.println("Test11");
            int i = 1 / 0;
            return i;
        } catch (Exception e) {
            System.out.println("Test12");
            return 12;
        } finally {
            System.out.println("Test13");
        }
    }

    /**
     * NOTES: Function will throw the exception "divide by Zero"
     * Output:
     * Test11
     * Test13
     * @return nothing
     * @throws ArithmeticException: / by zero
     */
    static int tryCatchFinallyUnhandledException() {
        try {
            System.out.println("Test11");
            int i = 1 / 0;
            return i;
        } finally {
            System.out.println("Test13");
        }
    }
}
