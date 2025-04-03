package common.features.exception;

/**
 * NOTES: if finally block contains return then try/catch will not return only the 'finally' block will return
 * MORE INFO: Refer below functions
 */
public class ExceptionHandlingMain {
    public static void main(String[] args) throws Exception {
        /* *********** interviewTrickyQuestion *************/
        interviewTrickyQuestion();

        /* *********** CASE 1 *************/
        System.out.println("try-finally-Test");
        System.out.println(tryFinallyTest());

        /* *********** CASE 2 *************/
        System.out.println("try-catch-finally-Test");
        System.out.println(tryCatchFinally());

        /* *********** CASE 3 *************/
        System.out.println("try-catch-finally-without-exception-Test");
        System.out.println(tryCatchFinallyWithoutException());

        //****************** BELOW CODES WILL BREAK THE FLOW ******************

        //NOTE: Need to comment either CASE 4 or CASE 5 to check the output
        /* *********** CASE 6 *************/
        System.out.println("try-print-throw-catch-print-finally-exception-Test");
        tryPrintThrowCatchPrintFinallyExceptionTest();

        //NOTE: Need to comment either CASE 4 or CASE 5 or CASE 6 to check the output
        /* *********** CASE 4 *************/
        System.out.println("try-Catch-finally-throw-exception");
        tryCatchFinallyThrow();

        //NOTE: Need to comment either CASE 4 or CASE 5 or CASE 6 to check the output
        /* *********** CASE 5 *************/
        System.out.println("try-finally-unhandled-exception-Test");
        System.out.println(tryCatchFinallyUnhandledException());
    }

    private static void interviewTrickyQuestion() {
        try {
            String s = null;
            s.equalsIgnoreCase("abc");
        } catch (RuntimeException e) {
            System.out.println("In catch");
//            String s1 = null;
//            s1.equalsIgnoreCase("abc");
            System.exit(0);
        } finally {
            System.out.println("In finally");
        }
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
     *
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


    /**
     * NOTES: Function will throw the exception "divide by Zero"
     * Output:
     * tryCatchFinallyThrow
     * Throw the exception
     *
     * @throws Exception in thread "main" java.lang.Exception
     */
    static void tryCatchFinallyThrow() throws Exception {
        try {
            throw new Exception();
        } catch (Exception e) {
            throw new Exception();
        } finally {
            System.out.println("tryCatchFinallyThrow");
        }
    }

    /**
     * NOTES: Function will throw the NullPointerException: Cannot invoke "Object.toString()" because "exceptionHandlingMain" is null
     * Output:
     * tryPrintThrowCatchPrintFinallyExceptionTest
     * Throw the exception
     */
    static void tryPrintThrowCatchPrintFinallyExceptionTest() {
        try {
            dummy();
        } catch (Exception e) {
            System.out.println("Hello");
            throw e;
        } finally {
            System.out.println("tryPrintThrowCatchPrintFinallyExceptionTest");
        }
    }

    private static String dummy() {
        ExceptionHandlingMain exceptionHandlingMain = null;
        return exceptionHandlingMain.toString();
    }
}
