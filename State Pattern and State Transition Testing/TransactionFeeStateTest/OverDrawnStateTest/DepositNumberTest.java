package TransactionFeeStateTest.OverDrawnStateTest;

import com.company.BusinessAccount;
import com.company.State;
import com.company.TransactionFeeState;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(value = Parameterized.class)
public class DepositNumberTest {

    //set the state as overDrawnState
    static BusinessAccount businessAccount = new BusinessAccount();
    static State transactionFeeState = new TransactionFeeState(businessAccount);


    private double input;
    private double expectedBalance;

    //create constructor for data
    public DepositNumberTest(double input, double expectedBalance) {
        this.input = input;
        this.expectedBalance = expectedBalance;
        businessAccount.setBalance(1000);
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {500, 1498},
                {2000, 2998},
        });
    }


    @org.junit.Test
    public void transitionState() {
        transactionFeeState.deposit(input);
        assertEquals(expectedBalance, businessAccount.getBalance(), 0.01);
    }
}