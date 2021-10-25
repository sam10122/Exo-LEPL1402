import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MatrixTest {


    @Test
    public void test1() {

        // 0  1  2  3
        // 4  5  6  7
        // 8  9 10 11
        Matrix m = Matrix.create(3,4);
        int v = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                m.set(i,j,v);
                v++;
            }
        }

        Assert.assertEquals(10,m.get(2,2));
        Assert.assertEquals(3,m.get(0,3));


        // 0  2  3
        // 4  6  7
        // 8 10 11
        Matrix mp = m.deleteColumn(1);
        Assert.assertEquals(6,mp.get(1,1));
        Assert.assertEquals(10,mp.get(2,1));
        // verify the previous one is not modified
        Assert.assertEquals(10,m.get(2,2));
        Assert.assertEquals(3,m.get(0,3));

        // 0  2  3
        // 8 10 11
        Matrix mpp = mp.deleteRow(1);
        Assert.assertEquals(10,mpp.get(1,1));
        Assert.assertEquals(3,mp.get(0,2));
        // verify the previous one is not modified
        Assert.assertEquals(6,mp.get(1,1));
        Assert.assertEquals(10,mp.get(2,1));
    }


}
