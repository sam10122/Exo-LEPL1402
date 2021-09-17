import java.util.*;

public class MakeMistake {

    public static void main(String[] args) {
        //ArrayIndexOutOfBoundsException
        int[] array = new int[2];
        array[10] = 4;


        //NullPointerException
        String u = null;
        String[] x = new String[u.length()];
        x[0] = "je";


        //ConcurrentModificationException
        List<Integer> error = new ArrayList<Integer>();
        error.add(1);
        error.add(2);
        error.add(3);
        error.add(4);
        error.add(42);
        for (Integer i : error) {
            if(i.equals(3)){
                error.remove(i);
            }
        }
    }
}
