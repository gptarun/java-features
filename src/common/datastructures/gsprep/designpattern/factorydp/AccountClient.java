package common.datastructures.gsprep.designpattern.factorydp;

import common.datastructures.gsprep.designpattern.factorydp.concretefactory.CurrentAccountFactory;
import common.datastructures.gsprep.designpattern.factorydp.concretefactory.SavingsAccountFactory;
import common.datastructures.gsprep.designpattern.factorydp.factory.AccountFactory;
import common.datastructures.gsprep.designpattern.factorydp.product.Account;

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
