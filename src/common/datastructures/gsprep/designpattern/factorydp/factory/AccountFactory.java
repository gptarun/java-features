package common.datastructures.gsprep.designpattern.factorydp.factory;

import common.datastructures.gsprep.designpattern.factorydp.product.Account;

// Contains the method declaration to create Savings or Current Account
public interface AccountFactory {
    Account openAccount();
}
