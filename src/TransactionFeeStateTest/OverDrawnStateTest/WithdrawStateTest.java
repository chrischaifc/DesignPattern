package TransactionFeeStateTest.OverDrawnStateTest;

import com.company.BusinessAccount;
import com.company.OverDrawnState;
import com.company.State;
import com.company.TransactionFeeState;

import static org.junit.Assert.assertEquals;

public class WithdrawStateTest {
    //set the state as TransactionFeeState
    static BusinessAccount businessAccount = new BusinessAccount();
    static State transactionFeeState = new TransactionFeeState(businessAccount);
    private String expect;
    private String actual;

    public WithdrawStateTest() {
        businessAccount.setState(transactionFeeState);
        businessAccount.setBalance(1500);
    }

    //compare of state, but need to ignore everything after the stateName
    @org.junit.Test
    public void transitionState1() {
        transactionFeeState.withdraw(500);
        actual = businessAccount.getState().toString().replaceAll("@[^;]*", "");
        expect = transactionFeeState.toString().replaceAll("@[^;]*", "");
        assertEquals(expect, actual);
    }


    @org.junit.Test
    public void transitionState2() {
        State overDrawnState = new OverDrawnState(businessAccount);
        transactionFeeState.withdraw(2000);
        actual = businessAccount.getState().toString().replaceAll("@[^;]*", "");
        expect = overDrawnState.toString().replaceAll("@[^;]*", "");
        assertEquals(expect, actual);
    }

    @org.junit.Test
    public void transitionState3() {
        transactionFeeState.withdraw(5000);
        actual = businessAccount.getState().toString().replaceAll("@[^;]*", "");
        expect = transactionFeeState.toString().replaceAll("@[^;]*", "");
        assertEquals(expect, actual);
    }
}