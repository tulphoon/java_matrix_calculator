/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.polsl.osuchowski.dawid.matrix_calculator_1.view;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Provides functions for printing to the console and reading input
 * @author Dawid
 * @version 1.0
 */
public class View {
    /**
     * Prints a line to the standard output
     * @param message message to be printed
     */
    public void println(String message) {
        System.out.println(message);
    }
    
    /**
     * Used to read a single matrix cell value from the standard input
     * @param row row number of the cell
     * @param column column number of the cell
     * @return value to be inserted in the matrix at a given cell
     */
    private int readMatrixValue(int row, int column) {
        while(true)
        {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Matrix cell [" + row + "," + column + "] value: ");
                int value = scanner.nextInt();
                return value;
            } catch (InputMismatchException ime) {
                System.err.println("Not a valid value. Error: " + ime.getMessage());
            }
        }
    }
    
    /**
     * Used for reading all of the matrix values from the user
     * @param rows number of rows in the matrix
     * @param columns number of columns in the matrix
     * @return matrix containing the inserted values
     */
    public ArrayList<ArrayList<Integer>> getMatrixValues(int rows, int columns) {
        ArrayList<ArrayList<Integer>> data = new ArrayList<>();
        for(int i = 0; i < rows; i++) {
            data.add(new ArrayList<>());
            for(int j = 0; j < columns; j++) {
                data.get(i).add(j, readMatrixValue(i, j));
            }
        }
        return data;
    }
    
    /**
     * Used for printing the matrix
     * @param matrix matrix to be printed
     */
    public void printMatrix(ArrayList<ArrayList<Integer>> matrix) {
        System.out.println("-------------------------");
        for(ArrayList<Integer> column : matrix)
        {
            System.out.print("[");
            Iterator<Integer> iterator = column.iterator();
            while(iterator.hasNext())
            {
                int value = iterator.next();
                if(!iterator.hasNext())
                    System.out.print(value);
                else
                    System.out.print(value + ", ");
            }
            System.out.println("]");
        }
        System.out.println("-------------------------");
    }
    
    /**
     * Shows the menu to the user and reads the user's intent
     * @return number of operation to be performed
     */
    public int pickOperation() {
        while(true)
        {
            System.out.println("-------------------------");
            System.out.println("Available operations:");
            System.out.println("1 - Addition");
            System.out.println("2 - Subtraction");
            System.out.println("3 - Multiplication");
            System.out.println("-------------------------");
            System.out.println("11 - Refill matrix 1");
            System.out.println("12 - Refill matrix 2");
            System.out.println("-------------------------");
            System.out.println("0 - Exit");
            System.out.println("-------------------------");
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Select operation to perform: ");
                int value = scanner.nextInt();
                return value;
            } catch (InputMismatchException ime) {
                System.err.println("Not a valid value. Error: " + ime.getMessage());
            }
        }
    }
}
