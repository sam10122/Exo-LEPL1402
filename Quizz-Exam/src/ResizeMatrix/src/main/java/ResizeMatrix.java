// No imports needed for this task

public class ResizeMatrix {
    // No new methods or class members needed for this task

    /**
     * This method takes a rectangular matrix like
     *          (  1   2   3   4 )
     *          (  5   6   7   8 )
     *          (  9   10  11  12)
     *  and returns a new matrix with the same values as the original
     *  matrix but with one or more empty columns added:
     *          (  1   0   0   2   3   4 )
     *          (  5   0   0   6   7   8 )
     *          (  9   0   0   10  11  12)
     *
     * @param matrix a rectangular matrix represented by a two-dimensional array.
     * @param p the position where the new columns should be inserted.
     * @param n the number of empty columns to insert.
     * @return the new matrix with the inserted columns
     *
     * Matrices are represented as two-dimensional arrays. For, example
     * a matrix with 2 rows and 5 columns is an int[2][5] array.
     *
     * The method inserts "n" new columns before the column with index "p".
     * For example, if p=0 and n=2 that means that two new columns are inserted
     * before the first column. If p=1, it means that the new columns are
     * inserted before the second column, etc.
     * If "p" is greater or equal the number of columns in the matrix,
     * the new columns are added after the last column.
     *
     * You can assume in your solution that
     *     -  p>=0
     *     -  n>=1
     *     -  the matrix has at least 1 row and 1 column
     */
    public static int[][] insertEmptyColumns(int[][] matrix, int p, int n) {
        int[][] other = new int[matrix.length][matrix[0].length+n];
        for(int i = 0; i < matrix.length; i++){
            int iter = 0;
            int number = n;
            for(int j = 0; j < matrix[i].length; j++){
               if(j == p){
                   while(number > 0){
                       other[i][iter] = 0;
                       iter++;
                       number--;
                   }
               }
               other[i][iter] = matrix[i][j];
               iter++;
            }
        }
        return other;
    }
}
