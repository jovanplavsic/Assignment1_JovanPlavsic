import org.junit.Test;

public class MatrixTest {

    @Test
    public void testValidDimensions() {
        Matrix0 matrix = new Matrix0(3, 4);
        assertEquals(3, matrix.getRowCount());
        assertEquals(4, matrix.getColCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testZeroConstructors() {
        new Matrix0(0, 0);
        new Matrix0(0, 1);
        new Matrix0(1, 0);
        new Matrix0(1, -1);
        new Matrix0(-1, 1);
    }
}
