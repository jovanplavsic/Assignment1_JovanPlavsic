import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;


public class GameOfLifeTest {
    private GameOfLife game;
    private Shape blinker;
    private Shape glider;

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

        game.addShape(blinker, 7, 7);
        game.addShape(glider, 1, 1);
    }

    @Test
    public void testOneStep() {
        BoolMatrixPrinter printer = new BoolMatrixPrinter();

        game.step();

        int[][] expected = new int[10][10];

        //glider
        expected[1][2] = 1;
        expected[2][3] = 1;
        expected[2][4] = 1;
        expected[3][3] = 1;
        expected[3][2] = 1;

        //blinker
        expected[8][7] = 1;
        expected[8][8] = 1;
        expected[8][9] = 1;


        System.out.println(printer.print(game));
        assertArrayEquals(expected, game.getData());
    }

    @Test
    public void testTenStep() {
        BoolMatrixPrinter printer = new BoolMatrixPrinter();

        for (int i = 0; i < 10; i++) {
            game.step();
        }
        int[][] expected = new int[10][10];
        // glider
        expected[3][5] = 1;
        expected[4][6] = 1;
        expected[5][6] = 1;
        expected[5][5] = 1;
        expected[5][4] = 1;

        // blinker
        expected[7][8] = 1;
        expected[8][8] = 1;
        expected[9][8] = 1;

        System.out.println(printer.print(game));
        assertArrayEquals(expected, game.getData());

    }
}
