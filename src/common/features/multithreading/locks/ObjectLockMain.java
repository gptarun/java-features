package common.features.multithreading.locks;

public class ObjectLockMain {
    public synchronized void method1() {
        System.out.println("Using synchronized keyword");
    }

    public void method2() {
        synchronized (this) {
            System.out.println("Using synchronized block");
        }
    }
}
