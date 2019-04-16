package Test;

import com.company.CaesarCypher;
import com.company.EncryptionStrategy;
import com.company.SimpleEncryption;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(value = Parameterized.class)
public class CaesarCypherJunitTest {

    private String input;
    private String expect;

    public CaesarCypherJunitTest(String input, String expect) {
        this.input = input;
        this.expect = expect;
    }

    @Parameterized.Parameters
    public static Collection<Object> data() {
        return Arrays.asList(new Object[][]{
            {"this message is to be encrypted & logged","uijt nfttbhf jt up cf fodszqufe & mphhfe"},
            {"Second message to be encrypted.","Sfdpoe nfttbhf up cf fodszqufe."}
        });
    }

    @org.junit.Test
    public void simpleEncryption() {
        EncryptionStrategy caesarCypher = new CaesarCypher();
        assertEquals(expect,caesarCypher.encrypt(input));
    }
}