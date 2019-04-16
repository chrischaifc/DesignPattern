package OverDrawnStateTest;

import com.company.*;

import static org.junit.Assert.assertEquals;

public class DepositStateTest {
    //set the state as overDrawnState
    static BusinessAccount businessAccount = new BusinessAccount();
    static State overDrawnState = new OverDrawnState(businessAccount);
    private String expect;
    private String actual;


    public DepositStateTest() {
        businessAccount.setState(overDrawnState);
        businessAccount.setBalance(-500);
    }

    //compare of state, but need to ignore everything after the stateName
    @org.junit.Test
    public void transitionState1() {
        overDrawnState.deposit(200);
        actual = businessAccount.getState().toString().replaceAll("@[^;]*", "");
        expect = overDrawnState.toString().replaceAll("@[^;]*", "");
        assertEquals(expect, actual);
    }


    @org.junit.Test
    public void transitionState2() {
        State transactionFeeState = new TransactionFeeState(businessAccount);
        overDrawnState.deposit(1000);
        actual = businessAccount.getState().toString().replaceAll("@[^;]*", "");
        expect = transactionFeeState.toString().replaceAll("@[^;]*", "");
        assertEquals(expect, actual);
    }

    @org.junit.Test
    public void transitionState3() {
        State noTransactionFeeState = new NoTransactionFeeState(businessAccount);
        overDrawnState.deposit(3000);
        actual = businessAccount.getState().toString().replaceAll("@[^;]*", "");
        expect = noTransactionFeeState.toString().replaceAll("@[^;]*", "");
        assertEquals(expect, actual);
    }
}