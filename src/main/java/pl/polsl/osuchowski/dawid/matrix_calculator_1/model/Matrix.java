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
            throw new IncorrectMatrixSizeException("Rows value " + rows + " is out of bounds.");
        } else if (columns < 1 || columns > 10) {
            throw new IncorrectMatrixSizeException("Columns value " + columns + "is out of bounds.");
        }
        this.rows = rows;
        this.columns = columns;
    }
    
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
