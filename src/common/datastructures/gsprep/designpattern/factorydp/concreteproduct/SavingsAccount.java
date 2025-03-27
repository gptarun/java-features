package common.datastructures.gsprep.designpattern.factorydp.concreteproduct;

import common.datastructures.gsprep.designpattern.factorydp.product.Account;

// Concrete Account i.e, SavingsAccount or can be CurrentAccount
public class SavingsAccount implements Account {
    @Override
    public void accountType() {
        System.out.println("Savings account");
    }

    @Override
    public void openAccount() {
        System.out.println("Opening savings account");
    }
}
