/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.polsl.osuchowski.dawid.matrix_calculator_1.model;

/**
 * Exception class for objects thrown when attempting to add two matrices with
 * different dimensions.
 *
 * @author Dawid Osuchowski
 * @version 1.0
 */
public class MatrixDimensionsMismatchException extends Exception {

    /**
     * Non-parameter constructor
     */
    public MatrixDimensionsMismatchException() {
    }

    /**
     * Exception class constructor
     *
     * @param message display message
     */
    public MatrixDimensionsMismatchException(String message) {
        super(message);
    }
}
