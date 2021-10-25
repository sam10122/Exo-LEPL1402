import org.junit.Assert;
import org.junit.Test;

import java.util.Random;

public class FindInMatrixTest {

    private final int[][] verySmallMatrix = new int[][] {
        { 1 }
    };

    private final int[][] smallMatrix = new int[][] {
        { 1,   3,  2,  -4 },
        { -3,  4,  5,  -2 },
        { 3,   0,  3,   2 }
    };

    @Test
    public void testVerySmallMatrix() {
        FindInMatrix.Result result=FindInMatrix.findValue(verySmallMatrix,1, 1);
        Assert.assertEquals(0, result.row);
        Assert.assertArrayEquals(new Integer[]{0}, result.columns.toArray());
    }

    private void testSmallMatrix(int poolSize) {
        // the value "3" appears twice in row 2 in columns 0 and 2
        FindInMatrix.Result result=FindInMatrix.findValue(smallMatrix,3, poolSize);
        Assert.assertEquals(2, result.row);
        Assert.assertArrayEquals(new Integer[]{0,2}, result.columns.toArray());

        // the value "-4" appears once in row 0 in column 3
        FindInMatrix.Result result2=FindInMatrix.findValue(smallMatrix,-4, poolSize);
        Assert.assertEquals(0, result2.row);
        Assert.assertArrayEquals(new Integer[]{3}, result2.columns.toArray());
    }

    @Test
    public void testSmallMatrixSingleThread() {
        testSmallMatrix(1);
    }

    @Test
    public void testSmallMatrixTwoThreads() {
        testSmallMatrix(2);
    }

    @Test
    public void testSmallMatrixThreeThreads() {
        testSmallMatrix(3);
    }

    private void testLargeMatrix(int poolSize) {
        final int matrixNumRows=100;
        final int matrixNumColumns=100000;

        // create a 100x100000 matrix with random values between 0 and 99
        Random rng=new Random();
        int[][] matrix=new int[matrixNumRows][matrixNumColumns];
        for(int row=0; row<matrixNumRows; row++) {
            for(int col=0; col<matrixNumColumns; col++) {
                matrix[row][col]=rng.nextInt(100);
            }
        }

        // put the number 100 ten times in each row at random columns
        // and eleven times in one random row
        int rowWithMostOccurrences=rng.nextInt(matrixNumRows);
        for(int row=0; row<matrixNumRows; row++) {
            // put the value 100 at random places in the row
            final int r=row;
            rng.ints(0, matrixNumColumns).distinct().limit(row==rowWithMostOccurrences ? 11 : 10).forEach((int randomColumn)->{
                matrix[r][randomColumn]=100;
            });
        }

        // test whether your solution correctly identifies the row with
        // the most number of occurrences of the value 100
        FindInMatrix.Result result=FindInMatrix.findValue(matrix,100, poolSize);
        Assert.assertEquals(rowWithMostOccurrences, result.row);
        Assert.assertEquals(11, result.columns.size());
        // we are lazy and don't test the contents of result.columns here.
    }

    @Test
    public void testLargeMatrixSingleThread() {
        testLargeMatrix(1);
    }

    @Test
    public void testLargeMatrixTwoThreads() {
        testLargeMatrix(2);
    }

    @Test
    public void testLargeMatrixManyThreads() {
        testLargeMatrix(10);
    }

}
