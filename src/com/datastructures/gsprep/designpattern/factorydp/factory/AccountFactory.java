package com.datastructures.gsprep.designpattern.factorydp.factory;

import com.datastructures.gsprep.designpattern.factorydp.product.Account;

// Contains the method declaration to create Savings or Current Account
public interface AccountFactory {
    Account openAccount();
}
