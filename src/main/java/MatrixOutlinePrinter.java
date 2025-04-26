public class MatrixOutlinePrinter implements MatrixPrinter {

    @Override
    public String print(Matrix matrix) {
        int rows = matrix.getRowCount();
        int cols = matrix.getColCount();
        StringBuilder out = new StringBuilder();


    }


    protected String print(Matrix matrix, int rowIndex) {
        StringBuilder row = new StringBuilder("|");
        for (int j = 0; j < matrix.getColCount(); j++) {
            row.append(" ");
        }
        row.append("|");
        return row.toString();
    }
}
