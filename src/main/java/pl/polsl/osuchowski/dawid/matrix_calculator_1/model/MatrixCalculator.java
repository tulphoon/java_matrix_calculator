/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.polsl.osuchowski.dawid.matrix_calculator_1.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Contains methods for performing calculations on Matrices
 *
 * @author Dawid
 * @version 1.0
 */
public class MatrixCalculator {

    /**
     * Adds two matrices and returns the resulting matrix
     *
     * @param a first matrix
     * @param b second matrix
     * @return result of addition of a and b matrices
     * @throws MatrixDimensionsMismatchException in case dimensions of matrix a
     * and b differ
     */
    public List<List<Integer>> addMatrices(Matrix a, Matrix b) throws MatrixDimensionsMismatchException {
        if (a.getRows() != b.getRows()) {
            throw new MatrixDimensionsMismatchException("Number of rows is different between matrices, cannot perform addition.");
        } else if (a.getColumns() != b.getColumns()) {
            throw new MatrixDimensionsMismatchException("Number of columns is different between matrices, cannot perform addition.");
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < a.getRows(); i++) {
            result.add(new ArrayList<>());
            for (int j = 0; j < a.getColumns(); j++) {
                result.get(i).add(j,
                        a.getData().get(i).get(j) + b.getData().get(i).get(j));
            }
        }

        return result;
    }

    /**
     * Subtracts two matrices and returns the resulting matrix
     *
     * @param a first matrix
     * @param b second matrix
     * @return result of subtraction of b matrix from a matrix
     * @throws MatrixDimensionsMismatchException in case dimensions of matrix a
     * and b differ
     */
    public List<List<Integer>> subMatrices(Matrix a, Matrix b) throws MatrixDimensionsMismatchException {
        if (a.getRows() != b.getRows()) {
            throw new MatrixDimensionsMismatchException("Number of rows is different between matrices, cannot perform subtraction.");
        } else if (a.getColumns() != b.getColumns()) {
            throw new MatrixDimensionsMismatchException("Number of columns is different between matrices, cannot perform subtraction.");
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < a.getRows(); i++) {
            result.add(new ArrayList<>());
            for (int j = 0; j < a.getColumns(); j++) {
                result.get(i).add(j,
                        a.getData().get(i).get(j) - b.getData().get(i).get(j));
            }
        }

        return result;
    }

    /**
     * Performs multiplication of two matrices and returns the resulting matrix
     *
     * @param a first matrix
     * @param b second matrix
     * @return result of multiplication of a and b matrices
     * @throws MatrixDimensionsMismatchException in case dimensions of matrices
     * don't allow to perform the multiplication operation
     */
    public List<List<Integer>> mulMatrices(Matrix a, Matrix b) throws MatrixDimensionsMismatchException {
        if (a.getColumns() != b.getRows()) {
            throw new MatrixDimensionsMismatchException("Number of columns from first matrix is different from number of rows in second column, cannot perform multiplication.");
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < a.getRows(); i++) {
            result.add(new ArrayList<>());
            for (int j = 0; j < b.getColumns(); j++) {
                for (int k = 0; k < b.getRows(); k++) {
                    if (k == 0) {
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
