package common.features.multithreading.concurrent;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class FailSafeFailFast {
    public static void main(String[] args) {
        /* *********** Fail Safe Example *************/
        System.out.println("*********** Fail Safe Example *************");
        failSafeMethod();

        /* *********** Fail Fast Example *************/
        System.out.println("*********** Fail Fast Example *************");
        failFastMethod();
    }

    /**
     * NOTES: Function will throw the exception "ConcurrentModificationException"
     * Output:
     * One
     * Exception in thread "main" java.util.ConcurrentModificationException
     */
    private static void failFastMethod() {
        List<String> words = new ArrayList<>();
        words.add("One");
        words.add("Two");

        Iterator<String> wordIterator = words.iterator();
        while (wordIterator.hasNext()) {
            System.out.println(wordIterator.next());
            words.add("Three"); // This will trigger a ConcurrentModificationException
        }
    }

    /**
     * NOTES: CopyOnWriteArrayList is a thread-safe variant of ArrayList
     * Output:
     * One
     * Two
     */
    private static void failSafeMethod() {
        List<String> words = new CopyOnWriteArrayList<>(); // This will handle ConcurrentModificationException
        words.add("One");
        words.add("Two");

        Iterator<String> wordIterator = words.iterator();
        while (wordIterator.hasNext()) {
            System.out.println(wordIterator.next());
            words.add("Three");
        }
    }
}
