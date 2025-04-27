// ------------------------------------
// Assignment 1
// Written by: Jovan Plavsic 230417
// For SE350 Section 602 - Spring 2025
// ------------------------------------

import static org.junit.Assert.*;

import org.junit.Test;

// Unit tests for MatrixPrinter
public class MatrixPrinterTest {
    // Test outline of matrix given 3x4 dimensions
    @Test
    public void testMatrixOutline() {
        Matrix matrix = new Matrix(3, 4); // 3 rows, 4 columns
        MatrixOutlinePrinter printer = new MatrixOutlinePrinter();

        // Expected shape and size of outline
        String expected =
                "+----+\n" +
                "|    |\n" +
                "|    |\n" +
                "|    |\n" +
                "+----+";

        assertEquals(expected, printer.print(matrix));
    }

    // Test if MatrixPrinter checks for invalid values in matrix
    @Test(expected = IllegalArgumentException.class)
    public void testBoolPrinterInvalidData() {
        int[][] invalidData = {
                {0, 2, 1},
                {1, 0, 1}
        };

        Matrix matrix = new Matrix(invalidData);
        BoolMatrixPrinter printer = new BoolMatrixPrinter();
        printer.print(matrix);
    }

    // Test rowPrint of BoolMatrixPrinter
    // Check correct placement of #s, " "s in place of 1s, 0s respectively
    @Test
    public void testBoolMatrixPrinterValidMatrix1() {
        int[][] data1 = {
                {0, 1, 0},
                {1, 0, 1}
        };
        Matrix matrix1 = new Matrix(data1);
        BoolMatrixPrinter printer1 = new BoolMatrixPrinter();

        // Expected shape and positions of data1 values
        String expected1 =
                "+---+\n" +
                        "| # |\n" +
                        "|# #|\n" +
                        "+---+";

        assertEquals(expected1, printer1.print(matrix1));

        int[][] data2 = {
                {1, 1},
                {0, 0}
        };
        Matrix matrix2 = new Matrix(data2);
        BoolMatrixPrinter printer2 = new BoolMatrixPrinter();

        // Expected shape and positions of data2
        String expected2 =
                "+--+\n" +
                        "|##|\n" +
                        "|  |\n" +
                        "+--+";

        assertEquals(expected2, printer2.print(matrix2));
    }

}