public class FindPattern {

    /**
     * In this task you must find the first occurrence of a pattern in a
     * sequence.
     * This occurrence might also be **in a different order** than in 
     * the pattern.
     * 
     * For example, let:
     *      pattern = [1, 1, 3, 5]
     *      sequence = [3, 1, 2, 5, 1, 3, 1, 5, 1]
     *
     * Starting at index 3, we have the sub-sequence [5, 1, 3, 1] which
     * is the pattern reordered. Thus your method must return 3.
     * Note that the pattern also appears at index 4, but you must
     * return the first occurrence.
     * If the pattern is not in the sequence, you must return -1.
     *
     * @param pattern The pattern to look for
     * @param sequence The sequence to look in. Each element of the sequence is
     *        in the interval [0, 15]
     * @return The index of the first occurrence of the pattern in the
     *         sequence or -1 if the pattern is not in the sequence
     */
    public static int find(int [] pattern, int [] sequence) {
        int index = 0;
        for(int i = 0; i < pattern.length; i++){
            for(int j = 0; j < sequence.length; j++){
                if(pattern[i] == sequence[j]){
                    if((sequence.length-j) >= pattern.length ){
                        if(findHelp(pattern,subArray(sequence,j,j+pattern.length))){
                            return j;
                        }
                    }
                }
            }
        }
        return -1;
    }

    public static int[] subArray(int[] matrix,int index, int end){
        int[] mat = new int[end-index];
        int j = 0;
        for(int i = index; i < end; i++){
            mat[j] = matrix[i];
            j++;
        }
        return mat;
    }

    public static boolean findHelp(int[] pattern, int[] sequence){
        int[] pat = sort(pattern);
        int[] seq = sort(sequence);
        for(int i = 0; i < pat.length; i++){
            if(pat[i] != seq[i]){
                return false;
            }
        }
        return true;
    }

    public static int[] sort(int[] matrix){
        for(int i = 0; i < matrix.length-1; i++){
            for(int j = i+1; j < matrix.length; j++){
                if(matrix[i] > matrix[j]){
                    int swap = matrix[i];
                    matrix[i] = matrix[j];
                    matrix[j] = swap;
                }
            }

        }
        return matrix;
    }


    public static void main(String[] args) {
        int[] ma = new int[]{1,2,3,4,5,6};
        int[] o = new int[]{1,3,3,1,2,2,1,2,3};
        System.out.println(find(ma,o));
    }

}
