package OverDrawnStateTest;

import com.company.BusinessAccount;
import com.company.OverDrawnState;
import com.company.State;

import static org.junit.Assert.assertEquals;

public class WithdrawStateTest {
    //set the state as overDrawnState
    static BusinessAccount businessAccount = new BusinessAccount();
    static State overDrawnState = new OverDrawnState(businessAccount);
    private String expect;
    private String actual;

    public WithdrawStateTest() {
        businessAccount.setState(overDrawnState);
        businessAccount.setBalance(-500);
    }

    //compare of state, but need to ignore everything after the stateName
    @org.junit.Test
    public void transitionState1() {
        overDrawnState.withdraw(200);
        actual = businessAccount.getState().toString().replaceAll("@[^;]*", "");
        expect = overDrawnState.toString().replaceAll("@[^;]*", "");
        assertEquals(expect, actual);
    }


    @org.junit.Test
    public void transitionState2() {
        overDrawnState.withdraw(5000);
        actual = businessAccount.getState().toString().replaceAll("@[^;]*", "");
        expect = overDrawnState.toString().replaceAll("@[^;]*", "");
        assertEquals(expect, actual);
    }
}