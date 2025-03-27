package common.java8features.streams;

import common.java8features.streams.customerexample.Customer;

import java.util.*;
import java.util.stream.Collectors;

public class HashMapValueSort {
    public static void main(String[] args) {
        Customer customer = new Customer(591L, "Tarun", new Date(), "HR");
        Customer customer1 = new Customer(222L, "Gupta", new Date(), "HR");
        Customer customer2 = new Customer(339L, "Tarun", new Date(), "SALES");
        Customer customer3 = new Customer(510L, "Tarun", new Date(), "HR");
        HashMap<Integer, Customer> customerHashMap = new HashMap<>();
        customerHashMap.put(1, customer);
        customerHashMap.put(2, customer1);
        customerHashMap.put(3, customer2);
        customerHashMap.put(4, customer3);

        Map<Integer, Customer> ans = customerHashMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue((Comparator.comparingLong(Customer::getId))))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (c1, c2) -> c1, LinkedHashMap::new));

        ans.entrySet().forEach(System.out::println);
    }
}
