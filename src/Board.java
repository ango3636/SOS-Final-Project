import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Board extends JPanel {
    int GAME_BOARD_SIZE = 270;
    int CELL_SIZE = GAME_BOARD_SIZE/6;
    int GRID_WIDTH = 2;
    int GRID_WIDTH_HALF = GRID_WIDTH / 2;
    int CELL_PADDING = CELL_SIZE / 6;
    public static final int SYMBOL_STROKE_WIDTH = 8;
    int SYMBOL_SIZE = CELL_SIZE - CELL_PADDING * 2;
    int userSize;

//    boolean playerTurn;
//    JPanel buttonPanel = new JPanel();
//    JButton[] buttons = new JButton[userSize];
    GameLogic game;
    Board(){
        Border outline = BorderFactory.createLineBorder(Color.BLACK,5);
        setBorder(outline);
        userSize = 6;
    }
    public Board(int userSize){
        this.userSize = userSize;
        this.game = new GameLogic(userSize);
        Border outline = BorderFactory.createLineBorder(Color.BLACK,5);
        setBorder(outline);
        CELL_SIZE = GAME_BOARD_SIZE/userSize;
        CELL_PADDING = CELL_SIZE / userSize;
        addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (game.getGameState() == GameLogic.GameState.PLAYING) {
                    int rowSelected = e.getY() / CELL_SIZE;
                    int colSelected = e.getX() / CELL_SIZE;
                    game.makeMove(rowSelected, colSelected);
                } else {
                    game.resetGame();
                    ;
                }
                repaint();
            }
        });
    }
    public void newSize(int newSize){
        userSize = newSize;
        CELL_SIZE = GAME_BOARD_SIZE/newSize;
        CELL_PADDING = CELL_SIZE / newSize;
        repaint();
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Color.WHITE);
        drawGridLines(g);
        drawBoard(g);
    }
    private void drawGridLines(Graphics g) {
        g.setColor(Color.PINK);
        for (int row = 1; row < userSize; ++row) {
            g.fillRoundRect(0, CELL_SIZE * row - GRID_WIDTH_HALF, CELL_SIZE * userSize - 1, GRID_WIDTH,
                    GRID_WIDTH, GRID_WIDTH);
        }
        for (int col = 1; col < userSize; ++col) {
            g.fillRoundRect(CELL_SIZE * col - GRID_WIDTH_HALF, 0, GRID_WIDTH,
                    CELL_SIZE * userSize - 1, GRID_WIDTH, GRID_WIDTH);
        }
    }
    private void drawBoard(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(SYMBOL_STROKE_WIDTH, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
        for (int row = 0; row < userSize; ++row) {
            for (int col = 0; col < userSize; ++col) {
                int x1 = col * CELL_SIZE + CELL_PADDING;
                int y1 = row * CELL_SIZE + CELL_PADDING;
//                if (game.getCell(row, col) == GameLogic.Cell.CROSS) {
//                    g2d.setColor(Color.RED);
//                    int x2 = (col + 1) * CELL_SIZE - CELL_PADDING;
//                    int y2 = (row + 1) * CELL_SIZE - CELL_PADDING;
//                    g2d.drawLine(x1, y1, x2, y2);
//                    g2d.drawLine(x2, y1, x1, y2);
//                } else if (game.getCell(row, col) == GameLogic.Cell.NOUGHT) {
//                    g2d.setColor(Color.BLUE);
//                    g2d.drawOval(x1, y1, SYMBOL_SIZE, SYMBOL_SIZE);
//                }
            }
        }
    }
//    private void drawBoard(){
//        buttonPanel.setLayout(new GridLayout(userSize,userSize));
//        buttonPanel.setBackground(Color.PINK);
//
//        for (int i = 0; i<9 ; i++){
//            buttons[i] = new JButton();
//            buttonPanel.add(buttons[i]);
//            buttons[i].setFont(new Font("MV Boli", Font.BOLD, 120));
//            buttons[i].setFocusable(false);
//            buttons[i].addActionListener(new Board.boardListener());
//        }
//    }
//    private class boardListener implements ActionListener {
//        public void actionPerformed(ActionEvent e) {
//            for (int i = 0; i < 9; i++) {
//                if (e.getSource() == buttons[i]) {
//                    if (playerTurn) {
//                        if (buttons[i].getText() == "") {
//                            buttons[i].setForeground(new Color(255, 0, 0));
//                            buttons[i].setText("S");
//                            playerTurn = false;
////                        text.setText("Player 2's Turn");
////                        check();
//                        }
//                    } else {
//                        if (buttons[i].getText() == "") {
//                            buttons[i].setForeground(new Color(0, 0, 255));
//                            buttons[i].setText("S");
//                            playerTurn = true;
////                        text.setText("Player 1's Turn");
////                        check();
//                        }
//                    }
//                }
//            }
//        }
//    }
}
