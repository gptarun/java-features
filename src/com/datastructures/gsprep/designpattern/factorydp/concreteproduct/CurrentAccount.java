package com.datastructures.gsprep.designpattern.factorydp.concreteproduct;

import com.datastructures.gsprep.designpattern.factorydp.product.Account;

public class CurrentAccount implements Account {
    @Override
    public void accountType() {
        System.out.println("Current Account");
    }

    @Override
    public void openAccount() {
        System.out.println("Opening current account");
    }

    public void checkMaximumLimit() {
        System.out.println("Up to 10,00,000 INR");
    }

}
