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
    public void testBoolPrinterInvalidMatrix() {
        int[][] invalidData = {
                {0, 2, 1},
                {1, 0, 1}
        };

        Matrix matrix = new Matrix(invalidData);
        BoolMatrixPrinter printer = new BoolMatrixPrinter();
        printer.print(matrix);
    }


}