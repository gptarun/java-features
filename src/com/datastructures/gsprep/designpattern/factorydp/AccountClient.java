package com.datastructures.gsprep.designpattern.factorydp;

import com.datastructures.gsprep.designpattern.factorydp.concretefactory.CurrentAccountFactory;
import com.datastructures.gsprep.designpattern.factorydp.concretefactory.SavingsAccountFactory;
import com.datastructures.gsprep.designpattern.factorydp.factory.AccountFactory;
import com.datastructures.gsprep.designpattern.factorydp.product.Account;

public class AccountClient {
    public static void main(String[] args) {
        AccountFactory accountFactory = new SavingsAccountFactory();
        Account savingsAccount = accountFactory.openAccount();
        savingsAccount.accountType();
        savingsAccount.openAccount();

        accountFactory = new CurrentAccountFactory();
        Account currentAccount = accountFactory.openAccount();
        currentAccount.openAccount();
        currentAccount.accountType();
    }
}
