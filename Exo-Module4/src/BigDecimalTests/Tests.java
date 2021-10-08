package BigDecimalTests;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class Tests {
    @Test
    public void test(){
        String s = "0123456789";
        char[] c = s.toCharArray();
        int off = 0;
        int len = c.length;
        long entier = BigDecimal.parseExp(c,off,len);
        assertEquals(123456789,entier);
    }

    @Test
    public void test2(){
        String s = "-123456789";
        char[] c = s.toCharArray();
        int off = 0;
        int len = c.length;
        long entier = BigDecimal.parseExp(c,off,len);
        assertEquals(123456789,entier);
    }

    @Test
    public void test3(){
        String s = "0-12345";
        char[] c = s.toCharArray();
        int off = 0;
        int len = c.length;
        long entier = BigDecimal.parseExp(c,off,len);
        assertEquals(-12345,entier);
    }

    @Test
    public void test4(){
        String essaie = "1.23E-2";
        char[] c = essaie.toCharArray();
        int off = 4;
        int len = 3;
        long entier = BigDecimal.parseExp(c,off,len);
        assertEquals(-2,entier);

    }

    @Test
    public void test5(){
        String essaie = "1E000000000042";
        char[] c = essaie.toCharArray();
        int off = 2;
        int len = 12;
        long entier = BigDecimal.parseExp(c,off,len);
        assertEquals(42,entier);

    }

    @Test
    public void test6(){
        String essaie = "12345678910121314156171819023";
        char[] c = essaie.toCharArray();
        int off = 2;
        int len = c.length;
        boolean vrai = false;
        long entier;
        try{
            entier = BigDecimal.parseExp(c,off,len);
        } catch (NumberFormatException e){
            vrai = true;
            assertTrue(vrai);
        }
    }
}
