package com.java8features.streams;

import com.entity.AccountTransaction;

import java.util.*;

public class InterviewQuestionsMain {
    public static void main(String[] args) {
        squaringAddingOneAndFindFirstEvent();
    }

    /**
     * Q. Print only repeated numbers in the list
     */
    private static void printOnlyRepeatedNumber() {
        List<Integer> list = Arrays.asList(10, 15, 8, 49, 25, 98, 98, 32, 15, 10);
        list.stream().filter(v -> Collections.frequency(list, v) > 1).distinct().toList().forEach(System.out::println);
    }

    /**
     * Q. Print only non-repeated numbers in the list
     */
    private static void printOnlyNonRepeatedNumber() {
        List<Integer> list = Arrays.asList(10, 15, 8, 49, 25, 98, 98, 32, 15, 10);
        list.stream().filter(val -> Collections.frequency(list, val) == 1).toList().forEach(System.out::println);
    }

    /**
     * Q. squaring, adding 1, first even
     */
    private static void squaringAddingOneAndFindFirstEvent() {
        List<Integer> list = Arrays.asList(10, 15, 8, 49, 25, 98, 98, 32, 15, 10);
        Optional<Integer> ans = list.stream().map(num -> num * num + 1).filter(num -> num % 2 == 0).findFirst();
        ans.ifPresent(System.out::println);
    }


    /**
     * Q. Print total from credit and debit transactions or sum of all the transaction type amount
     */
    private static void printTotalCreditAndDebitTransactions() {
        Date inputDate = new Date();
        List<AccountTransaction> trsanctions = Arrays.asList(
                new AccountTransaction(1, 1, 100, "Debit", inputDate),
                new AccountTransaction(2, 2, 200, "Credit", inputDate)
        );
        int total = trsanctions.stream().filter(t -> t.getTransactionDate().equals(inputDate))
                .mapToInt(t -> t.getTransactionType().equals("Credit") ? t.getAmount() : -t.getAmount()).sum();
        System.out.println("Total: " + total);
    }

    /**
     * Q. Remove an element from Array List using Iterator
     */
    private static void removeArrayListElement() {
        List<Integer> myList = new ArrayList<>();
        myList.add(10);
        myList.add(20);
        myList.add(30);
        myList.add(40);
        Iterator<Integer> iterator = myList.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().equals(10)) {
                iterator.remove();
            }
        }
        myList.forEach(System.out::println);
    }
}
