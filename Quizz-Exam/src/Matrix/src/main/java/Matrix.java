/**
 * Question:
 *
 * You are asked to implement the Matrix abstract data-type below
 *
 * Once it is done, copy-paste the complete class in Inginious also with the imports
 *
 *
 * Feel free to add inner-class, methods or fields in the class
 * but do not modify the signature of existing methods
 *
 */
public interface Matrix {


    /**
     * Factory: Creates a n x m integer matrix of zeros
     * @param n the number of row
     * @param m the number of columns
     */
    public static Matrix create(int n, int m) {
       HelpMatrix matrix = new HelpMatrix(n,m);
       return matrix;
    }

    /**
     * Set the value v at row r, column j
     * @param r the row
     * @param c the column
     */
    void set(int r, int c, int  v);


    /**
     * Get the value v at row r, column c
     * @param r the row
     * @param c the column
     */
    public int get(int r, int c);

    /**
     * Return a new version of the matrix with the specified row deleted
     * The current matrix is unchanged
     * @param r the row to delete
     */
    public Matrix deleteRow(int r);

    /**
     * Return a new version of the matrix with the specified column deleted
     * The current matrix is unchanged
     * @param c the column to delete
     */
    public Matrix deleteColumn(int c);


    public class HelpMatrix implements Matrix{

        Integer[][] matrix;

        public HelpMatrix(int n,int m){
            matrix = new Integer[n][m];
        }

        @Override
        public void set(int r, int c, int v) {
            matrix[r][c] = v;
        }

        @Override
        public int get(int r, int c) {
            return matrix[r][c];
        }

        @Override
        public Matrix deleteRow(int r) {
            HelpMatrix other = new HelpMatrix(0,0);
            Integer[][] mat = new Integer[matrix.length-1][matrix[0].length];
            for(int i = 0; i < matrix.length-1; i++){
                if(i >= r){
                    for(int j = 0; j < matrix[i].length; j++){
                        mat[i][j] = matrix[i+1][j];
                    }
                }
                else{
                    for(int j = 0; j < matrix[i].length; j++){
                        mat[i][j] = matrix[i][j];
                    }
                }
            }
            other.matrix = mat;
            return other;
        }

        @Override
        public Matrix deleteColumn(int c) {
            HelpMatrix other = new HelpMatrix(0,0);
            Integer[][] mat = new Integer[matrix.length][matrix[0].length-1];
            for(int i = 0; i < matrix.length; i++){
                for(int j = 0; j < matrix[i].length-1; j++){
                    if(j >= c){
                        mat[i][j] = matrix[i][j+1];
                    }
                    else {
                        mat[i][j] = matrix[i][j];
                    }
                }
            }
            other.matrix = mat;
            return other;

        }
    }
}




