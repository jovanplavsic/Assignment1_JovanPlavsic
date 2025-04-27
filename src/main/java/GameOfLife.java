public class GameOfLife extends Matrix {

    public GameOfLife(int rows, int cols) {
        super(rows, cols);
    }

    public void addShape(Shape shape, int rowNum, int colNum) {
        int[][] gameData = getData();
        int[][] shapeData = shape.getData();

        int shapeRows = shape.getRowCount();
        int shapeCols = shape.getColCount();

        if (rowNum < 0 || colNum < 0 ||
                rowNum + shapeRows > getRowCount() ||
                colNum + shapeCols > getColCount()) {
            throw new IllegalArgumentException("Shape does not fit within the game.");
        }

        for (int i = 0; i < shapeRows; i++) {
            for (int j = 0; j < shapeCols; j++) {
                gameData[rowNum + i][colNum + j] = shapeData[i][j];
            }
        }
    }



}
