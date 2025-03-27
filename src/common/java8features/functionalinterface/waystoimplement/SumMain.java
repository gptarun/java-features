package common.java8features.functionalinterface.waystoimplement;

import java.util.function.Function;

/**
 * Ways to implement Functional Interface:
 * 1. Implementation via Lambda Expression
 * 2. Implementation via Anonymous Class
 * 3. Implementation via Method Reference
 * 4. Implementation via Constructor Reference
 * 5. Implementation via Local Class
 * 6. Implementation Using a Returning Function
 */
public class SumMain {
    /**
     * 1. Implementation via Lambda Expression
     * 2. Implementation via Anonymous Class
     */
    public static void main(String[] args) {
        // 1. Implementation via Lambda Expression **************************************
        SumInterface sumInterface = (a, b) -> a + b;
        System.out.println(sumInterface.sum(6, 6));
        SumInterface sumInterfaceLambda = Integer::sum;
        System.out.println(sumInterfaceLambda.sum(6, 6));


        // 2. Implementation via Anonymous Class **************************************
        SumInterface sumInterface1 = new SumInterface() {
            @Override
            public int sum(int a, int b) {
                return a + b;
            }
        };
        System.out.println(sumInterface1.sum(10, 20));


        // 2.1 Another Implementation via Anonymous on String **************************************
        StringInterface stringInterface = new StringInterface() {
            @Override
            public String concatString(String a, String b) {
                return a.concat(b);
            }
        };
        System.out.println(stringInterface.concatString("Hello", " World!"));


        // 3. Implementation via Method Reference **************************************
        SumInterface sumInterface2 = SumMain::sumUsingMethodReference;
        System.out.println(sumInterface2.sum(100, 200));



        /*
         * 5. Implementation via Local Class ****************************************
         */
        class Added implements SumInterface {
            @Override
            public int sum(int a, int b) {
                return a + b;
            }
        }
        SumInterface sumInterface3 = new Added();
        System.out.println(sumInterface3.sum(60, 80));


        // 6. Implementation Using a Returning Function (Supplier) *****************************
        Function<int[], Integer> sumFunction = arr -> arr[0] + arr[1];
        System.out.println(sumFunction.apply(new int[]{11, 11}));
    }

    /**
     * 3. Implementation via Method Reference
     */
    public static int sumUsingMethodReference(int a, int b) {
        return a + b;
    }
}
