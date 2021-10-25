import org.junit.Assert;
import org.junit.Test;

public class ResizeMatrixTest {

    // This is a matrix with 3 rows and 4 columns
    static int[][] matrix = {
            { 1, 2, 3, 4 },
            { 5, 6, 7, 8 },
            { 9, 10,11,12}
    };

    // Test: insert two empty columns before the first column
    @Test
    public void testInsertAtBeginning() {
        int[][] answerByStudent = ResizeMatrix.insertEmptyColumns(matrix,0,2);
        int[][] correctAnswer = {
                { 0, 0,  1, 2, 3, 4 },
                { 0, 0,  5, 6, 7, 8 },
                { 0, 0,  9,10,11,12 }
        };
        Assert.assertArrayEquals(answerByStudent, correctAnswer);
    }

    // Test: insert two empty columns before the second column
    @Test
    public void testInsertInMiddle() {
        int[][] answerByStudent = ResizeMatrix.insertEmptyColumns(matrix,1,2);
        int[][] correctAnswer = {
                { 1,  0, 0,  2, 3, 4 },
                { 5,  0, 0,  6, 7, 8 },
                { 9,  0, 0,  10,11,12 }
        };
        Assert.assertArrayEquals(answerByStudent, correctAnswer);
    }

    // Test: insert two empty columns after the last column
    @Test
    public void testInsertAtEnd() {
        int[][] answerByStudent = ResizeMatrix.insertEmptyColumns(matrix,10,2);
        int[][] correctAnswer = {
                { 1, 2, 3, 4,  0, 0 },
                { 5, 6, 7, 8,  0, 0 },
                { 9, 10,11,12, 0, 0 }
        };
        Assert.assertArrayEquals(answerByStudent, correctAnswer);
    }
}
