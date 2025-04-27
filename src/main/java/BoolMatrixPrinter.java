// ------------------------------------
// Assignment 1
// Written by: Jovan Plavsic 230417
// For SE350 Section 602 - Spring 2025
// ------------------------------------

public class BoolMatrixPrinter extends MatrixOutlinePrinter {

    // Override printRow method. 1's are # and 0 are blank.
    @Override
    protected String printRow(Matrix matrix, int rowIdx) {
        int cols = matrix.getColCount();
        int[][] data = matrix.getData();

        StringBuilder row = new StringBuilder("|");

        // Check the value of cells
        for (int j = 0; j < cols; j++) {
            int value = data[rowIdx][j];

            if (value == 0) {
                row.append(" ");
            } else if (value == 1) {
                row.append("#");
            } else {
                // Check for invalid values in matrix
                throw new IllegalArgumentException("Matrix can only contain 0 or 1");
            }
        }
        row.append("|");

        return row.toString();
    }
}
