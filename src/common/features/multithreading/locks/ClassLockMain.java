package common.features.multithreading.locks;

/**
 * Class locks are used to synchronize access to a class’s "static" methods and fields.
 */
public class ClassLockMain {
    public static synchronized void method1() {
        System.out.println("Locking static method using synchronized keyword");
    }

    public static void method2() {
        synchronized(ClassLockMain.class) {
            System.out.println("Locking static method using synchronized block");
        }
    }
}
