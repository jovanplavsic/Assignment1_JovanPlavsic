// ------------------------------------
// Assignment 1
// Written by: Jovan Plavsic 230417
// For SE350 Section 602 - Spring 2025
// ------------------------------------

import org.junit.Test;

import static org.junit.Assert.*;

// Test Matrix class
public class MatrixTest {

    // Test if Matrix accepts only valid dimensions
    @Test
    public void testValidDimensions() {
        Matrix matrix = new Matrix(3, 4);
        assertEquals(3, matrix.getRowCount());
        assertEquals(4, matrix.getColCount());
    }

    // Test that Matrix doesn't accept 0 or negative values
    @Test(expected = IllegalArgumentException.class)
    public void testZeroConstructors() {
        new Matrix(0, 0);
        new Matrix(0, 1);
        new Matrix(1, 0);
        new Matrix(1, -1);
        new Matrix(-1, 1);
    }
}
