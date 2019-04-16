package com.company;

public class TransactionFeeState extends State {


    public TransactionFeeState(BusinessAccount account) {
        super(account);
    }

    public TransactionFeeState(State state) {
        super(state);
    }

    //unique method to setState
    @Override
    public State transitionState() {
        double balance = getContext().getBalance();
        if (balance >= BusinessAccount.MIN_BALANCE)
            getContext().setState(
                    new NoTransactionFeeState(this));
        else if (balance >= BusinessAccount.OVERDRAW_LIMIT && balance < 0)
            getContext().setState(new OverDrawnState(this));

        return getContext().getState();
    }

    //unique method for deposit
    @Override
    public boolean deposit(double amount) {
        double balance = getContext().getBalance();

        getContext().setBalance(balance - BusinessAccount.TRANS_FEE_NORMAL);
        System.out.println("Transaction Fee was charged " +
                "due to account status(TransactionFee)");
        return super.deposit(amount);
    }

    //unique method for withdraw
    @Override
    public boolean withdraw(double amount) {
        double balance = getContext().getBalance();

        if ((balance - BusinessAccount.TRANS_FEE_OVERDRAW - amount)
                > BusinessAccount.OVERDRAW_LIMIT) {
            getContext().setBalance(balance - BusinessAccount.TRANS_FEE_NORMAL);
            System.out.println("Transaction Fee was charged due to " +
                    "account status(TransactionFee)");
            return super.withdraw(amount);
        } else {
            System.out.println(BusinessAccount.ERR_OVENDRAW_LIMIT_EXCEED);
            return false;
        }
    }
}
