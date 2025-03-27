package common.reactivestreams;

import common.java9features.reactivestreams.SimpleSubscriber;

import java.util.concurrent.SubmissionPublisher;
//import java.util.concurrent.TimeUnit;

public class ReactiveStreamsMain {
    public static void main(String[] args) throws InterruptedException {
        SubmissionPublisher<String> publisher = new SubmissionPublisher<>();
        SimpleSubscriber subscriber = new SimpleSubscriber();
        publisher.subscribe(subscriber);

        System.out.println("Publishing items...");
        String[] items = {"Item 1", "Item 2", "Item 3"};

        for (String item : items) {
            publisher.submit(item);
            System.out.println("Published: " + item);
            Thread.sleep(1000);
//            TimeUnit.SECONDS.sleep(1); // Simulate delay
        }

        publisher.close();

        // Wait for all items to be processed
        Thread.sleep(3000);
//        TimeUnit.SECONDS.sleep(3);
    }
}
// Streams: collection of objects per operations perform karne k liye hai
// ParallelStreams: Performance over order of execution
// Reactive Programming: Use to achieve Async and Concurrency
// Reactive Streams: Reactive Streams is a standard for asynchronous stream processing with non-blocking back pressure
    // 4 Interfaces :
    // Publisher(Push the data): subscribe() method
    // Subscriber(Receives the data): Will call the subscribe() function || onSubscribe, onNext, onError, onComplete
    // Subscription
    // Processor
