import java.util.Scanner;

public class MatrixOutlinePrinter implements MatrixPrinter {

    @Override
    public String print(Matrix matrix) {
        StringBuilder output = new StringBuilder();
        StringBuilder cols = new StringBuilder();
        StringBuilder row = new StringBuilder();

        int r = matrix.getRowCount();
        int c = matrix.getColCount();

        cols.append("+");
        row.append("|");
        for (int j = 0; j < c; j++) {
            cols.append("-");
            row.append(" ");
        }
        cols.append("+");
        row.append("|");

        output.append(cols).append("\n");
        for (int j = 0; j < r; j++) {
            output.append(row).append("\n");
        }
        output.append(cols);


        return output.toString();
    }

    protected String printRow(Matrix matrix, int rowIndex) {
        return "";
    }

}
