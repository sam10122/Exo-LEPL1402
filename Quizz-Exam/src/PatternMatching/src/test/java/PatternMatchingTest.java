import org.junit.Test;

import static org.junit.Assert.*;
import java.util.Random;

public class PatternMatchingTest {

    @Test
    public void test1() {
        assertEquals(3, PatternMatching.find("Hello", "abcHello"));
        assertEquals(-1, PatternMatching.find("hello", "abcHello"));
        assertEquals(-1, PatternMatching.find("Hello", "abcHell"));
        assertEquals(0, PatternMatching.find("Hello", "HelloHelloHello"));
        assertEquals(4, PatternMatching.find("Hello", "elloHelloHello"));
    }


}
