public class ArraySearch {
    /**
     * @param tab is an ordered array of int.
     * @return index of elem or -1
     */
    public static int search(int[] tab, int elem){
        int high = tab.length-1;
        int low = 0;
       while(low <= high){
           int mid = (low+high)/2;
           if(tab[mid] == elem){
               return mid;
           }
           if(tab[mid] > elem){
               high = mid-1;
           }
           if(tab[mid] < elem){
               low = mid+1;
           }
       }
       return -1;
    }

}
