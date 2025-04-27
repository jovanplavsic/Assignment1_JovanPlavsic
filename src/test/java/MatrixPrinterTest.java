import static org.junit.Assert.*;

import org.junit.Test;

public class MatrixPrinterTest {
    @Test
    public void testMatrixOutline() {
        Matrix matrix = new Matrix(3, 4); // 3 rows, 4 columns
        MatrixOutlinePrinter printer = new MatrixOutlinePrinter();

        String expected =
                "+----+\n" +
                        "|    |\n" +
                        "|    |\n" +
                        "|    |\n" +
                        "+----+";

        assertEquals(expected, printer.print(matrix));
    }

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

    @Test
    public void testBoolMatrixPrinterValidMatrix1() {
        int[][] data1 = {
                {0, 1, 0},
                {1, 0, 1}
        };
        Matrix matrix1 = new Matrix(data1);
        BoolMatrixPrinter printer1 = new BoolMatrixPrinter();

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

        String expected2 =
                "+--+\n" +
                        "|##|\n" +
                        "|  |\n" +
                        "+--+";

        assertEquals(expected2, printer2.print(matrix2));
    }

}