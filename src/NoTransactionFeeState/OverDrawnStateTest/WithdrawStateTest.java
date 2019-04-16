package NoTransactionFeeState.OverDrawnStateTest;

import com.company.*;

import static org.junit.Assert.assertEquals;

public class WithdrawStateTest {
    //set the state as NoTransactionFeeState
    static BusinessAccount businessAccount = new BusinessAccount();
    static State noTransactionFeeState = new NoTransactionFeeState(businessAccount);
    private String expect;
    private String actual;

    public WithdrawStateTest() {
        businessAccount.setState(noTransactionFeeState);
        businessAccount.setBalance(2500);
    }

    //compare of state, but need to ignore everything after the stateName
    @org.junit.Test
    public void transitionState1() {
        noTransactionFeeState.withdraw(500);
        actual = businessAccount.getState().toString().replaceAll("@[^;]*", "");
        expect = noTransactionFeeState.toString().replaceAll("@[^;]*", "");
        assertEquals(expect, actual);
    }


    @org.junit.Test
    public void transitionState2() {
        State transactionFeeState = new TransactionFeeState(businessAccount);
        noTransactionFeeState.withdraw(600);
        actual = businessAccount.getState().toString().replaceAll("@[^;]*", "");
        expect = transactionFeeState.toString().replaceAll("@[^;]*", "");
        assertEquals(expect, actual);
    }

    @org.junit.Test
    public void transitionState3() {
        State overDrawnState = new OverDrawnState(businessAccount);
        noTransactionFeeState.withdraw(3000);
        actual = businessAccount.getState().toString().replaceAll("@[^;]*", "");
        expect = overDrawnState.toString().replaceAll("@[^;]*", "");
        assertEquals(expect, actual);
    }

    @org.junit.Test
    public void transitionState4() {
        noTransactionFeeState.withdraw(5000);
        actual = businessAccount.getState().toString().replaceAll("@[^;]*", "");
        expect = noTransactionFeeState.toString().replaceAll("@[^;]*", "");
        assertEquals(expect, actual);
    }
}