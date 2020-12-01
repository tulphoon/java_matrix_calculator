package pl.polsl.osuchowski.dawid.matrix_calculator_1;

import java.util.Objects;
import org.apache.commons.cli.ParseException;
import pl.polsl.osuchowski.dawid.matrix_calculator_1.model.ArgParser;
import static pl.polsl.osuchowski.dawid.matrix_calculator_1.model.ArgParser.MatrixOrder.FIRSTMATRIX;
import static pl.polsl.osuchowski.dawid.matrix_calculator_1.model.ArgParser.MatrixOrder.SECONDMATRIX;
import pl.polsl.osuchowski.dawid.matrix_calculator_1.model.IncorrectMatrixSizeException;
import pl.polsl.osuchowski.dawid.matrix_calculator_1.model.Matrix;
import pl.polsl.osuchowski.dawid.matrix_calculator_1.model.MatrixDimensionsMismatchException;
import pl.polsl.osuchowski.dawid.matrix_calculator_1.model.MatrixCalculator;
import pl.polsl.osuchowski.dawid.matrix_calculator_1.view.View;

/**
 * Main class of the Matrix Calculator application, acts as the Controller.
 * @author Dawid
 * @version 1.1
 */
public class Main {
    /**
     * Runs the main method, containing the Matrix Calculator program
     * @param args command line arguments
     */
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
            m1 = parser.getMatrix(FIRSTMATRIX);
            m2 = parser.getMatrix(SECONDMATRIX);
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
        
        view.println("Filling Matrix 1");
        m1.fillMatrix(view.getMatrixValues(m1.getRows(), m1.getColumns()));
        view.println("Filling Matrix 2");
        m2.fillMatrix(view.getMatrixValues(m2.getRows(), m2.getColumns()));
        
        view.println("Matrix 1");
        view.printMatrix(m1.getData());
        view.println("Matrix 2");
        view.printMatrix(m2.getData());
        
        MatrixCalculator calc = new MatrixCalculator();
        
        while(true) {
            int operation = view.pickOperation();
            try {
                switch(operation) {
                    case 1:
                        view.printMatrix(calc.addMatrices(m1, m2));
                        break;
                    case 2:
                        view.printMatrix(calc.subMatrices(m1, m2));
                        break;
                    case 3:
                        view.printMatrix(calc.mulMatrices(m1, m2));
                        break;
                    case 11:
                        view.println("Filling Matrix 1");
                        m1.fillMatrix(view.getMatrixValues(m1.getRows(), m1.getColumns()));
                        break;
                    case 12:
                        view.println("Filling Matrix 2");
                        m2.fillMatrix(view.getMatrixValues(m2.getRows(), m2.getColumns()));
                        break;
                    case 0:
                        return;
                    default:
                        break;
                }
            } catch (MatrixDimensionsMismatchException exp) {
                view.println(exp.getMessage());
            }
        }
    }
}
