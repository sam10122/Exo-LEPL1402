import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class MergeSort {

    /**
     * Pre-conditions: a[lo..mid] and a[mid+1..hi] are sorted
     * Post-conditions: a[lo..hi] is sorted
     */
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
    /**
     * Rearranges the array in ascending order, using the natural order
     */
    public static void sort(int[] a) {
        mergeSort(a, new int[a.length], 0,a.length-1);
    }

    //TODO Optionnal additionnal method

    public static void mergeSort(int[] a, int[] aux, int lo, int hi){
        if(hi - lo > 0){
            int mid = (lo+hi)/2;
            mergeSort(a,aux,lo,mid);
            mergeSort(a,aux,mid+1,hi);
            merge(a,aux,lo,mid,hi);
        }
    }

}