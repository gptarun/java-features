package common.datastructures.gsprep.designpattern.factorydp.concretefactory;

import common.datastructures.gsprep.designpattern.factorydp.concreteproduct.SavingsAccount;
import common.datastructures.gsprep.designpattern.factorydp.factory.AccountFactory;
import common.datastructures.gsprep.designpattern.factorydp.product.Account;

public class SavingsAccountFactory implements AccountFactory {
    @Override
    public Account openAccount() {
        return new SavingsAccount();
    }
}
