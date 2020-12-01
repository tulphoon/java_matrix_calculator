package pl.polsl.osuchowski.dawid.matrix_calculator_1.model;

import java.util.stream.Stream;
import org.apache.commons.cli.ParseException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static pl.polsl.osuchowski.dawid.matrix_calculator_1.model.ArgParser.MatrixOrder.FIRSTMATRIX;

/**
 * Tests the ArgParser class methods
 * @author Dawid
 * @version 1.0
 */
public class ArgParserTest {
    /**
     * Test of parseArgs method, of class ArgParser.
     * @param args arguments to parse
     * @throws java.lang.Exception
     */
    @ParameterizedTest
    @MethodSource("correctArgsProvider")
    public void testParseCorrectArgs(String[] args) throws Exception {
        System.out.println("Parse correct arguments.");
        ArgParser parser = new ArgParser(args);
        try {
            parser.parseArgs();
        } catch (ParseException e) {     
            fail("ParseException: " + e.getMessage());
        }
    }
    
    /**
     * Test of parseArgs method, of class ArgParser.
     * @param args arguments to parse
     * @throws java.lang.Exception
     */
    @ParameterizedTest
    @MethodSource("incorrectArgsProvider")
    public void testParseIncorrectArgs(String[] args) throws Exception {
        System.out.println("Parse incorrect arguments.");
        ArgParser parser = new ArgParser(args);
        ParseException exception = assertThrows(
            ParseException.class,
            () -> parser.parseArgs());
        assertTrue(exception.getMessage().contains("Missing"), "Unexpected message!");
    }
    
    /**
     * Provides correct set of arguments for the ArgParser
     * @return stream of arguments arrays
     */
    static Stream<Arguments> correctArgsProvider() {
        return Stream.of(
            arguments((Object) new String[] {"-m1", "1x1", "-m2", "1x1"}),
            arguments((Object) new String[] {"-matrix1", "1x1", "-m2", "1x1"}),
            arguments((Object) new String[] {"-m1", "1x1", "-matrix2", "1x1"}),
            arguments((Object) new String[] {"-matrix1", "1x1", "-matrix2", "1x1"})
        );
    }
    
    /**
     * Provides incorrect set of arguments for the ArgParser
     * @return stream of arguments arrays
     */
    static Stream<Arguments> incorrectArgsProvider() {
        return Stream.of(
            arguments((Object) new String[] {}),
            arguments((Object) new String[] {"-m1"}),
            arguments((Object) new String[] {"-m1", "1x1"}),
            arguments((Object) new String[] {"-m2"}),
            arguments((Object) new String[] {"-m2", "1x1"}),
            arguments((Object) new String[] {"-m1", "1x1", "-m2"}),
            arguments((Object) new String[] {"-matrix1"}),
            arguments((Object) new String[] {"-matrix1", "1x1"}),
            arguments((Object) new String[] {"-matrix2"}),
            arguments((Object) new String[] {"-matrix2", "1x1"}),
            arguments((Object) new String[] {"-matrix1", "1x1", "-matrix2"})
        );
    }

    /**
     * Test of getMatrix method with correct data
     * @throws java.lang.Exception
     */
    @Test
    public void testGetMatrixCorrect() throws Exception {
        System.out.println("getMatrix");
        String[] args = new String[] {"-m1", "2x2", "-m2", "2x2"};
        ArgParser.MatrixOrder matrixOrder = FIRSTMATRIX;
        ArgParser instance = new ArgParser(args);
        instance.parseArgs();
        Matrix expResult = new Matrix();
        expResult.init(2, 2);
        Matrix result = instance.getMatrix(matrixOrder);
        assertEquals(expResult.getRows(), result.getRows());
        assertEquals(expResult.getColumns(), result.getColumns());
    }
    
    /**
     * Test of getMatrix method with incorrect matrix size data
     * @param args command line arguments to parse
     * @throws java.lang.Exception
     */
    @ParameterizedTest
    @MethodSource("incorrectSizeProvider")
    public void testGetMatrixIncorrectSize(String[] args) throws Exception {
        System.out.println("getMatrix");
        ArgParser.MatrixOrder matrixOrder = FIRSTMATRIX;
        ArgParser instance = new ArgParser(args);
        instance.parseArgs();
        IncorrectMatrixSizeException exception = assertThrows(IncorrectMatrixSizeException.class,
                () -> instance.getMatrix(matrixOrder));
        assertTrue(exception.getMessage().contains("out of bounds."), "Unexpected message!");
    }
    
    /**
     * Provides incorrect size set of arguments for the getMatrix method
     * @return stream of arguments arrays
     */
    static Stream<Arguments> incorrectSizeProvider() {
        return Stream.of(
            arguments((Object) new String[] {"-m1", "0x0", "-m2", "1x1"}),
            arguments((Object) new String[] {"-m1", "0x1", "-m2", "1x1"}),
            arguments((Object) new String[] {"-m1", "1x0", "-m2", "1x1"}),
            arguments((Object) new String[] {"-m1", "11x1", "-m2", "1x1"}),
            arguments((Object) new String[] {"-m1", "1x11", "-m2", "1x1"}),
            arguments((Object) new String[] {"-m1", "11x11", "-m2", "1x1"})
        );
    }
    
    /**
     * Test of getMatrix method with incorrect data type
     * @param args command line arguments to parse
     * @throws java.lang.Exception
     */
    @ParameterizedTest
    @MethodSource("incorrectTypeProvider")
    public void testGetMatrixIncorrectType(String[] args) throws Exception {
        System.out.println("getMatrix");
        ArgParser.MatrixOrder matrixOrder = FIRSTMATRIX;
        ArgParser instance = new ArgParser(args);
        instance.parseArgs();
        NumberFormatException exception = assertThrows(NumberFormatException.class,
                () -> instance.getMatrix(matrixOrder));
        System.out.println(exception.getMessage());
        assertTrue(exception.getMessage().contains("For input string:"), "Unexpected message!");
    }
    
    /**
     * Provides incorrect set of number arguments for the getMatrix method
     * @return stream of arguments arrays
     */
    static Stream<Arguments> incorrectTypeProvider() {
        return Stream.of(
            arguments((Object) new String[] {"-m1", "axa", "-m2", "1x1"}),
            arguments((Object) new String[] {"-m1", "1xa", "-m2", "1x1"}),
            arguments((Object) new String[] {"-m1", "ax1", "-m2", "1x1"}),
            arguments((Object) new String[] {"-m1", "0.0x1", "-m2", "1x1"}),
            arguments((Object) new String[] {"-m1", "1x0.0", "-m2", "1x1"})
        );
    }
}
