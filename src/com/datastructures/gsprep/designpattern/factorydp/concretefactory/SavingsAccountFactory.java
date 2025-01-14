package com.datastructures.gsprep.designpattern.factorydp.concretefactory;

import com.datastructures.gsprep.designpattern.factorydp.concreteproduct.SavingsAccount;
import com.datastructures.gsprep.designpattern.factorydp.factory.AccountFactory;
import com.datastructures.gsprep.designpattern.factorydp.product.Account;

public class SavingsAccountFactory implements AccountFactory {
    @Override
    public Account openAccount() {
        return new SavingsAccount();
    }
}
