package TransactionFeeStateTest.OverDrawnStateTest;

import com.company.BusinessAccount;
import com.company.NoTransactionFeeState;
import com.company.State;
import com.company.TransactionFeeState;

import static org.junit.Assert.assertEquals;

public class DepositStateTest {
    //set the state as TransactionFeeState
    static BusinessAccount businessAccount = new BusinessAccount();
    static State transactionFeeState = new TransactionFeeState(businessAccount);
    private String expect;
    private String actual;


    public DepositStateTest() {
        businessAccount.setState(transactionFeeState);
        businessAccount.setBalance(1000);
    }

    //compare of state, but need to ignore everything after the stateName
    @org.junit.Test
    public void transitionState1() {
        State noTransactionFeeState = new NoTransactionFeeState(businessAccount);
        transactionFeeState.deposit(2000);
        actual = businessAccount.getState().toString().replaceAll("@[^;]*", "");
        expect = noTransactionFeeState.toString().replaceAll("@[^;]*", "");
        assertEquals(expect, actual);
    }


    @org.junit.Test
    public void transitionState2() {
        transactionFeeState.deposit(500);
        actual = businessAccount.getState().toString().replaceAll("@[^;]*", "");
        expect = transactionFeeState.toString().replaceAll("@[^;]*", "");
        assertEquals(expect, actual);
    }
}