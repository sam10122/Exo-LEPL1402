import java.util.Optional;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 *  You can ADD any code you like in this class (new members, new methods, etc.).
 *  You can also add imports.
 */

public class ParallelCounting {
    /**
     * Return the number of values equal to v using a parallel algorithm.
     *
     * @param values an array of numbers
     * @param v the value that you want to count
     * @param nThreads is a value between 1 and values.length
     * @return the number of elements equal to v in values (or 0 if no values are provided)
     *
     * Example: For
     *     values = [4.5f,3.2f,5.0f,6.6f,7.2f,1.5f,3.7f,5.8f,6.0f,9.0f,1.3f,2.3f,4.5f,1.5f]
     * and
     *     v = 4.5
     * the method returns 2 because the value 4.5 appears two times in the array.
     *
     * Try to give all threads more or less the same amount of work!
     */
    public static int parallelCount (Optional<float[]> values, float v, int nThreads) {
        if(values.isPresent()) {
            ExecutorService executor = Executors.newFixedThreadPool(nThreads);
            Future[] f = new Future[nThreads];
            int partition = values.get().length/nThreads;
            for(int i = 0; i < nThreads; i++){
                int from = i*partition;
                int to = (i+1)*partition;
                if(i == nThreads -1){
                    to = values.get().length;
                }
                int finalTo = to;
                f[i] = executor.submit(() -> maxOccur(values.get(),v,from, finalTo));
            }
            int occurence = 0;
            for(Future<Integer> i : f){
                try{
                    occurence += i.get();
                } catch (InterruptedException | ExecutionException e){
                    e.printStackTrace();
                }
            }
            executor.shutdown();
            return occurence;
        }
        else{
            return 0;
        }
    }

    public static int maxOccur(float[] values, float v,int from, int to){
        int occur = 0;
        for(int i = from; i < to; i++){
            if(values[i] == v){
                occur ++;
            }
        }
        return occur;
    }
}