package common.reactivestreams;

import java.util.concurrent.Flow;

public class SimpleSubscriber implements Flow.Subscriber<String> {
    private Flow.Subscription subscription;

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        this.subscription = subscription;
        System.out.println("onSub");
        subscription.request(1); // Request one item
    }

    @Override
    public void onNext(String item) {
        System.out.println("Received: " + item);
        subscription.request(1); // Request next item
    }

    @Override
    public void onError(Throwable throwable) {
        System.err.println("Error occurred: " + throwable.getMessage());
    }

    @Override
    public void onComplete() {
        System.out.println("All items processed.");
    }
}
