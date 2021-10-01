import java.util.Arrays;
public class LargestSum {

    //première élément de la matrice la sum du subArray
    // puis l'index de début du subArray
    //puis l'index de fin du subArray
    /*
     *    Given the array [-2,1,-3,4,-1,2,1,-5,4]
     *    The contiguous subarray that produces the best result is [4,-1,2,1]
     *    For this array your method should return [6, 3, 6]
     */
    public static int[] maxSubArray(int[] a){
        int max = a[0];
        int begin = 0;
        int end = 0;
        if(negative(a)){
            max = maxIndex(a)[0];
            begin = maxIndex(a)[1];
            end =  maxIndex(a)[1];
        }
        else{
            for(int i = 0; i < a.length; i++){
                if(max < sum(a,i,max)[0]){
                    begin = i;
                    end = sum(a,i,max)[1];
                    max = sum(a,i,max)[0];
                }
            }
        }

        int[] array = new int[]{max,begin,end};
        return array;
    }

    public static int[] sum(int[] a, int index,int max){
        int sum = a[index];
        int[] maxi = new int[2];
        for(int i = index; i < a.length-1; i++){
            sum+= a[i+1];
            if(max < sum){
                max = sum;
                maxi[0] = sum;
                maxi[1] = i+1;
            }
            else{
                maxi[0] = max;
            }
        }
        maxi[0] = max;
        return maxi;
    }

    public static boolean negative(int[] a){
        for(int i = 0; i < a.length; i++){
            if(a[i] > 0){
                return false;
            }
        }
        return true;
    }

    public static int[] maxIndex(int[] a){
        int max = a[0];
        int index = 0;
        int[] matrix = new int[2];
        for(int i = 0; i < a.length; i++){
            if(max < a[i]){
                max = a[i];
                index = i;
            }
        }
        matrix[0] = max;
        matrix[1] = index;
        return matrix;
    }
}
