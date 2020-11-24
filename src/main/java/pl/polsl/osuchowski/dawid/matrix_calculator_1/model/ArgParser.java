/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.polsl.osuchowski.dawid.matrix_calculator_1.model;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

/**
 * 
 * @author Dawid
 */
public class ArgParser {
    private String[] args;
    private CommandLine cmd;

    public ArgParser(String[] args) {
        this.args = args;
    }
        
    public void parseArgs() throws ParseException {
        Options options = new Options();
        
        Option matrix1 = new Option("m1", "matrix1", true, "first matrix");
        matrix1.setArgs(2);
        matrix1.setValueSeparator('x');
        matrix1.setType(Number.class);
        matrix1.setRequired(true);
        options.addOption(matrix1);
        
        Option matrix2 = new Option("m2", "matrix2", true, "second matrix");
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
    
    public Matrix getFirstMatrix() throws NumberFormatException, IncorrectMatrixSizeException {
        String[] matrixSize1 = this.cmd.getOptionValues("matrix1");
        
        int rows, columns;
        
        Matrix m1 = new Matrix();
        
        try {
            rows = Integer.parseInt(matrixSize1[0]);
            columns = Integer.parseInt(matrixSize1[1]);
            m1.init(rows, columns);
            return m1;
        } catch (NumberFormatException | IncorrectMatrixSizeException e) {
            throw e;
        }
    }
    
        public Matrix getSecondMatrix() throws NumberFormatException, IncorrectMatrixSizeException{
        String[] matrixSize2 = this.cmd.getOptionValues("matrix2");
        
        int rows, columns;
        
        Matrix m2 = new Matrix();
        
        try {
            rows = Integer.parseInt(matrixSize2[0]);
            columns = Integer.parseInt(matrixSize2[1]);
            m2.init(rows, columns);
            return m2;
        } catch (NumberFormatException | IncorrectMatrixSizeException e) {
            throw e;
        }
    }  
}
