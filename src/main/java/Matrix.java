// ------------------------------------
// Assignment 1
// Written by: Jovan Plavsic 230417
// For SE350 Section 602 - Spring 2025
// ------------------------------------

// Matrix class simulated Game of Life board using 2D array
public class Matrix {
    private int[][] data;

    // matrix constructor using width and length dimensions
    public Matrix(int rows, int cols) {
        if (rows < 1 || cols < 1) {
            throw new IllegalArgumentException("Requires at least 1 row and 1 column");
        }
        data = new int[rows][cols];
    }

    // Matrix constructor using a pre-existing 2D matrix
    public Matrix(int[][] data) {
        if (data == null || data.length < 1 || data[0].length < 1) {
            throw new IllegalArgumentException("Cannot be null and requires at least 1 row and 1 column");
        }
        this.data = data;
    }

    // Update board to inputed 2D matrix
    public void setData(int[][] data) {
        this.data = data;
    }

    // Return matrix as is
    public int[][] getData() {
        return data;
    }

    // Return row count
    public int getRowCount() {
        return data.length;
    }

    // Return column count
    public int getColCount() {
        return data[0].length;
    }
}
