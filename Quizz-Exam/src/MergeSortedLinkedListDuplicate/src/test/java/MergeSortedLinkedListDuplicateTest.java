import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;



public class MergeSortedLinkedListDuplicateTest {

    @Test
    public void test1() {

        MergeSortedLinkedListDuplicate.Node list1 = null;
        list1 = new MergeSortedLinkedListDuplicate.Node(7, list1);
        list1 = new MergeSortedLinkedListDuplicate.Node(3, list1);
        list1 = new MergeSortedLinkedListDuplicate.Node(1, list1);
        list1 = new MergeSortedLinkedListDuplicate.Node(1, list1);

        MergeSortedLinkedListDuplicate.Node list2 = null;
        list2 = new MergeSortedLinkedListDuplicate.Node(7, list2);
        list2 = new MergeSortedLinkedListDuplicate.Node(7, list2);
        list2 = new MergeSortedLinkedListDuplicate.Node(4, list2);
        list2 = new MergeSortedLinkedListDuplicate.Node(2, list2);
        list2 = new MergeSortedLinkedListDuplicate.Node(2, list2);

        MergeSortedLinkedListDuplicate.Node res = null;
        res = new MergeSortedLinkedListDuplicate.Node(7, res);
        res = new MergeSortedLinkedListDuplicate.Node(4, res);
        res = new MergeSortedLinkedListDuplicate.Node(3, res);
        res = new MergeSortedLinkedListDuplicate.Node(2, res);
        res = new MergeSortedLinkedListDuplicate.Node(1, res);


        MergeSortedLinkedListDuplicate.Node list3 =  MergeSortedLinkedListDuplicate.merge(list1,list2);

        MergeSortedLinkedListDuplicate.Node current = list3;
        while (current != null) {
            assertEquals(res.value, current.value);
            current = current.next;
            res = res.next;
        }
        assertNull(res);
    }

    @Test
    public void test2() {

        MergeSortedLinkedListDuplicate.Node list1 = null;
        list1 = new MergeSortedLinkedListDuplicate.Node(1, list1);
        list1 = new MergeSortedLinkedListDuplicate.Node(1, list1);
        list1 = new MergeSortedLinkedListDuplicate.Node(1, list1);

        MergeSortedLinkedListDuplicate.Node list2 =  MergeSortedLinkedListDuplicate.merge(list1, null);
        assertEquals(1, list2.value);
        assertNull(list2.next);

        MergeSortedLinkedListDuplicate.Node list3 =  MergeSortedLinkedListDuplicate.merge(null, list1);
        assertEquals(1, list3.value);
        assertNull(list3.next);
    }

}
