package NoTransactionFeeState.OverDrawnStateTest;

import com.company.BusinessAccount;
import com.company.NoTransactionFeeState;
import com.company.State;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(value = Parameterized.class)
public class WithdrawNumberTest {

    //set the state as overDrawnState
    static BusinessAccount businessAccount = new BusinessAccount();
    static State noTransactionFeeState = new NoTransactionFeeState(businessAccount);


    private double input;
    private double expectedBalance;

    //create constructor for data
    public WithdrawNumberTest(double input, double expectedBalance) {
        this.input = input;
        this.expectedBalance = expectedBalance;
        businessAccount.setBalance(2500);
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {500, 2000},
                {600, 1900},
                {3000, -500},
                {5000, 2500}
        });
    }


    @org.junit.Test
    public void transitionState() {

        noTransactionFeeState.withdraw(input);
        assertEquals(expectedBalance, businessAccount.getBalance(), 0.01);
    }
}