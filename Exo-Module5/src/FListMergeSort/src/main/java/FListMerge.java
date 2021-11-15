import java.util.Iterator;

public class FListMerge {

    public static int counter;

    /*
     * This method receives an FList and returns a new FList containing the same values but sorted in ascending order.
     *
     */
    public static FList<Integer> mergeSort(FList<Integer> fList){
        FList<Integer> other = FList.nil();
        int[] matrix = new int[fList.length()];
        int inc = 0;
        for(Integer i : fList){
            matrix[inc++] = i;
            counter++;
        }
        sort(matrix);
        for(int x = 0 ; x < matrix.length; x++){
            other = other.cons(matrix[matrix.length-x-1]);
        }
        return other;
    }

    private static void merge(int[] a, int[] aux, int lo, int mid, int hi) {
        int slo = lo;
        int i = lo;
        int j = mid+1;
        while(slo <= hi){
            if(i <= mid && j <= hi){
                if(a[i] < a[j]){
                    aux[slo++] = a[i++];
                }
                else{
                    aux[slo++] = a[j++];
                }
            }
            else if(i <= mid){
                aux[slo++] = a[i++];
            }
            else{
                aux[slo++] = a[j++];
            }
        }
        System.arraycopy(aux,lo,a,lo,hi-lo+1);
    }

    public static void sort(int[] a) {
        mergeSort(a, new int[a.length], 0,a.length-1);
    }

    public static void mergeSort(int[] a, int[] aux, int lo, int hi){
        if(hi - lo > 0){
            int mid = (lo+hi)/2;
            mergeSort(a,aux,lo,mid);
            mergeSort(a,aux,mid+1,hi);
            merge(a,aux,lo,mid,hi);
        }
    }
}