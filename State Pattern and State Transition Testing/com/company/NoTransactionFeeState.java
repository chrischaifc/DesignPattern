package com.company;

public class NoTransactionFeeState extends State {

    public NoTransactionFeeState(BusinessAccount account) {
        super(account);
    }

    public NoTransactionFeeState(State state) {
        super(state);
    }

    //unique method to setState
    @Override
    public State transitionState() {
        double balance = getContext().getBalance();
        if (balance >= BusinessAccount.OVERDRAW_LIMIT && balance < 0)
            getContext().setState(
                    new OverDrawnState(this));
        else if (balance >= 0 && balance < BusinessAccount.MIN_BALANCE)
            getContext().setState(new TransactionFeeState(this));

        return getContext().getState();
    }

    //unique method for withdraw
    @Override
    public boolean withdraw(double amount) {
        double balance = getContext().getBalance();

        if ((balance - BusinessAccount.TRANS_FEE_OVERDRAW - amount)
                > BusinessAccount.OVERDRAW_LIMIT) {
            System.out.println("No transaction fee was charged " +
                    "due to account status(NoTransFeeState)");
            return super.withdraw(amount);

        } else {
            System.out.println(BusinessAccount.ERR_OVENDRAW_LIMIT_EXCEED);
            return false;
        }

    }

    //unique method for deposit
    @Override
    public boolean deposit(double amount) {
        System.out.println("No transaction fee was charged due to " +
                "due to account status(NoTransFeeState)");
        return super.deposit(amount);
    }
}
