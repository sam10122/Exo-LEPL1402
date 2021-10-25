// You are allowed to add imports here

import java.util.Iterator;
import java.util.LinkedList;

/**
 * This class takes a data source that represents sequence of numbers.
 * Everytime getNextNumber() of the data source is called, it returns
 * the next number of the sequence. For example, you could the sequence:
 *     8,4,5,1,7,3,10,2,...
 *
 * Your job is to implement the method getNextMaximum(). When the method
 * is called for the first time, it should return the maximum of the first
 * five values of the sequence from the source:
 *      8    (because 8 is the maximum of 8,4,5,1,7)
 * When the method getNextMaximum() is called again, it gets the next value
 * from the sequence, and calculates again the maximum of the five values:
 *      7    (because 7 is the maximum of 4,5,1,7,3)
 *  And again:
 *      10   (because 10 is the maximum of 5,1,7,3,10)
 *  And again:
 *      10   (because 10 is the maximum of 1,7,3,10,2)
 *  etc.
 */

public class MaxOfFive {
    // You are allowed to add methods or class members here
    private final NumberSource source;
    LinkedList<Integer> list = new LinkedList<>();



    // A source of an infinite sequence of numbers
    public interface NumberSource {
        // gets the next number from the source
        int getNextNumber();
    }

    public MaxOfFive(NumberSource source) {
        this.source=source;
    }

    /**
     * @return the next maximum of five values from the data source
     */
    public int getNextMaximum() {
        int max = 0;
        for(int i = 0; i < 5; i ++){
            try{
                list.add(source.getNextNumber());
            } catch (ArrayIndexOutOfBoundsException e){
                break;
            }
        }
        Iterator<Integer> ite = list.iterator();
        for(int j = 0; j < 5; j++){
            max = Math.max(max,ite.next());
        }
        list.remove(0);
        return max;
    }
}
