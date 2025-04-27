public class GameOfLife extends Matrix {

    public GameOfLife(int rows, int cols) {
        super(rows, cols);
    }

    public void addShape(Shape shape, int rowNum, int colNum) {
        int[][] gameData = getData();
        int[][] shapeData = shape.getData();

        int shapeRows = shape.getRowCount();
        int shapeCols = shape.getColCount();

        if (rowNum < 0 || colNum < 0 || rowNum + shapeRows > getRowCount() || colNum + shapeCols > getColCount()) {
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
            for (int j = 0; j < cols; j++) {
                int neighbors = countNeighbors(curr, i, j);

                if (curr[i][j] == 1) {
                    if (neighbors < 2 || neighbors > 3) {
                        next[i][j] = 0;
                    } else {
                        next[i][j] = 1;
                    }
                } else {
                    if (neighbors == 3) {
                        next[i][j] = 1;
                    } else {
                        next[i][j] = 0;
                    }
                }
            }
        }
        setData(next);
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

    public static void main(String[] args) {
        GameOfLife game = new GameOfLife(10, 10);


        Shape blinker = new Shape("Blinker", new int[][]{{0, 1, 0}, {0, 1, 0}, {0, 1, 0},});

        Shape glider = new Shape("Glider", new int[][]{{0, 0, 1}, {1, 0, 1}, {0, 1, 1},});

        game.addShape(blinker, 7, 7);
        game.addShape(glider, 1, 1);

        BoolMatrixPrinter printer = new BoolMatrixPrinter();
        int s = 0;
        System.out.println(printer.print(game));

        while (true) {
            s++;
            game.step();

            System.out.println("Step " + s);
            String output = printer.print(game);

            System.out.println("\033[H\033[2J");
            System.out.flush();
            System.out.println(output);

            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }

    }
}
