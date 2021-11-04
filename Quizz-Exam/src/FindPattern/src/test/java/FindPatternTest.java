import static org.junit.Assert.assertEquals;
import org.junit.Test;


public class FindPatternTest {

    
    @Test
    public void test0() { // pattern not present
        int [] pattern = {1, 2, 5};
        int [] sequence = {4, 3, 2, 3, 1};
        int res = FindPattern.find(pattern, sequence);
        assertEquals(-1, res);
    }

    @Test
    public void test1() { // pattern is present
        int [] pattern = {1, 2, 3};
        int [] sequence = {4, 3, 2, 3, 1};
        int res = FindPattern.find(pattern, sequence);
        assertEquals(2, res);
    }

}
