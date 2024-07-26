package com.java8features.optional;

import com.java8features.Customer;

import java.util.Date;
import java.util.Optional;

public class OptionalMain {
    public static void main(String[] args) {
        Customer c = null;
//        System.out.println(Optional.ofNullable(c));
//        System.out.println(Optional.of(c));

        Optional<Customer> c1 = Optional.ofNullable(c);
//        System.out.println(c1.isPresent());
//        System.out.println(c1.isEmpty());
        System.out.println(c1.orElse(new Customer(1L, "", new Date())));
    }
}
