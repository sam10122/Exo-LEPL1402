package BinarySearchTests;
import org.junit.Test;
import static org.junit.Assert.*;

public class Tests {
    @Test
    public void test(){
        int[] a = new int[]{1,2,3,4,5};
        int binary = BinarySearch.binarySearch(a,1);
        assertEquals(0,binary);
    }

    @Test
    public void test2(){
        int[] a = new int[]{1,2,3,4,5};
        int binary = BinarySearch.binarySearch(a,5);
        assertEquals(4,binary);
    }

    @Test
    public void test3(){
        int[] a = new int[]{1,2,3,4,5};
        int binary = BinarySearch.binarySearch(a,3);
        assertEquals(2,binary);
    }

    @Test
    public void test4(){
        int[] a = new int[]{1,2,3,4,5};
        int binary = BinarySearch.binarySearch(a,10);
        assertEquals(-1,binary);
    }

    @Test
    public void test5(){
        int[] a = new int[]{1,2,3,4,5};
        int binary = BinarySearch.binarySearch(a,-4);
        assertEquals(-1,binary);
    }
}
