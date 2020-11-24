/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.polsl.osuchowski.dawid.matrix_calculator_1.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

/**
 *
 * @author Dawid
 */
public class MatrixTest {
    
    private Matrix matrix;
    
    public MatrixTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        matrix = new Matrix();
    }
    
    @AfterEach
    public void tearDown() {
    }
    
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
        
        String expectedMessage = "value out of bounds.";
        String actualMessage = exception.getMessage();
        
        assertTrue(actualMessage.contains(expectedMessage));
    }
    
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
        
        String expectedMessage = "Rows value out of bounds.";
        String actualMessage = exception.getMessage();
        
        assertTrue(actualMessage.contains(expectedMessage));
    }
    
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
        
        String expectedMessage = "Columns value out of bounds.";
        String actualMessage = exception.getMessage();
        
        assertTrue(actualMessage.contains(expectedMessage));
    }
    
}
