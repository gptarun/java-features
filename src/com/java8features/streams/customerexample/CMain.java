package com.java8features.streams.customerexample;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

// Driver class
class CMain {

    public static void main(String[] args) {
        Customer customer = new Customer(1L, "Tarun", new Date(), "HR");
        Customer customer1 = new Customer(2L, "Gupta", new Date(), "HR");
        Customer customer2 = new Customer(3L, "Tarun", new Date(), "SALES");
        Customer customer3 = new Customer(5L, "Tarun", new Date(), "HR");

        List<Customer> customers = List.of(customer, customer1, customer2, customer3);
        //****************************************************
        //
        // Converting List of customers to Map
        //
        //****************************************************
        Map<Long, Customer> c = customers.stream().collect(Collectors.toMap(o -> o.getId(), v -> v));
        Map<Long, Customer> practice = customers.stream().collect(Collectors.toMap(Customer::getId, a -> a));
        c.entrySet().forEach(System.out::println);
        System.out.println("--------------");
        sortingCustomerListTreeMap();

        System.out.println("-------GROUP BY-------");
        groupByName(customers);
        //        Customer customer3 = null;
        //        System.out.println(Optional.ofNullable(customer3));

//        customers.stream().map(obj -> {obj.setDob(formatDate(obj.getDob()));return obj;}).forEach(System.out::println);
//        customers.stream().peek(obj -> obj.setDob(formatDate(obj.getDob()))).forEach(System.out::println);


        /**
         * Highest ID and Lowest ID of the Customer || Can be used for other fields like Salary
         */
        System.out.println("---------------Highest---Lowest---Value---------");
        Long maxId = customers.stream().max(Comparator.comparing(Customer::getId)).get().getId();
        Long minId = customers.stream().min(Comparator.comparing(Customer::getId)).get().getId();
        System.out.println("Max - Min" + maxId + " - " + minId);

    }

    /**
     * *****************************************
     * Sorting Customer List Using Tree Map
     * *****************************************
     */
    public static void sortingCustomerListTreeMap() {
        Customer customer = new Customer(1L, "Tarun", new Date());
        Customer customer1 = new Customer(2L, "Gupta", new Date());
        Customer customer2 = new Customer(3L, "Kishan", new Date());
        HashMap<Integer, Customer> customerMap = new HashMap<>();
        customerMap.put(1, customer);
        customerMap.put(2, customer1);
        customerMap.put(3, customer2);
        //Sorting
        TreeSet<Map.Entry<Integer, Customer>> treeSet = new TreeSet<>(Comparator.comparing((Map.Entry<Integer, Customer> entry) -> entry.getValue().getName()));
        treeSet.addAll(customerMap.entrySet());
        treeSet.forEach(System.out::println);
    }

    private static Date formatDate(Date value) {
        try {
            SimpleDateFormat s = new SimpleDateFormat("dd-MM-yyyy");
            return s.parse("11-04-2024");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new Date();
    }

    public static void groupByName(List<Customer> customers) {
        Map<String, Long> mapCount = customers.stream().filter(emp -> emp.getDepartment().equals("HR"))
                .collect(Collectors.groupingBy(obj -> obj.getName(), Collectors.counting()));
        System.out.println(mapCount);
    }
}

