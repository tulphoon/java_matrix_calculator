package pl.polsl.osuchowski.dawid.matrix_calculator_1.model;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import static pl.polsl.osuchowski.dawid.matrix_calculator_1.model.ArgParser.MatrixOrder.FIRSTMATRIX;
import static pl.polsl.osuchowski.dawid.matrix_calculator_1.model.ArgParser.MatrixOrder.SECONDMATRIX;

/**
 * Used for parsing arguments from the command line interface and creating
 * Matrices based on these arguments.
 * @author Dawid
 * @version 1.1
 */
public class ArgParser {
    /**
     * Command line arguments
     */
    private String[] args;
    /**
     * CommandLine object containing parsed arguments
     */
    private CommandLine cmd;

    /**
     * Constructor
     * @param args array of command line arguments
     */
    public ArgParser(String[] args) {
        this.args = args;
    }
    
    /**
     * Defines matrices and their IDs
     */
    public enum MatrixOrder {
        /**
         * First matrix
         */
        FIRSTMATRIX("matrix1"),
        /**
         * Second matrix
         */
        SECONDMATRIX("matrix2");
        
        /**
         * Identification string
         */
        private final String id;

        MatrixOrder(String id) {
            this.id = id;
        }

        public String id() {
            return id;
        }
    }
    
    /**
     * Defines the mandatory argument structure and parses arguments
     * passed to the program according to that structure
     * @throws ParseException when the arguments are incorrect
     */
    public void parseArgs() throws ParseException {
        Options options = new Options();
        
        Option matrix1 = new Option("m1", FIRSTMATRIX.id(), true, "first matrix");
        matrix1.setArgs(2);
        matrix1.setValueSeparator('x');
        matrix1.setType(Number.class);
        matrix1.setRequired(true);
        options.addOption(matrix1);
        
        Option matrix2 = new Option("m2", SECONDMATRIX.id(), true, "second matrix");
        matrix2.setArgs(2);
        matrix2.setValueSeparator('x');
        matrix1.setType(Number.class);
        matrix2.setRequired(true);
        options.addOption(matrix2);
        
        CommandLineParser parser = new DefaultParser();
        HelpFormatter formatter = new HelpFormatter();
        CommandLine cmd;
        
        try {
            cmd = parser.parse(options, this.args);
            this.cmd = cmd;
        } catch (ParseException e) {
            formatter.printHelp("matrix-calculator", options);
            throw e; 
        }
    }
    
    /**
     * Initializes matrix based on passed arguments
     * @param matrixOrder tells the method which matrix we want to initialize
     * @return initialized matrix
     * @throws NumberFormatException in case argument was not a valid number
     * @throws IncorrectMatrixSizeException in case row or column size was out of bounds
     */
    public Matrix getMatrix(MatrixOrder matrixOrder) throws NumberFormatException, IncorrectMatrixSizeException {
        String[] matrixSize = this.cmd.getOptionValues(matrixOrder.id());
        
        int rows, columns;
        
        Matrix m = new Matrix();
        
        try {
            rows = Integer.parseInt(matrixSize[0]);
            columns = Integer.parseInt(matrixSize[1]);
            m.init(rows, columns);
            return m;
        } catch (NumberFormatException | IncorrectMatrixSizeException e) {
            throw e;
        }
    }
}
