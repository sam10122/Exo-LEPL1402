package MaximumTests;
import org.junit.Test;
import static org.junit.Assert.*;

public class Tests {
    @Test
    public void test() {
        int [] a = new int[]{1,2,3,4,5,6,7}; // your test array
        int max = Maximum.maximum(a); // find the maximum
        assertEquals(7,max);

    }

    @Test
    public void test2(){
        int[] a = new int[]{7,6,5,4,3,2,1};
        int max = Maximum.maximum(a);
        assertEquals(7,max);
    }

    @Test
    public void test3(){
        int[] a = new int[]{-1,-2,-3,-5,-7};
        int max = Maximum.maximum(a);
        assertEquals(-1,max);
    }

    @Test
    public void test4(){
        int[] a = new int[]{-1,2,-3,-4,10};
        int max = Maximum.maximum(a);
        assertEquals(10,max);
    }


    @Test
    public void test5(){
        int[] a = new int[]{1};
        int max = Maximum.maximum(a);
        assertEquals(1,max);
    }

}
