/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.polsl.osuchowski.dawid.matrix_calculator_1;

import java.util.Objects;
import org.apache.commons.cli.ParseException;
import pl.polsl.osuchowski.dawid.matrix_calculator_1.model.ArgParser;
import pl.polsl.osuchowski.dawid.matrix_calculator_1.model.IncorrectMatrixSizeException;
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
        
        try {
            parser.parseArgs();
        } catch (ParseException e) {
            view.println(e.getMessage());
            return;
        }
        
        Matrix m1, m2;
        
        try {
            m1 = parser.getFirstMatrix();
            m2 = parser.getSecondMatrix();
        } catch (NumberFormatException nfe) {
            view.println(nfe.getMessage() + " conversion to integer failed.");
            return;
        } catch (IncorrectMatrixSizeException e) {
            view.println(e.getMessage());
            return;
        }
        
        if(Objects.isNull(m1) || Objects.isNull(m2))
        {
            return;
        }
        
        m1.fillMatrix(view.getMatrixValues(m1.getRows(), m1.getColumns()));
        m2.fillMatrix(view.getMatrixValues(m2.getRows(), m2.getColumns()));
        
        view.printMatrix(m1.getData());
        view.printMatrix(m2.getData());
    }
}
