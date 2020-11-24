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
public class MatrixCalculator {
    public ArrayList<ArrayList<Integer>> addMatrices(Matrix a, Matrix b) throws MatrixDimensionsMismatchException {
        if(a.getRows() != b.getRows())
        {
            throw new MatrixDimensionsMismatchException("Number of rows is different between matrices, cannot perform addition.");
        } else if (a.getColumns() != b.getColumns()) {
            throw new MatrixDimensionsMismatchException("Number of columns is different between matrices, cannot perform addition.");
        }
        
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for(int i = 0; i < a.getRows(); i++) {
            result.add(new ArrayList<>());
            for(int j = 0; j < a.getColumns(); j++) {
                result.get(i).add(j, 
                        a.getData().get(i).get(j) + b.getData().get(i).get(j));
            }
        }

        return result;
    }
    
    public ArrayList<ArrayList<Integer>> subMatrices(Matrix a, Matrix b) throws MatrixDimensionsMismatchException {
        if(a.getRows() != b.getRows())
        {
            throw new MatrixDimensionsMismatchException("Number of rows is different between matrices, cannot perform subtraction.");
        } else if (a.getColumns() != b.getColumns()) {
            throw new MatrixDimensionsMismatchException("Number of columns is different between matrices, cannot perform subtraction.");
        }
        
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for(int i = 0; i < a.getRows(); i++) {
            result.add(new ArrayList<>());
            for(int j = 0; j < a.getColumns(); j++) {
                result.get(i).add(j, 
                        a.getData().get(i).get(j) - b.getData().get(i).get(j));
            }
        }

        return result;
    }
    
    public ArrayList<ArrayList<Integer>> mulMatrices(Matrix a, Matrix b) throws MatrixDimensionsMismatchException {
        if(a.getColumns() != b.getRows()) {
            throw new MatrixDimensionsMismatchException("Number of columns from first matrix is different from number of rows in second column, cannot perform multiplication.");
        }
        
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for(int i = 0; i < a.getRows(); i++) {
            result.add(new ArrayList<>());
            for(int j = 0; j < b.getColumns(); j++) {
                for(int k = 0; k < b.getRows(); k++) {
                    if(k == 0)
                    {
                        result.get(i).add(j,
                            a.getData().get(i).get(k) * b.getData().get(k).get(j));
                    } else {
                        result.get(i).set(j, result.get(i).get(j) + a.getData().get(i).get(k) * b.getData().get(k).get(j));
                    }
                    
                }
            }
        }

        return result;
    }
}
