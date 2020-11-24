/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.polsl.osuchowski.dawid.matrix_calculator_1.model;

import java.util.ArrayList;

/**
 *
 * @author Dawid
 */
public class Matrix {
    private int rows;
    private int columns;
    
    private ArrayList<ArrayList<Integer>> data = new ArrayList<>();

    public void init(int rows, int columns) throws IncorrectMatrixSizeException {
        if(rows < 1 || rows > 10) {
            throw new IncorrectMatrixSizeException("Rows value out of bounds.");
        } else if (columns < 1 || columns > 10) {
            throw new IncorrectMatrixSizeException("Columns value out of bounds.");
        }
        this.rows = rows;
        this.columns = columns;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }
    
}

/**
 * Exception class for objects thrown when attempting to create a matrix with
 * incorrect size.
 *
 * @author Dawid Osuchowski
 * @version 1.0
 */
class IncorrectMatrixSizeException extends Exception {

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
