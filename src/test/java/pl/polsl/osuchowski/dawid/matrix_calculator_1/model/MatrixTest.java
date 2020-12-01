package pl.polsl.osuchowski.dawid.matrix_calculator_1.model;

import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

/**
 * Tests for the Matrix class
 * @author Dawid
 * @version 1.0
 */
public class MatrixTest {
    
    private Matrix matrix;
        
    @BeforeEach
    public void setUp() {
        matrix = new Matrix();
    }
    
    /**
     * Checks if created matrix throws exception with incorrect size
     * @param rows number of rows
     * @param columns number of columns
     */
    @ParameterizedTest
    @CsvSource({
        "1, 1",
        "1, 2",
        "2, 1",
        "10, 10"
    })
    public void testCorrectMatrixSize(int rows, int columns) {
        try {
            matrix.init(rows, columns);
            assertEquals(matrix.getRows(), rows);
            assertEquals(matrix.getColumns(), columns);
        } catch (Exception e) {
            fail("Something went wrong.");
        }
    }
    
    /**
     * Checks if created matrix throws exception with incorrect size
     * @param rows number of rows
     * @param columns number of columns
     */
    @ParameterizedTest
    @CsvSource({
        "0, 0",
        "11, 11"
    })
    public void testIncorrectMatrixSize(int rows, int columns) {
        // check if it's possible to create matrices with incorrect size
        Exception exception = assertThrows(Exception.class, () -> {
            matrix.init(rows, columns);
        });
        
        String expectedMessage = "is out of bounds.";
        String actualMessage = exception.getMessage();
        
        assertTrue(actualMessage.contains(expectedMessage));
    }
    
    /**
     * Checks if created matrix throws exception with incorrect number of rows
     * @param rows number of rows
     * @param columns number of columns
     */
    @ParameterizedTest
    @CsvSource({
        "0, 1",
        "11, 10",
    })
    public void testIncorrectMatrixRowSize(int rows, int columns) {
        // check if it's possible to create matrices with incorrect size
        Exception exception = assertThrows(Exception.class, () -> {
            matrix.init(rows, columns);
        });
        
        String expectedMessage = "Rows value " + rows + " is out of bounds.";
        String actualMessage = exception.getMessage();
        
        assertTrue(actualMessage.contains(expectedMessage));
    }
    
    /**
     * Checks if created matrix throws exception with incorrect number of columns
     * @param rows number of rows
     * @param columns number of columns
     */
    @ParameterizedTest
    @CsvSource({
        "1, 0",
        "10, 11"
    })
    public void testIncorrectMatrixColumnSize(int rows, int columns) {
        // check if it's possible to create matrices with incorrect size
        Exception exception = assertThrows(Exception.class, () -> {
            matrix.init(rows, columns);
        });
        
        String expectedMessage = "Columns value " + columns + " is out of bounds.";
        String actualMessage = exception.getMessage();
        
        assertTrue(actualMessage.contains(expectedMessage));
    }
    
}
