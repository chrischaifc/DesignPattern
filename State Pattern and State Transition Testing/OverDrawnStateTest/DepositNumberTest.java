package OverDrawnStateTest;

import com.company.BusinessAccount;
import com.company.OverDrawnState;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(value = Parameterized.class)
public class DepositNumberTest {

    //set the state as overDrawnState
    static BusinessAccount businessAccount = new BusinessAccount();
    static OverDrawnState overDrawnState = new OverDrawnState(businessAccount);


    private double input;
    private double expectedBalance;


    //create constructor for data
    public DepositNumberTest(double input, double expectedBalance) {
        this.input = input;
        this.expectedBalance = expectedBalance;
        businessAccount.setBalance(-500);
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {200, -305},
                {1000, 495},
                {3000, 2495}
        });
    }


    @org.junit.Test
    public void transitionState() {
        overDrawnState.deposit(input);
        assertEquals(expectedBalance, businessAccount.getBalance(), 0.01);
    }
}