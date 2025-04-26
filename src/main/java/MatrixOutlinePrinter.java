public class MatrixOutlinePrinter implements MatrixPrinter {

    @Override
    public String print(Matrix matrix) {
        int rows = matrix.getRowCount();
        int cols = matrix.getColCount();
        StringBuilder out = new StringBuilder();

        out.append("+");
        for (int j = 0; j < cols; j++) out.append("-");
        out.append("+\n");

        for (int i = 0; i < rows; i++) {
            out.append(printRow(matrix, i)).append("\n");
        }

        out.append("+");
        for (int j = 0; j < cols; j++) out.append("-");
        out.append("+");

        return out.toString();

    }


    protected String printRow(Matrix matrix, int rowIndex) {
        StringBuilder row = new StringBuilder("|");
        for (int j = 0; j < matrix.getColCount(); j++) {
            row.append(" ");
        }
        row.append("|");
        return row.toString();
    }
}
