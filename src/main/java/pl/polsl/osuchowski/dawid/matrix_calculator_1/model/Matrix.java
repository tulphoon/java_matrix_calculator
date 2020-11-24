/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.polsl.osuchowski.dawid.matrix_calculator_1.model;

import java.util.ArrayList;

/**
 * Defines a two dimensional Matrix
 * @author Dawid
 * @version 1.0
 */
public class Matrix {
    /**
     * Number of rows
     */
    private int rows;
    /**
     * Number of columns
     */
    private int columns;
    
    /**
     * Two dimensional array containing the values
     */
    private ArrayList<ArrayList<Integer>> data = new ArrayList<>();

    /**
     * Used for initializing the Matrix (setting it's size)
     * @param rows number of rows
     * @param columns number of columns
     * @throws IncorrectMatrixSizeException in case number of rows/columns is out of bounds 
     */
    public void init(int rows, int columns) throws IncorrectMatrixSizeException {
        if(rows < 1 || rows > 10) {
            throw new IncorrectMatrixSizeException("Rows value " + rows + " is out of bounds.");
        } else if (columns < 1 || columns > 10) {
            throw new IncorrectMatrixSizeException("Columns value " + columns + "is out of bounds.");
        }
        this.rows = rows;
        this.columns = columns;
    }
    
    /**
     * Fills the matrix with values
     * @param values array containing the values to be assigned to the matrix
     */
    public void fillMatrix(ArrayList<ArrayList<Integer>> values) {
        this.data = values;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public ArrayList<ArrayList<Integer>> getData() {
        return data;
    }
}
