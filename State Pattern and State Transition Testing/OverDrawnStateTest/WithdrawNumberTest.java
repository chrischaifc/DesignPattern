package OverDrawnStateTest;

import com.company.BusinessAccount;
import com.company.OverDrawnState;
import com.company.State;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(value = Parameterized.class)
public class WithdrawNumberTest {

    //set the state as overDrawnState
    BusinessAccount businessAccount = new BusinessAccount();
    OverDrawnState overDrawnState = new OverDrawnState(businessAccount);


    private double input;
    private double expectedBalance;
    private State expectedState;

    //create constructor for data
    public WithdrawNumberTest(double input, double expectedBalance) {
        this.input = input;
        this.expectedBalance = expectedBalance;
        businessAccount.setBalance(-500);
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {200, -705},
                {5000, -500}
        });
    }


    @org.junit.Test
    public void transitionState() {

        overDrawnState.withdraw(input);
        assertEquals(expectedBalance, businessAccount.getBalance(), 0.01);
    }
}