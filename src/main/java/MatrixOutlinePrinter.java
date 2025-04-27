// ------------------------------------
// Assignment 1
// Written by: Jovan Plavsic 230417
// For SE350 Section 602 - Spring 2025
// ------------------------------------

// Prints the outline of the Matrix object
public class MatrixOutlinePrinter implements MatrixPrinter {

    @Override
    public String print(Matrix matrix) {
        int rows = matrix.getRowCount();
        int cols = matrix.getColCount();
        StringBuilder out = new StringBuilder();

        // Print top of outline
        out.append("+");
        for (int j = 0; j < cols; j++) out.append("-");
        out.append("+\n");

        // Append each row using helper function
        for (int i = 0; i < rows; i++) {
            out.append(printRow(matrix, i)).append("\n");
        }

        // Print bottom of outline
        out.append("+");
        for (int j = 0; j < cols; j++) out.append("-");
        out.append("+");

        return out.toString();
    }


    // Helper function to print one empty row of the matrix
    protected String printRow(Matrix matrix, int rowIndex) {
        StringBuilder row = new StringBuilder("|");
        for (int j = 0; j < matrix.getColCount(); j++) {
            row.append(" ");
        }
        row.append("|");
        return row.toString();
    }
}
