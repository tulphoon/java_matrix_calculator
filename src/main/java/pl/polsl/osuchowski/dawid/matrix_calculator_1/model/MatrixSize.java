/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.polsl.osuchowski.dawid.matrix_calculator_1.model;

/**
 *
 * @author Dawid
 */
public class MatrixSize {
    private Integer rows;
    private Integer columns;

    public MatrixSize(Integer rows, Integer columns) {
        this.rows = rows;
        this.columns = columns;
    }

    public Integer getRows() {
        return rows;
    }

    public Integer getColumns() {
        return columns;
    }
}
