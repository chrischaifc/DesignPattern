package Test;

import com.company.CodeBookCypher;
import com.company.EncryptionStrategy;
import com.company.SimpleEncryption;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(value = Parameterized.class)
public class CodeBookCypherJunitTest {

    private String input;
    private String expect;

    public CodeBookCypherJunitTest(String input, String expect) {
        this.input = input;
        this.expect = expect;
    }

    @Parameterized.Parameters
    public static Collection<Object> data() {
        return Arrays.asList(new Object[][]{
            {"This is a true statement"," Design Patterns are really useful"},
            {"I love you"," I don't care"}
        });
    }

    @org.junit.Test
    public void simpleEncryption() {
        EncryptionStrategy codeBookCypher = new CodeBookCypher();
        assertEquals(expect,codeBookCypher.encrypt(input));
    }
}