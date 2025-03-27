package common.features.innerclasses;

public class StaticClassMain {

    int i = 0;
    static int j = 0;

    public StaticClassMain() {
    }

    public static void main(String[] args) {
        InnerStaticClass innerStaticClass = new InnerStaticClass();
        StaticClassMain staticClassMain = new StaticClassMain();
        innerStaticClass.testFunction();
    }

    static class InnerStaticClass {
        StaticClassMain test = new StaticClassMain();

        void testFunction() {
            test.i = 5;
            System.out.println(j);
            System.out.println(test.i); //Printing outer class non-static variable i needed object, but for non-static inner class it's not required
        }
    }
}
