package NoTransactionFeeState.OverDrawnStateTest;

import com.company.BusinessAccount;
import com.company.NoTransactionFeeState;
import com.company.State;

import static org.junit.Assert.assertEquals;

public class DepositStateTest {
    //set the state as NoTransactionFeeState
    static BusinessAccount businessAccount = new BusinessAccount();
    static State noTransactionFeeState = new NoTransactionFeeState(businessAccount);
    private String expect;
    private String actual;

    public DepositStateTest() {
        businessAccount.setState(noTransactionFeeState);
        businessAccount.setBalance(2500);
    }

    //compare of state, but need to ignore everything after the stateName
    @org.junit.Test
    public void transitionState1() {
        noTransactionFeeState.deposit(2000);
        actual = businessAccount.getState().toString().replaceAll("@[^;]*", "");
        expect = noTransactionFeeState.toString().replaceAll("@[^;]*", "");
        assertEquals(expect, actual);
    }
}