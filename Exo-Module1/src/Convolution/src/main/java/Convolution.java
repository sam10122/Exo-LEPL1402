public class Convolution  {

    /**
     *
     * @param input is a n1 x m1 non-null rectangular matrix with at least 3 rows and 3 cols
     * @param kernel is a 3 x 3 square matrix
     * @return a matrix M with dimension (n1-2) x (m1-2) with
     *         M[i][j] = sum_{k in 0..2, l in 0..2} input[i+k][j+l]*kernel[k][l]
     *
     *
     * For example, if the input matrix is 
     * [[1,2,1,5,6],
     *  [3,1,5,7,2],
     *  [1,4,5,2,1],
     *  [6,7,1,0,3]]
     *
     *  and the kernel is
     *z
     *  [[0,0,0],
     *   [0,1,1],
     *   [0,0,0]]
     *
     *   then the ouput should be
     *
     *   [[6,12,9],
     *    [9,7,3]]
     */
    public static int [][] convolution(int [][] input, int [][] kernel) {
        int[][] matrix = new int[input.length-2][input[0].length-2];
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                if(check(input,i)){
                    int[][] newInput = row(input,i);
                    matrix[i][j] = helpConv(col(newInput,j),kernel);
                }
            }
        }
        return matrix;
    }

    public static int helpConv(int[][] input, int[][] kernel){
        int[] matrix = new int[1];
        for(int x = 0; x < 1; x++){
            for(int i = 0; i < kernel.length; i++){
                for(int j = 0; j < kernel.length; j++){
                    matrix[x] += input[j][i]*kernel[j][i];
                }
            }
        }
        return matrix[0];
    }

    public static int[][] col(int[][] input, int index){
        int[][] matrix = new int[3][3];
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix.length; j++){
                matrix[i][j] = input[i][j+index];
            }
        }
        return matrix;
    }

    public static int[][] row(int[][] input,int index){
        int[][] newInput = new int[3][input[0].length];
        int j = 0;
        for(int i = index; i < 3+index; i++){
            newInput[j] = input[i];
            j++;
        }
        return newInput;
    }

    public static boolean check(int[][] input,int index){
        if(input.length-index >= 3){
            return true;
        }
        return false;
    }
}

