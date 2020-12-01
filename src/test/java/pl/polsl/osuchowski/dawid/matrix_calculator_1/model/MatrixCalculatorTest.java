/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.polsl.osuchowski.dawid.matrix_calculator_1.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * Tests for the MatrixCalculator class
 * @author Dawid
 * @version 1.0
 */
public class MatrixCalculatorTest {

    private Matrix a, b;
    private MatrixCalculator calculator;

    public MatrixCalculatorTest() {
        calculator = new MatrixCalculator();
    }

    @BeforeEach
    public void setUp() {
        a = new Matrix();
        b = new Matrix();
    }

    /**
     * Test of addMatrices method, of class MatrixCalculator.
     *
     * @param values matrix values
     * @param results expected resulting matrix
     * @throws java.lang.Exception
     */
    @ParameterizedTest
    @MethodSource("matrixAddProvider")
    public void testAddMatrices(Integer[][] values, Integer[][] results) throws Exception {
        System.out.println("addMatrices");
        List<List<Integer>> matrixValues = Arrays.stream(values)
                .map(Arrays::asList)
                .collect(Collectors.toList());
        List<List<Integer>> expResult = Arrays.stream(results)
                .map(Arrays::asList)
                .collect(Collectors.toList());
        int rows = values.length;
        int columns = values[0].length;
        a.init(rows, columns);
        b.init(rows, columns);
        a.fillMatrix(matrixValues);
        b.fillMatrix(matrixValues);

        List<List<Integer>> result = calculator.addMatrices(a, b);
        assertEquals(expResult, result);
    }

    /**
     * Test of subMatrices method, of class MatrixCalculator.
     *
     * @param values matrix values
     * @param results expected resulting matrix
     * @throws java.lang.Exception
     */
    @ParameterizedTest
    @MethodSource("matrixSubProvider")
    public void testSubMatrices(Integer[][] values, Integer[][] results) throws Exception {
        System.out.println("subMatrices");
        List<List<Integer>> matrixValues = Arrays.stream(values)
                .map(Arrays::asList)
                .collect(Collectors.toList());
        List<List<Integer>> expResult = Arrays.stream(results)
                .map(Arrays::asList)
                .collect(Collectors.toList());
        int rows = values.length;
        int columns = values[0].length;
        a.init(rows, columns);
        b.init(rows, columns);
        a.fillMatrix(matrixValues);
        b.fillMatrix(matrixValues);

        List<List<Integer>> result = calculator.subMatrices(a, b);
        assertEquals(expResult, result);
    }

    /**
     * Test of mulMatrices method, of class MatrixCalculator.
     * @param values matrix values
     * @param results expected resulting matrix
     * @throws java.lang.Exception
     */
    @ParameterizedTest
    @MethodSource("matrixMulProvider")
    public void testMulMatrices(Integer[][] values, Integer[][] results) throws Exception {
        System.out.println("mulMatrices");
        List<List<Integer>> matrixValues = Arrays.stream(values)
                .map(Arrays::asList)
                .collect(Collectors.toList());
        List<List<Integer>> expResult = Arrays.stream(results)
                .map(Arrays::asList)
                .collect(Collectors.toList());
        int rows = values.length;
        int columns = values[0].length;
        a.init(rows, columns);
        b.init(rows, columns);
        a.fillMatrix(matrixValues);
        b.fillMatrix(matrixValues);

        List<List<Integer>> result = calculator.mulMatrices(a, b);
        assertEquals(expResult, result);
    }

    /**
     * Contains Matrices with values and results for addition
     * @return source and result matrices
     */
    static Stream<Arguments> matrixAddProvider() {
        return Stream.of(
                arguments((Object) new Integer[][]{
            {1, 1},
            {1, 1}
        }, new Integer[][]{
            {2, 2},
            {2, 2}
        })
        );
    }

    /**
     * Contains Matrices with values and results for subtraction
     * @return source and result matrices
     */
    static Stream<Arguments> matrixSubProvider() {
        return Stream.of(
                arguments((Object) new Integer[][]{
            {1, 1},
            {1, 1}
        }, new Integer[][]{
            {0, 0},
            {0, 0}
        })
        );
    }

    /**
     * Contains Matrices with values and results for multiplication
     * @return source and result matrices
     */
    static Stream<Arguments> matrixMulProvider() {
        return Stream.of(
                arguments((Object) new Integer[][]{
            {1, 1},
            {1, 1}
        }, new Integer[][]{
            {2, 2},
            {2, 2}
        })
        );
    }

}
