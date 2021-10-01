public class Fibonacci {

    /*
     * Returns the index-th element of the fibonnaci sequence, computed recursively
     */
    public static int fiboRecursive(int index){
        if(index == 0){
            return 0;
        }
        if(index == 1){
            return 1;
        }
        return fiboRecursive(index -1) + fiboRecursive(index -2);
    }

    /*
     * Returns the index-th element of the fibonnaci sequence, computed iteratively
     */
    public static int fiboIterative(int index){
        if(index == 0){
            return 0;
        }
        if(index == 1){
            return 1;
        }
        else {
            int[] array = new int[index + 1];
            array[0] = 0;
            array[1] = 1;
            for (int i = 2; i < index + 1; i++) {
                array[i] = array[i - 2] + array[i - 1];
            }
            return array[array.length - 1];
        }
    }

}