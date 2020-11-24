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
 *
 * @author Dawid
 */
public class View {
    public void println(String message) {
        System.out.println(message);
    }
    
    /**
     * 
     * @return 
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
