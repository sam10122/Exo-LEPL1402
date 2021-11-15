import org.junit.Assert;
import org.junit.Test;

import java.util.Random;


public class MergeSortedLinkedListTest {

    @Test
    public void test1() {


        MergeSortedLinkedList.Node list1 = generateIncreasingList(1000, 10);
        MergeSortedLinkedList.Node list2 = generateIncreasingList(1000, 10);

        MergeSortedLinkedList.Node list3 =  MergeSortedLinkedList.merge(list1,list2);

        MergeSortedLinkedList.Node current = list3;
        int n = 0;

        while (current.next != null) {
            Assert.assertTrue(current.value <= current.next.value);
            current = current.next;
            n++;
        }
        Assert.assertEquals(19,n);

    }

    public MergeSortedLinkedList.Node generateIncreasingList(int maxValue, int n) {
        Random r = new Random();
        int current = maxValue;
        MergeSortedLinkedList.Node first = null;
        for (int i = 0; i < n; i++) {
            current = current-r.nextInt(10);
            first = new MergeSortedLinkedList.Node(current,first);
        }
        return first;

    }

}
