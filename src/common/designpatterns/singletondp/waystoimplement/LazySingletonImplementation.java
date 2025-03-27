package common.designpatterns.singletondp.waystoimplement;

public class LazySingletonImplementation {
    private static volatile LazySingletonImplementation lazySingletonImplementation;

    private LazySingletonImplementation() {
    }

    public LazySingletonImplementation getInstance() {
        if (lazySingletonImplementation == null) {
            synchronized (LazySingletonImplementation.class) {
                lazySingletonImplementation = new LazySingletonImplementation();
            }
        }
        return lazySingletonImplementation;
    }
}
