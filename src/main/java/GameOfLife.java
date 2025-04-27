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

    public void step() {
        int rows = getRowCount();
        int cols = getColCount();
        int[][] curr = getData();
        int[][] next = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; i < cols; i++) {
                int neighbors = countNeighbors(curr, i, j);

                if (curr[i][j] == 1) {
                    if (neighbors < 2 || neighbors > 3) {
                        next[i][j] = 0;
                    } else {
                        next[i][j] = 1;
                    }
                    if (curr[i][j] == 0) {
                        if (neighbors == 3) {
                            next[i][j] = 0;
                        } else {
                            next[i][j] = 1;
                        }
                    }
                }
            }
        }
    }

    private int countNeighbors(int[][] game, int row, int col) {
        int count = 0;
        int rowCount = game.length;
        int colCount = game[0].length;

        for (int i = row - 1; i <= row + 1; i++) {
            for (int j = col - 1; j <= col + 1; j++) {

                if (i >= 0 && i < rowCount && j >= 0 && j < colCount) {
                    if (i != row || j != col) {
                        if (game[i][j] == 1) {
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }


}
