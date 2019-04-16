package Test;

import com.company.EncryptionStrategy;
import com.company.SimpleEncryption;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(value = Parameterized.class)
public class SimpleEncryptionJunitTest {

    private String input;
    private String expect;

    public SimpleEncryptionJunitTest(String input, String expect) {
        this.input = input;
        this.expect = expect;
    }

    @Parameterized.Parameters
    public static Collection<Object> data() {
        return Arrays.asList(new Object[][]{
            {"this message is to be encrypted & logged","dthis message is to be encrypted & logge"},
            {"Second message to be encrypted.",".Second message to be encrypted"}
        });
    }

    @org.junit.Test
    public void simpleEncryption() {
        EncryptionStrategy simpleEncryption = new SimpleEncryption();
        assertEquals(expect,simpleEncryption.encrypt(input));
    }
}