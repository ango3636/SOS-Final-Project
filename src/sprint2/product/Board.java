package sprint2.product;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Board extends JPanel {
    int GAME_BOARD_SIZE = 270;
    int CELL_SIZE = GAME_BOARD_SIZE/6;
    int GRID_WIDTH = 2;
    int GRID_WIDTH_HALF = GRID_WIDTH / 2;
    int CELL_PADDING = CELL_SIZE / 6;
    public static final int SYMBOL_STROKE_WIDTH = 8;
    int userSize;
    public RedPlayer redPlayer;
    public BluePlayer bluePlayer;
    public String redMove, blueMove;
    public GameLogic game;
    public Board(int userSize){
        this.userSize = userSize;
        this.game = new GameLogic(userSize);
        redPlayer = new RedPlayer();
        bluePlayer = new BluePlayer();
        Border outline = BorderFactory.createLineBorder(Color.BLACK,3);
        setBorder(outline);
        addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (game.getGameState() == GameLogic.GameState.PLAYING) {
                    int rowSelected = e.getY() / CELL_SIZE;
                    int colSelected = e.getX() / CELL_SIZE;
                    if (game.getTurn() == "red"){
                        redMove = redPlayer.getFromThisString();
                        game.makeMove(rowSelected, colSelected,redMove);
                    }
                    else { //turn is blue
                        blueMove = bluePlayer.getFromThisString();
                        game.makeMove(rowSelected, colSelected,blueMove);
                    }
                }
                else {
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
        game.resetGame();
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
        g2d.setFont(new Font("Times New Roman", Font.BOLD, 20));
        for (int row = 0; row < userSize; ++row) {
            for (int col = 0; col < userSize; ++col) {
                int x1 = col * CELL_SIZE - CELL_PADDING ;
                int y1 = row * CELL_SIZE + CELL_PADDING ;
                g2d.setColor(Color.BLACK);
                if (game.getCell(row, col) == GameLogic.Cell.SNAKE) {
                        g2d.drawString("S", x1 + (CELL_SIZE / 2), y1 + (CELL_SIZE / 2));
                }
                else if (game.getCell(row, col) == GameLogic.Cell.NOUGHT) {
                        g2d.drawString("O", x1 + (CELL_SIZE / 2), y1 + (CELL_SIZE / 2));
                }
                if (game.getGameState() == GameLogic.GameState.RED_WON){
//                        g2d.drawLine(x1,y1,x2,y2);
                }
                else if (game.getGameState() == GameLogic.GameState.BLUE_WON){

                }
            }
        }
    }
    public String getGameMessage(){
        if (game.getGameState() == GameLogic.GameState.RED_WON){
            return "Red Player Wins!";
        }
        else if (game.getGameState() == GameLogic.GameState.BLUE_WON){
            return "Blue Player Wins!";
        }
        return game.getTurn() + " player's turn";
    }
    public JPanel getRedPanel(){ return redPlayer;}
    public JPanel getBluePanel(){return bluePlayer;}
}
