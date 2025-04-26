public class BoolMatrixPrinter extends MatrixOutlinePrinter {

    @Override
    protected String printRow(Matrix matrix, int rowIdx) {
        int cols = matrix.getColCount();
        int[][] data = matrix.getData();

        StringBuilder row = new StringBuilder("|");

        for (int j = 0; j < cols; j++) {
            int value = data[rowIdx][j];

            if (value == 0) {
                row.append(" ");
            } else if (value == 1) {
                row.append("#");
            } else {
                throw new IllegalArgumentException("Matrix can only contain 0 or 1");
            }
        }
        row.append("|");

        return row.toString();
    }
}
