package common.features.multithreading;

import java.util.concurrent.Callable;

public class ExecutorServiceDemo implements Callable<String> {
    // Member variable of this class
    private String message;

    // Constructor of this class
    public ExecutorServiceDemo(String message) {
        // This keyword refers to current instance itself
        this.message = message;
    }

    // Method of this Class
    public String call() throws Exception {
        return "Hiiii " + message + "!";
    }
}
