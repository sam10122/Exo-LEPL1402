import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;


/**
 * Question:
 *
 * You are asked to clean a increasing sorted linked List (see the TODO below)
 * Cleaning the linkedList means keeping only one occurrence of each value.
 *
 * For instance cleaning: 3,3,3,4,5,5,6,6,6,7,9,9,9,9,10,10
 * Gives: 3,4,5,6,7,9,10
 *
 * Your algorithm should execute in Theta(n)
 * where n are the number of elements in the original list
 *
 */
public class CleanLinkedList {

    Node first = null;
    Node last = null;

    public void add(int v) {
       Node node = first;
       first = new Node(v,null);
       first.next = node;
       last = new Node(v,null);
    }

    public void add(int ... values) {
        for (int v: values) {
            add(v);
        }
    }


    /**
     * Given the increasingly sorted list, it removes the duplicates
     * @return an increasingly sorted list containing the same set
     *         of elements as list but without duplicates.
     */
    public CleanLinkedList clean() {
        LinkedList<Integer> other = new LinkedList<>();
        while(first != null){
            other.add(first.v);
            first = first.next;
        }
        Collections.sort(other,(a,b) -> a-b);
        for(Integer i : other){
            this.add(i);
        }
        CleanLinkedList list = new CleanLinkedList();
        int elem = first.v;
        while(first != null){
            if(first.next == null){
                list.add(elem);
            }
            if(elem != first.v){
               list.add(elem);
               elem = first.v;
               first = first.next;
            }
            else {
                first = first.next;
            }
        }
        return list;
    }


    class Node {
        int v;
        Node next;
        Node(int v, Node next) {
            this.v = v;
            this.next = next;
        }
    }
}

