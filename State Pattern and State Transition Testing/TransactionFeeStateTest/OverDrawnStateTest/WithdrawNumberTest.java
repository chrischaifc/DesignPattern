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
public class WithdrawNumberTest {

    //set the state as overDrawnState
    static BusinessAccount businessAccount = new BusinessAccount();
    static State transactionFeeState = new TransactionFeeState(businessAccount);


    private double input;
    private double expectedBalance;

    //create constructor for data
    public WithdrawNumberTest(double input, double expectedBalance) {
        this.input = input;
        this.expectedBalance = expectedBalance;
        businessAccount.setBalance(1500);
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {500, 998},
                {2000, -502},
                {5000, 1500}
        });
    }


    @org.junit.Test
    public void transitionState() {

        transactionFeeState.withdraw(input);
        assertEquals(expectedBalance, businessAccount.getBalance(), 0.01);
    }
}