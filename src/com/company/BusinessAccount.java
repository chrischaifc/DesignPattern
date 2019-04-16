package com.company;

public class BusinessAccount {
    public static final double MIN_BALANCE = 2000.00;
    public static final double OVERDRAW_LIMIT = -1000.00;

    public static final double TRANS_FEE_NORMAL = 2.00;
    public static final double TRANS_FEE_OVERDRAW = 5.00;

    public static final String ERR_OVENDRAW_LIMIT_EXCEED =
            "Error: Transaction cannot be processed. " +
                    "Overdraw limit exceeded.";

    private State state;
    private String accountNumber;
    private double balance;

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String State() {
        if (getState() == new OverDrawnState(this))
            return "OverDrawnState";
        else if (getState() == new TransactionFeeState(this))
            return "TransactionFeeState";
        else
            return "NoTransactionFeeState";
    }
}
