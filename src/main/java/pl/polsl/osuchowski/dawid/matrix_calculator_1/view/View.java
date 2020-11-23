/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.polsl.osuchowski.dawid.matrix_calculator_1.view;

import java.util.Scanner;

/**
 *
 * @author Dawid
 */
public class View {
    public void displayStartMatrixDimensionsInsertion(int number) {
        System.out.println("Provide the dimensions for matrix number " + number);
    }
    
    /**
     * 
     * @return 
     */
    public int readMatrixRowsFromUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of rows: ");
        int rows = scanner.nextInt();
          
        return rows;
    }
    
    public int readMatrixColumnsFromUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of columns: ");
        int columns = scanner.nextInt();
        
        return columns;
    }
}
