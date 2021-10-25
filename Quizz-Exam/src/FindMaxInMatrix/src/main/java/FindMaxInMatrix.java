// You are allowed to add imports here

import java.util.concurrent.*;

public class FindMaxInMatrix {
    // You are allowed to add methods or class members here

    public static class Result {
        public int row, column;

        public Result(int row, int column) {
            this.row=row;
            this.column=column;
        }
    }

    /**
     * This method finds the position of greatest element in a square matrix.
     * The matrix has only ONE greatest element.
     * Your solution MUST use threads to accelerate the search for the
     * greatest element.
     * The matrix is represented by a two-dimensional array.
     *
     * For example, if the method is called with the following matrix
     *     (1  2  3)
     *     (3  4  5)
     *     (3  0  3)
     * then the result is row=1, column=2 because 5 is the greatest element.
     *
     *
     * @param matrix a rectangular matrix
     * @param nThreads the number of threads to use
     * @return the row and column of the greatest element
     *
     * You can assume in your solution that:
     *    -  nThreads>0
     *    -  nThreads<=the number of rows and the number of columns of the matrix
     *    -  matrix is a square matrix and has at least one element
     *    -  all elements in the matrix are >=0
     *    - You can ignore (i.e. catch) exceptions
     */

    public static Result findMax(int[][] matrix, int nThreads) {
        // TODO
        // Hint: Each row of the matrix could be seen as a "job"
        // for a thread.
        // Hint: In the course and in the quiz, we have seen Futures
        // that have Integer values as result. What would be the result
        // of a Future here?
        ExecutorService executor = Executors.newFixedThreadPool(nThreads);
        Future<Result> f = executor.submit(() -> {
            Result res = new Result(0,0);
            int max = matrix[0][0];
            for(int i = 0; i < matrix.length; i++){
                for(int j = 0; j < matrix[i].length; j++){
                    if(matrix[i][j] > max){
                        max = matrix[i][j];
                        res = new Result(i,j);
                    }
                }
            }
            return res;
        });
        executor.shutdown();
        Result resultat = new Result(0,0);
        try{
            resultat = f.get();
        }catch (InterruptedException | ExecutionException e){
            e.printStackTrace();
        }

         return resultat;
    }
}
