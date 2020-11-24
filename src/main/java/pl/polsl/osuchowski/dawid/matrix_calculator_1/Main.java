/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.polsl.osuchowski.dawid.matrix_calculator_1;

import pl.polsl.osuchowski.dawid.matrix_calculator_1.model.Matrix;
import pl.polsl.osuchowski.dawid.matrix_calculator_1.view.View;

/**
 *
 * @author Dawid
 */
public class Main {
    public static void main(String[] args) {
        int rows, columns;
        View view = new View();
        view.displayStartMatrixDimensionsInsertion(1);
        rows = view.readMatrixRowsFromUser();
        columns = view.readMatrixColumnsFromUser();
        
        Matrix m1 = new Matrix();
        try {
            m1.init(rows, columns);
        } catch (Exception e) {
            
        }
        
        
        view.displayStartMatrixDimensionsInsertion(2);
        rows = view.readMatrixRowsFromUser();
        columns = view.readMatrixColumnsFromUser();
        
        Matrix m2 = new Matrix();
        try {
            m2.init(rows, columns);
        }
        catch (Exception e) {
            
        }
        
    }
}
