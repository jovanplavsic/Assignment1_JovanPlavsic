// ------------------------------------
// Assignment 1
// Written by: Jovan Plavsic 230417
// For SE350 Section 602 - Spring 2025
// ------------------------------------

// Simulates Conway's Game of Life using a 2D array taken from Matric class.
public class GameOfLife extends Matrix {

    // Construct a 2D board
    public GameOfLife(int rows, int cols) {
        super(rows, cols);
    }

    // Adds a pre-constructed shape to the matrix
    public void addShape(Shape shape, int rowNum, int colNum) {
        int[][] gameData = getData();
        int[][] shapeData = shape.getData();

        int shapeRows = shape.getRowCount();
        int shapeCols = shape.getColCount();

        // Make sure shape can fit into matrix
        if (rowNum < 0 || colNum < 0 || rowNum + shapeRows > getRowCount() || colNum + shapeCols > getColCount()) {
            throw new IllegalArgumentException("Shape does not fit within the game.");
        }

        // Copy the shape to the matrix
        for (int i = 0; i < shapeRows; i++) {
            for (int j = 0; j < shapeCols; j++) {
                gameData[rowNum + i][colNum + j] = shapeData[i][j];
            }
        }
    }

    //Advances the game by one step as defined by Conway's Game of Life rules
    public void step() {
        int rows = getRowCount();
        int cols = getColCount();
        int[][] curr = getData(); // Current state of matrix
        int[][] next = new int[rows][cols]; // Next state of matrix as progressed by the step function

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int neighbors = countNeighbors(curr, i, j);

                if (curr[i][j] == 1) {
                    // Check if under or overpopulated
                    if (neighbors < 2 || neighbors > 3) {
                        next[i][j] = 0;
                    } else {
                        next[i][j] = 1;
                    }
                } else {
                    // Turn cell alive by "reproduction" with nearby cells
                    if (neighbors == 3) {
                        next[i][j] = 1;
                    } else {
                        next[i][j] = 0;
                    }
                }
            }
        }
        // Update board with new values
        setData(next);
    }

    // Helper method to count how many neighbors a given cell has
    private int countNeighbors(int[][] game, int row, int col) {
        int count = 0;
        int rowCount = game.length;
        int colCount = game[0].length;

        // Check all surrounding cells
        for (int i = row - 1; i <= row + 1; i++) {
            for (int j = col - 1; j <= col + 1; j++) {

                if (i >= 0 && i < rowCount && j >= 0 && j < colCount) {
                    // Exclude the given cell
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

    // Main method to run and test GameOfLife
    public static void main(String[] args) {
        GameOfLife game = new GameOfLife(10, 10);


        Shape blinker = new Shape("Blinker", new int[][]{
                {0, 1, 0},
                {0, 1, 0},
                {0, 1, 0},
        });

        Shape glider = new Shape("Glider", new int[][]{
                {0, 0, 1},
                {1, 0, 1},
                {0, 1, 1},
        });

        game.addShape(blinker, 7, 7);
        game.addShape(glider, 1, 1);

        BoolMatrixPrinter printer = new BoolMatrixPrinter();
        int s = 0;
        System.out.println(printer.print(game));

        // Infinite loop to let game run and print progression after every step
        while (true) {
            s++;
            game.step();

            System.out.println("Step " + s);
            String output = printer.print(game);

            // Print statement to make transition between frames smoother in terminal
            System.out.println("\033[H\033[2J");
            System.out.flush();

            System.out.println(output);

            // Sleep function to make animation more visible
            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }

    }
}
