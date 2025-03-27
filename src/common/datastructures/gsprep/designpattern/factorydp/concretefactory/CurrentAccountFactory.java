package common.datastructures.gsprep.designpattern.factorydp.concretefactory;

import common.datastructures.gsprep.designpattern.factorydp.concreteproduct.CurrentAccount;
import common.datastructures.gsprep.designpattern.factorydp.factory.AccountFactory;
import common.datastructures.gsprep.designpattern.factorydp.product.Account;

public class CurrentAccountFactory implements AccountFactory {
    @Override
    public Account openAccount() {
        return new CurrentAccount();
    }
}
