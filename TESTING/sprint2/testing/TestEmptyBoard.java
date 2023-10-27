package sprint2.testing;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import sprint2.product.Board;
import sprint2.product.GameLogic;

public class TestEmptyBoard {

    private Board board = new Board(6);

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testNewBoard() {
        for (int row = 0; row <board.game.getTotalRows(); ++row) {
            for (int col = 0; col < board.game.getTotalColumns(); ++col) {
                Assertions.assertEquals(board.game.getCell(row, col), GameLogic.Cell.EMPTY);
            }
        }
    }

    @Test
    public void testInvalidRow() {
        Assertions.assertEquals(board.game.getCell(3, 0), GameLogic.Cell.EMPTY);
    }

    @Test
    public void testInvalidColumn() {
        Assertions.assertEquals(board.game.getCell(0, 3), GameLogic.Cell.EMPTY);
    }
}
