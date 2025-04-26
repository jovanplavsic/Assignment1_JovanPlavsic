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


}