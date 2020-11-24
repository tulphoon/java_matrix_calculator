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
    
    private ArrayList<ArrayList<Integer>> data = new ArrayList<ArrayList<Integer>>();

    public void init(int rows, int columns) throws Exception {
        if(rows < 1 || rows > 10) {
            throw new Exception("Rows value out of bounds.");
        } else if (columns < 1 || columns > 10) {
             throw new Exception("Columns value out of bounds.");
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
