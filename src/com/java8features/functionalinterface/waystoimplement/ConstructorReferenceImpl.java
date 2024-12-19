package com.java8features.functionalinterface.waystoimplement;//package com.java8features.functionalinterface.waystoimplement;
//     /**
//     * Implementation via Constructor Reference
//     */
//public class ConstructorReferenceImpl {
//    // A class with a constructor that matches the functional interface signature
//    public static class Adder implements SumInterface {
//        @Override
//        public int sum(int a, int b) {
//            return a + b;
//        }
//    }
//
//    public static void main(String[] args) {
//        // Constructor reference implementation
//        SumInterface sumConstructorRef = Adder::new;
//
//        // Create an instance of Adder using the constructor reference
//        Adder adder = (Adder) sumConstructorRef;
//
//        // Test the constructor reference
//        System.out.println("Sum using constructor reference: " + adder.sum(5, 10));  // Output: 15
//    }
//}
