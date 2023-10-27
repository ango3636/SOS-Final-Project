package sprint2.testing;
import org.junit.jupiter.api.Assertions;
import sprint2.product.Board;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import sprint2.product.GameLogic;

public class TestOLetterMove {
    private Board board;

    @Before
    public void setUp() throws Exception {
        board = new Board(6);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testNoughtTurnMoveVacantCell() {
        board.game.makeMove(0, 0,"S");
        board.game.makeMove(0,1,"O");
        Assertions.assertEquals(board.game.getCell(0, 1), GameLogic.Cell.NOUGHT);
        board.game.makeMove(0,2,"S");
        Assertions.assertEquals(board.game.getTurn(), "blue");
    }

    @Test
    public void testNoughtTurnMoveNonVacantCell() {
        board.game.makeMove(0, 0,"S");
        Assertions.assertEquals(board.game.getTurn(), "blue");
        board.game.makeMove(0, 0,"S");
        Assertions.assertEquals(board.game.getTurn(), "blue");
    }

    @Test
    public void testNoughtTurnInvalidRowMove() {
        board.game.makeMove(4, 0,"S");
        Assertions.assertEquals(board.game.getTurn(), "blue");
    }

    @Test
    public void testNoughtTurnInvalidColumnMove() {
        board.game.makeMove(0, 4,"S");
        Assertions.assertEquals(board.game.getTurn(), "blue");
    }
}
