import org.junit.Test;
import static org.junit.Assert.*;

public class MatrixTest {

    @Test
    public void testValidDimensions() {
        Matrix matrix = new Matrix(3, 4);
        assertEquals(3, matrix.getRowCount());
        assertEquals(4, matrix.getColCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testZeroConstructors() {
        new Matrix(0, 0);
        new Matrix(0, 1);
        new Matrix(1, 0);
        new Matrix(1, -1);
        new Matrix(-1, 1);
    }
}
