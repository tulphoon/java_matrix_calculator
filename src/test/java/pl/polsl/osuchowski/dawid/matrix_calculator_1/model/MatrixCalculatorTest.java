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
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Dawid
 */
public class MatrixCalculatorTest {
    
    public MatrixCalculatorTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of addMatrices method, of class MatrixCalculator.
     */
    @Test
    public void testAddMatrices() {
        System.out.println("addMatrices");
        Matrix a = null;
        Matrix b = null;
        MatrixCalculator instance = new MatrixCalculator();
        Matrix expResult = null;
        Matrix result = null;
        assertEquals(expResult, result);
    }
    
}
