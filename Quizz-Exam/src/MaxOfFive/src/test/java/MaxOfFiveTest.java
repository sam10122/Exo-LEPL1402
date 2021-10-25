import org.junit.Assert;
import org.junit.Test;

public class MaxOfFiveTest {

    // A source that gives you the numbers 3,4,5,1,45,3,5,...
    static class MyNumberSource implements MaxOfFive.NumberSource {
        static int[] numbers=new int[] {3,4,5,1,7,3,10,2,6,2,5,3,8,1,5,9};
        int pos=0;

        @Override
        public int getNextNumber() {
            return numbers[pos++];
        }
    }

    @Test
    public void test() {
        MaxOfFive m=new MaxOfFive(new MyNumberSource());

        Assert.assertEquals(7,m.getNextMaximum());
        Assert.assertEquals(7,m.getNextMaximum());
        Assert.assertEquals(10,m.getNextMaximum());
        Assert.assertEquals(10,m.getNextMaximum());
        Assert.assertEquals(10,m.getNextMaximum());
        Assert.assertEquals(10,m.getNextMaximum());
        Assert.assertEquals(10,m.getNextMaximum());
        Assert.assertEquals(6,m.getNextMaximum());
        Assert.assertEquals(8,m.getNextMaximum());
        Assert.assertEquals(8,m.getNextMaximum());

    }
}
