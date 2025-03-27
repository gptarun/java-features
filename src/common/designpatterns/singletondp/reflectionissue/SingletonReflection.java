package common.designpatterns.singletondp.reflectionissue;

/**
 * Fix is, use enum as it won't provide access for the Constructor
 */
public enum SingletonReflection {
    INSTANCE;

    public void doSomething() {
        // Your business logic here
        System.out.println("Singleton using Enum");
    }
}
