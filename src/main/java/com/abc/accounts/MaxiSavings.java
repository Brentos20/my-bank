package com.abc.accounts;

/**
 * @project MyBank
 */
public class MaxiSavings extends Account {

    public MaxiSavings(){
        super();
        interestRate = 0.05;
        accrueRate = interestRate/365;
    }

    @Override
    protected void compoundInterest() {

    }

    @Override
    protected void accrueInterest() {

    }

    @Override
    public double interestEarned() {
        double amount = sumTransactions();
        if (amount <= 1000) return amount * 0.02;
        if (amount <= 2000) return 20 + (amount-1000) * 0.05;
        return 70 + (amount-2000) * 0.1;
    }

    @Override
    public String toString() {
        return "Maxi Savings Account";
    }
}
