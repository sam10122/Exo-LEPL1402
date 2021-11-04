import java.util.Collections;
import java.util.LinkedList;

/**
 * Question:
 *
 * You are asked to merge two sorted linked lists (see the TODO below) but you need to
 * keep only one node for each distinct value
 *
 * Once it is done, copy-paste the complete class in Inginious, including the imports
 *
 *
 * Feel free to add methods or fields in the class, but do not modify
 * the signature and behavior of existing code
 *
 */
public class MergeSortedLinkedListDuplicate {
    static Node node = null;

    /**
     * You receive two linked lists containing elements in increasing order.
     * You are asked to return a new linked list that contains the
     * elements of both linked lists in increasing order but without duplicates.
     * The input linked lists must remain unchanged.
     * Moreover, the final linkedList must not contain duplicate values
     * That is, instead of 1-1-2-5, you must return 1-2-5.
     *
     * The complexity of your method must be in O(n+m)
     * where n = size of list1, m = size of list2
     * @param list1 the first list containing elements in increasing order
     * @param list2 the second list containing elements in increasing order
     * @return a list that contains the elements of list1 and list2 in increasing order without duplicates
     */
    public static Node merge(Node list1, Node list2) {
        LinkedList<Integer> list = new LinkedList<>();
        LinkedList<Integer> list3 = new LinkedList<>();
        Node node1 = null;
        if (list1 == null) {
            list3 = link(list, list2);
            node1 = fusion(list3);
            node1.next = null;
            return node1;
        }
        if (list2 == null) {
            list3 = link(list, list1);
            node1 = fusion(list3);
            node1.next = null;
            return node1;
        }
        else {
            list3 = link(list, list1);
            LinkedList<Integer> list4 = link(list3, list2);
            Collections.sort(list4, (a, b) -> (a - b));
            return fusion(list4);
        }
    }

    public static LinkedList<Integer> link(LinkedList<Integer> list,Node list1){
        while(list1.next != null){
            if(!list.contains(list1.value)){
                list.add(list1.value);
                list1 = list1.next;
            }
            else{
                list1 = list1.next;
            }
        }
        if(!list.contains(list1.value)){
            list.add(list1.value);
        }
        return list;
    }

    public static Node fusion(LinkedList<Integer> list){
        if(list.size() == 0){
            return node;
        }
        return node = new Node(list.remove(0),fusion(list));
    }






    static class Node {

        int value;
        Node next;
        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }

    }
}
