package com.abc.accounts;

import com.abc.Transaction;
import com.abc.util.DateProvider;

import java.time.LocalDateTime;

import static java.time.temporal.ChronoUnit.DAYS;

/**
 * @project MyBank
 */
public class MaxiSavings extends Account {

    private double secIntRate;
    private double secAccrueRate;

    public MaxiSavings(){
        super();
        init();
    }

    public MaxiSavings(LocalDateTime date){
        super(date);
        init();
    }

    private void init(){
        intRate = 0.05;
        accrueRate = intRate /365;
        secIntRate = 0.001;
        secAccrueRate = secIntRate/365;
    }

    @Override
    protected void compoundInterest() {

        boolean hadWithdrawal = hadWithdrawalInPast(10);
        balance += (hadWithdrawal) ? (balance * secIntRate) : (balance * intRate);
    }

    @Override
    protected void accrueInterest() {
        intRate += accrueRate;
        secIntRate += secAccrueRate;
    }

    boolean hadWithdrawalInPast(int numbOfDays) {
        LocalDateTime today = this.getDateOfLastUpdate();
        return transactions.stream()
                .anyMatch(t -> (t.getTransactionType() == 0) && (DAYS.between(t.getTransactionDate(), today)<=numbOfDays));
    }

    public double getSecIntRate() {
        return secIntRate;
    }

    public double getSecAccrueRate() {
        return secAccrueRate;
    }

    @Override
    public String toString() {
        return "Maxi Savings Account";
    }
}
