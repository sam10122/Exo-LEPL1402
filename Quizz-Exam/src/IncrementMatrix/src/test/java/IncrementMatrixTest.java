import org.junit.Assert;
import org.junit.Test;

import java.util.Random;
import java.util.concurrent.ExecutionException;

public class IncrementMatrixTest {

    private final int[][] smallMatrix = new int[][] {
            { 1, 2,  3,  4, 7 },
            { 5, 0,  4,  8, 2 },
            { 9, 10, 5,  6, 2 },
            { 0, 3,  12, 2, 9 },
            { 1, 1,  7,  8, 9 }
    };

    private final int[][] smallResult = new int[][] {
            { 2, 3,  4,  5, 8 },
            { 6, 1,  5,  9, 3 },
            { 10,11, 6,  7, 3 },
            { 1, 4,  13, 3,10 },
            { 2, 2,  8,  9,10 }
    };

    @Test
    public void testSingleThread(){
        int[][] result=IncrementMatrix.increment(smallMatrix,1);
        Assert.assertArrayEquals(smallResult, result);
    }

    @Test
    public void testTwoThreads(){
        int[][] result=IncrementMatrix.increment(smallMatrix,2);
        Assert.assertArrayEquals(smallResult, result);
    }

    @Test
    public void testRandomLargeMatrix(){
        final int matrixSize=1001;

        // try different numbers of threads
        for(int numThreads=1;numThreads<=matrixSize;numThreads+=100) {
            // create large matrix
            int[][] inputMatrix=new int[matrixSize][matrixSize];
            for(int i=0; i<matrixSize; i++) {
                for(int j=0; j<matrixSize; j++) {
                    inputMatrix[i][j]=i*j;
                }
            }

            int[][] result=IncrementMatrix.increment(inputMatrix,numThreads);

            // check result
            for(int i=0; i<matrixSize; i++) {
                for(int j=0; j<matrixSize; j++) {
                    Assert.assertEquals(i*j+1,result[i][j]);
                }
            }
        }
    }
}
