/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.polsl.osuchowski.dawid.matrix_calculator_1;

import java.util.Objects;
import pl.polsl.osuchowski.dawid.matrix_calculator_1.model.ArgParser;
import pl.polsl.osuchowski.dawid.matrix_calculator_1.model.Matrix;
import pl.polsl.osuchowski.dawid.matrix_calculator_1.view.View;

/**
 *
 * @author Dawid
 */
public class Main {
    public static void main(String[] args) {
        View view = new View();
        ArgParser parser = new ArgParser(args);
        
        if(!parser.parseArgs(view)) {
            return;
        }
        
        Matrix m1 = parser.getFirstMatrix(view);
        Matrix m2 = parser.getSecondMatrix(view);
        if(Objects.isNull(m1) || Objects.isNull(m2))
        {
            return;
        }
        
        
        
    }
}
