package sprint2.testing;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import sprint2.product.Board;

import javax.swing.*;

public class TestBoard {

    //Arrange : set up test objects.
    // Act: do the actual method.
    // Assert: check if actual value is equal.
    private Board board;
    @Before
    public void setUp() throws Exception {
        board = new Board(6);
    }
    @After
    public void tearDown() throws Exception {
    }
    @Test
    public void testEmptyBoard() {
        JFrame frame = new JFrame();
        frame.add(board);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(270,270);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
    @Test
    public void testNonEmptyBoard() {
        board.game.makeMove(0, 0,"S");
        board.game.makeMove(1, 1,"O");

        JFrame frame = new JFrame();
        frame.add(board);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(270,270);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }


}
