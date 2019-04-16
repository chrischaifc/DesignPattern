package Test;

import com.company.EncryptionStrategy;
import com.company.SimpleEncryption;
import com.company.SubstitutionCypher;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(value = Parameterized.class)
public class SubstitutionCypherJunitTest {

    private String input;
    private String expect;

    public SubstitutionCypherJunitTest(String input, String expect) {
        this.input = input;
        this.expect = expect;
    }

    @Parameterized.Parameters
    public static Collection<Object> data() {
        return Arrays.asList(new Object[][]{
            {"this message is to be encrypted & logged","zbcy gqyymaq cy zi nq qholwjzqp & fiaaqp"},
            {"Second message to be encrypted","Sqoihp gqyymaq zi nq qholwjzqp"}
        });
    }

    @org.junit.Test
    public void simpleEncryption() {
        EncryptionStrategy substitutionCypher = new SubstitutionCypher();
        assertEquals(expect,substitutionCypher.encrypt(input));
    }
}