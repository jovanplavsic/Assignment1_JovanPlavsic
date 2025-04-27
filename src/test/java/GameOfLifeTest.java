// ------------------------------------
// Assignment 1
// Written by: Jovan Plavsic 230417
// For SE350 Section 602 - Spring 2025
// ------------------------------------

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;

// Unit tests for GameOfLife
public class GameOfLifeTest {
    private GameOfLife game;
    private Shape blinker;
    private Shape glider;

    // Set up new matrix before each test
    @Before
    public void setUp() {
        game = new GameOfLife(10, 10);
        BoolMatrixPrinter printer = new BoolMatrixPrinter();

        blinker = new Shape("Blinker", new int[][]{
                {0, 1, 0},
                {0, 1, 0},
                {0, 1, 0},
        });

        glider = new Shape("Glider", new int[][]{
                {0, 0, 1},
                {1, 0, 1},
                {0, 1, 1},
        });

        // Place shapes on matrix
        game.addShape(blinker, 7, 7);
        game.addShape(glider, 1, 1);
    }

    // Test matrix after one step
    @Test
    public void testOneStep() {
        BoolMatrixPrinter printer = new BoolMatrixPrinter();

        // Take one step
        game.step();

        // Make new 2D array for expected results
        int[][] expected = new int[10][10];

        // glider positions after one step
        expected[1][2] = 1;
        expected[2][3] = 1;
        expected[2][4] = 1;
        expected[3][3] = 1;
        expected[3][2] = 1;

        // blinker positions after one step
        expected[8][7] = 1;
        expected[8][8] = 1;
        expected[8][9] = 1;


        // Print matrix after one step and compare to expected result
        System.out.println(printer.print(game));
        assertArrayEquals(expected, game.getData());
    }

    // Test matrix after ten steps
    @Test
    public void testTenStep() {
        BoolMatrixPrinter printer = new BoolMatrixPrinter();

        // Take ten steps
        for (int i = 0; i < 10; i++) {
            game.step();
        }
        // Make new 2D array for expected results
        int[][] expected = new int[10][10];

        // glider positions after 10 steps
        expected[3][5] = 1;
        expected[4][6] = 1;
        expected[5][6] = 1;
        expected[5][5] = 1;
        expected[5][4] = 1;

        // blinker positions after 10 steps
        expected[7][8] = 1;
        expected[8][8] = 1;
        expected[9][8] = 1;

        // Print matrix after one step and compare to expected result
        System.out.println(printer.print(game));
        assertArrayEquals(expected, game.getData());

    }
}
