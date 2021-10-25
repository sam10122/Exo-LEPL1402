import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;


public class BinarySearchTreeLevelTest {

    @Test
    public void test1() {

        BinarySearchTreeLevel t = new BinarySearchTreeLevel();
        t.insert(2);
        t.insert(9);
        t.insert(5);
        t.insert(2);
        t.insert(6);
        t.insert(0);
        t.insert(9);
        t.insert(10);

        //         2       // level 0
        //       /  \
        //      0    9     // level 1
        //          / \
        //         5   10  // level 2
        //          \
        //           6     // level 3


        List<Integer> result = t.getLevel(0);
        List<Integer> answer = Arrays.asList(2);
        Assert.assertEquals(answer,result);

        result = t.getLevel(1);
        answer = Arrays.asList(0,9);
        Assert.assertEquals(answer,result);

        result = t.getLevel(2);
        answer = Arrays.asList(5,10);
        Assert.assertEquals(answer,result);

        result = t.getLevel(3);
        answer = Arrays.asList(6);
        Assert.assertEquals(answer,result);

        result = t.getLevel(4);
        answer = Arrays.asList();
        Assert.assertEquals(answer,result);


    }

}
