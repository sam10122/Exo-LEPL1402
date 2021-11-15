import java.util.Collections;
import java.util.LinkedList;

/**
 * Question:
 *
 * You are asked to merge two sorted linked list (see the TODO below)
 *
 * Once it is done, copy-paste the complete class in Inginious also with the imports
 *
 *
 * Feel free to add methods or fields in the class but do not modify
 * the signature and behavior of existing code
 *
 */
public class MergeSortedLinkedList {

    static Node node;
    /**
     * You receive two linked list containing elements in increasing order
     * You are asked to return a new linked list that contains the
     * elements of both linkedlist in increasing order.
     * The previous linkedList should remain unchanged
     *
     * The complexity of your method should be in O(n+m)
     * where n = size of list1, m = size of list2
     * @param list1 the first list containing elements in increasing order
     * @param list2 the second list containing elemennt in increasiung order
     * @return a list that contains the elements of list1 and list2 in increasing order
     */
    public static Node merge(Node list1, Node list2) {
        LinkedList<Integer> list = new LinkedList<>();
        while(list1.next != null){
            list.add(list1.value);
            list1 = list1.next;
        }
        list.add(list1.value);

        while(list2.next != null){
            list.add(list2.value);
            list2 = list2.next;
        }
        list.add(list2.value);

        Collections.sort(list,(a,b) -> a-b);

        return list(list);
    }


    static class Node {

        int value;
        Node next;

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }

    }

    public static Node list(LinkedList<Integer> value){
       if(value.size() == 0){
           return node;
       }
       return node = new Node(value.remove(0),list(value));
    }


}
