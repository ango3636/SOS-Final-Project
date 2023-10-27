package sprint2.testing;
import org.junit.jupiter.api.Assertions;
import sprint2.product.Board;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import sprint2.product.GameLogic;

public class TestSLetterMove {
        private Board board;

        @Before
        public void setUp() throws Exception {
            board = new Board(6);
        }

        @After
        public void tearDown() throws Exception {
        }

        @Test
        public void testCrossTurnMoveVacantCell() {
            board.game.makeMove(0, 0,"S");
            Assertions.assertEquals( board.game.getCell(0, 0), GameLogic.Cell.SNAKE);
            Assertions.assertEquals(board.game.getTurn(), "blue");
        }

        @Test
        public void testCrossTurnMoveNonVacantCell() {
            board.game.makeMove(0, 0,"S");
            board.game.makeMove(1, 0,"S");
            Assertions.assertEquals(board.game.getCell(1, 0), GameLogic.Cell.NOUGHT);
            Assertions.assertEquals(board.game.getTurn(), "red");
            board.game.makeMove(0, 0,"S");
            Assertions.assertEquals(board.game.getTurn(), "red");
        }

        @Test
        public void testCrossTurnInvalidRowMove() {
            board.game.makeMove(7, 0,"S");
            Assertions.assertEquals(board.game.getTurn(), "red");
        }

        @Test
        public void testCrossTurnInvalidColumnMove() {
            board.game.makeMove(0, 7,"S");
            Assertions.assertEquals(board.game.getTurn(), "red");
        }
}
