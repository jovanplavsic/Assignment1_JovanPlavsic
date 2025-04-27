public class Matrix {
    private int[][] data;

    public Matrix(int rows, int cols) {
        if (rows < 1 || cols < 1) {
            throw new IllegalArgumentException("Requires at least 1 row and 1 column");
        }
        data = new int[rows][cols];
    }

    public Matrix(int[][] data) {
        if (data == null || data.length < 1 || data[0].length < 1) {
            throw new IllegalArgumentException("Cannot be null and requires at least 1 row and 1 column");
        }
        this.data = data;
    }

    public void setData(int[][] data) {
        this.data = data;
    }

    public int[][] getData() {
        return data;
    }

    public int getRowCount() {
        return data.length;
    }

    public int getColCount() {
        return data[0].length;
    }
}
