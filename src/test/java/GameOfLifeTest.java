import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;


public class GameOfLifeTest {
    private GameOfLife game;
    private Shape blinker;
    private Shape glider;

    @Before
    public void setUp() {
        game = new GameOfLife(15, 15);

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

        game.addShape(blinker, 12, 12);
        game.addShape(glider, 1, 1);
    }

 @Test
    public void testOneStep() {}
    public void testTenStep() {}
}
