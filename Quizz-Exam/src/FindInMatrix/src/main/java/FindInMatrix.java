import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

// You are allowed to add imports here

public class FindInMatrix {
    // You are allowed to add methods or class members, but do not change the signature
    // of the existing methods and class members.

    public static class Result {
        int row;
        List<Integer> columns;
    }

    /**
     * This method finds the row that contains the most number of occurrences of a
     * certain value and returns the row index of that row and the column indexes
     * (in increasing order) where the value occurs in that row.
     * The matrix is represented by a two-dimensional array.
     *
     * Example: if the method is called with the value "3" and the following matrix
     *     (1   3  2  -4)          // <- there is a "3" in column 1
     *     (-3  4  5  -2)
     *     (3   0  3   2)          // <- there is a "3" in column 0 and column 2
     * then the result of the search is:
     *      row=2 , columns=[0,2]
     * because row 2 contains the most number of occurrences of "3" (in columns 0 and 2).
     *
     * Your solution MUST use a thread pool to accelerate the operation.
     *
     * @param matrix a rectangular matrix
     * @param value the value to find
     * @param poolSize the thread pool size
     * @return the result of the search
     *
     * You can assume that there is exactly one row in the matrix with the
     * most number of occurrences of the value.
     * Catch exceptions and ignore them.
     */

    public static Result findValue(int[][] matrix, int value, int poolSize) {
        // TODO
        // Hint:
        // One row of the matrix -> One future.
        Result obj = new Result();
        ExecutorService executor = Executors.newFixedThreadPool(poolSize);
        Future<Integer> occur = executor.submit(() -> resultRow(matrix,value));
        Future<Result> col = executor.submit(() ->{
            Result other = new Result();
            other.columns = new LinkedList<>();
            int[] mat = resultColums(matrix,resultRow(matrix,value),value);
            for(int i = 0; i < mat.length; i++){
                other.columns.add(mat[i]);
            }
            return other;
        });
        try{
            obj.row = occur.get();
            obj.columns = col.get().columns;
        }catch (InterruptedException | ExecutionException e){
            e.printStackTrace();
        }
        executor.shutdown();

         return obj;
    }

    public static int resultRow(int[][] matrix, int value){
        int first = 0;
        int indice = 0;
        for(int i = 0; i < matrix.length; i++){
            int second = 0;
            for(int j = 0 ; j < matrix[i].length; j++){
                if(matrix[i][j] == value){
                    second++;
                }
                if(second > first){
                    first = second;
                    indice = i;
                }
            }
        }
        return indice;
    }

    public static int[] resultColums(int[][] matrix, int indice, int value){
        int[] mat = matrix[indice];
        LinkedList<Integer> list = new LinkedList<>();
        for(int i = 0; i < mat.length; i++){
            if(mat[i] == value){
                list.add(i);
            }
        }
        int[] array = new int[list.size()];
        int j = 0;
        Iterator<Integer> ite = list.iterator();
        while(ite.hasNext()){
            array[j] = ite.next();
            j++;
        }
        return array;
    }
}
