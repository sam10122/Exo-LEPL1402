import java.util.Arrays;

public class Arrays2D {
    /**
     * Create a matrix from a String.
     *
     * The string if formatted as follow:
     *  - Each row of the matrix is separated by a newline
     *    character \n
     *  - Each element of the rows are separated by a space
     *  For example, the String "0 1\n2 3" represent the
     *  matrix:
     *      [0 1]
     *      [2 3]
     *
     *  @param s The input String
     *  @return The matrix represented by the String
     */
    public static int[][] buildFrom(String s) {
        String[] split = s.split("\n");
        int[][] matrix = new int[split.length][];
        for(int i = 0; i < matrix.length; i++){
            String[] spli = split[i].split(" ");
            int[] mat = new int[spli.length];
            for(int j = 0; j < spli.length; j++){
                mat[j] = Integer.parseInt(spli[j]);
            }
            matrix[i] = mat;
        }
        return matrix;
    }

    /**
     * Compute the sum of the element in a matrix
     *
     * @param matrix The input matrix
     * @return The sum of the element in matrix
     */
    public static int sum(int[][] matrix) {
        int sum = 0;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                sum += matrix[i][j];
            }
        }
        return sum;
    }


    /**
     * Compute the transpose of a matrix
     *
     * @param matrix The input rectangular matrix
     * @return A new matrix that is the transpose of matrix
     */
    public static int[][] transpose(int[][] matrix) {
        int c = 0;
        for (int i = 0; i < matrix.length; i++) {
            c = Math.max(c,matrix[i].length);
        }
        int[][] transposed = new int[c][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                transposed[j][i] = matrix[i][j];
            }

        }
        return transposed;
    }

    /**
     * Compute the product of two matrix
     *
     * @param matrix1 A n x m matrix
     * @param matrix2 A m x k matrix
     * @return The n x k matrix product of matrix1 and matrix2
     */
    public static int[][] product(int[][] matrix1, int[][] matrix2) {
        int[][] matrix3 = new int[matrix1.length][matrix2[0].length];
        for(int x = 0; x < matrix1.length; x++){
            for(int i = 0; i < matrix2[0].length; i++){
                for(int j = 0; j < matrix2.length; j++){
                    matrix3[x][i] += matrix1[x][j] * matrix2[j][i];
                }
            }
        }
        return matrix3;
    }
}
