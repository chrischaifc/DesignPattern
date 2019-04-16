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
public class DepositNumberTest {

    //set the state as overDrawnState
    static BusinessAccount businessAccount = new BusinessAccount();
    static State noTransactionFeeState = new NoTransactionFeeState(businessAccount);


    private double input;
    private double expectedBalance;


    //create constructor for data
    public DepositNumberTest(double input, double expectedBalance) {
        this.input = input;
        this.expectedBalance = expectedBalance;
        businessAccount.setBalance(2500);
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {500, 3000},
        });
    }


    @org.junit.Test
    public void transitionState() {
        noTransactionFeeState.deposit(input);
        assertEquals(expectedBalance, businessAccount.getBalance(), 0.01);
    }
}