/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.polsl.osuchowski.dawid.matrix_calculator_1.model;

/**
 * Exception class for objects thrown when attempting to create a matrix with
 * incorrect size.
 *
 * @author Dawid Osuchowski
 * @version 1.0
 */
public class IncorrectMatrixSizeException extends Exception {

    /**
     * Non-parameter constructor
     */
    public IncorrectMatrixSizeException() {
    }

    /**
     * Exception class constructor
     *
     * @param message display message
     */
    public IncorrectMatrixSizeException(String message) {
        super(message);
    }
}