package common.java8features.methodreference;

import java.util.LinkedHashMap;
import java.util.function.Function;
import java.util.stream.*;

public class MethodReferenceMain {
    public static void main(String[] args) {

//     * *****************************************
//     * Static function method reference
//     * *****************************************
        ITest iTest = TestImpl::printTest;
        iTest.printTest();

//     * *****************************************
//     * Non-Static function Object reference
//     * *****************************************
        TestImpl test = new TestImpl();
        ITest iTest1 = test::printNonStaticTest;
        iTest1.printTest();

//     * *****************************************
//     * Constructor reference
//     * *****************************************
        ITest iTest3 = TestImpl::new;
        iTest3.getTestImpl().callConstructorRef();

        //Another example for Constructor and static method reference
        String input = "racecars"; //Need to find the first unique character from it
        Character ans = input.chars().mapToObj(c -> (char) c)
                .collect(Collectors.toMap(Function.identity(), _ -> 1L, Long::sum, LinkedHashMap::new))
                .entrySet().stream().filter(value -> value.getValue() == 1).findFirst().get().getKey();
        System.out.println(ans);

    }
}
