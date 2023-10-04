import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Board extends JPanel {
    public static final int GAME_BOARD_SIZE = 250;
    public static final int CELL_SIZE = GAME_BOARD_SIZE/6;
    public static final int GRID_WIDTH = 4;
    public static final int GRID_WIDTH_HALF = GRID_WIDTH / 2;

    public static final int CELL_PADDING = CELL_SIZE / 6;

    Board(){
        Border outline = BorderFactory.createLineBorder(Color.BLACK,5);
        setBorder(outline);
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Color.WHITE);
        drawGridLines(g);
    }

    private void drawGridLines(Graphics g) {
        g.setColor(Color.LIGHT_GRAY);
        for (int row = 1; row < 10; ++row) {
            g.fillRoundRect(0, CELL_SIZE * row - GRID_WIDTH_HALF, CELL_SIZE * 6 - 1, GRID_WIDTH,
                    GRID_WIDTH, GRID_WIDTH);
        }
        for (int col = 1; col < 10; ++col) {
            g.fillRoundRect(CELL_SIZE * col - GRID_WIDTH_HALF, 0, GRID_WIDTH,
                    CELL_SIZE * 6 - 1, GRID_WIDTH, GRID_WIDTH);
        }
    }
}
