package sprint2.product;

import javax.swing.*;

public class GameLogic {
    int TOTALROWS;
    int TOTALCOLUMNS;

    public enum Cell {
        EMPTY, SNAKE, NOUGHT
    }
    protected Cell[][] grid;
    protected String turn;

    public enum GameState {
        PLAYING, DRAW, RED_WON, BLUE_WON
    }
    protected GameState currentGameState;

    public GameLogic(int userSize) {
        TOTALROWS = userSize;
        TOTALCOLUMNS = userSize;
        grid = new Cell[TOTALROWS][TOTALCOLUMNS];
        initGame();
    }
    private void initGame() {
        for (int row = 0; row < TOTALROWS; ++row) {
            for (int col = 0; col < TOTALCOLUMNS; ++col) {
                grid[row][col] = Cell.EMPTY;
            }
        }
        currentGameState = GameState.PLAYING;
        turn = "red";
    }
    public void resetGame() {
        initGame();
    }
    public int getTotalRows() {
        return TOTALROWS;
    }
    public int getTotalColumns() {
        return TOTALCOLUMNS;
    }
    public Cell getCell(int row, int column) {
        if (row >= 0 && row < TOTALROWS && column >= 0 && column < TOTALCOLUMNS) {
            return grid[row][column];
        } else {
            return null;
        }
    }
    public void makeMove(int row, int column, String userLetter) {
        if (row >= 0 && row < TOTALROWS && column >= 0 && column < TOTALCOLUMNS && grid[row][column] == Cell.EMPTY) {
            grid[row][column] = (userLetter == "S") ? Cell.SNAKE : Cell.NOUGHT;
            updateGameState(turn, row, column);
            turn = (turn == "red") ? "blue" : "red";
        }
    }
    private void updateGameState(String turn, int row, int column) {
        if (checkSOS()) { // check for win
            currentGameState = (turn == "red") ? GameState.RED_WON : GameState.BLUE_WON;
            System.out.println(currentGameState);
        } else if (isDraw()) {
            currentGameState = GameState.DRAW;
        }
        // Otherwise, no change to current state (still GameState.PLAYING).
    }
    private boolean checkSOS() {
//        try {
            for (int row = 0; row < TOTALROWS; row++) {
                for (int col = 0; col < TOTALCOLUMNS; col++) {
                    if (col >= 2 && row < TOTALROWS - 2) {
                        if (checkBackwardsDiagonalWin(row, col)) {
                            return true;
                        }
                    }
                    if (col < TOTALCOLUMNS - 2 && row < TOTALROWS - 2) {
                        if (checkDiagonalWin(row, col)) {
                            return true;
                        }
                    }
                    if (col < TOTALCOLUMNS - 2) {
                        if (checkHorizontalWin(row, col)) {
                            return true;
                        }
                    }
                    if (row < TOTALROWS - 2) {
                        if (checkVerticalWin(row, col)) {
                            return true;
                        }
                    }
                }
            }
//        }catch (ArrayIndexOutOfBoundsException e){
//            System.out.println("Cannot check diagonal or backwards diagonal on this move");
//        }
        return false;
    }
    private boolean isDraw() {
        for (int row = 0; row < TOTALROWS; ++row) {
            for (int col = 0; col < TOTALCOLUMNS; ++col) {
                if (grid[row][col] == Cell.EMPTY) {
                    return false; // an empty cell found, not draw
                }
            }
        }
        return true;
    }

    public GameState getGameState() {
        return currentGameState;
    }
    public String getTurn() {
        return turn;
    }

    private boolean checkBackwardsDiagonalWin(int i, int j){
        assert (i <= TOTALROWS - 2 && j <= TOTALCOLUMNS - 2);
        return grid[i][j] == Cell.SNAKE && grid[i + 1][j + 1] == Cell.NOUGHT && grid[i + 2][j + 2] == Cell.SNAKE;
    }
    private boolean checkDiagonalWin(int i, int j) {
        assert (i <= TOTALROWS - 2 && j <= TOTALCOLUMNS - 2);
        if (i == 0 || j == 0){
            return false;
        }
        return grid[i][j] == Cell.SNAKE && grid[i - 1][j + 1] == Cell.NOUGHT && grid[i - 2][j + 2] == Cell.SNAKE;
    }
    private boolean checkHorizontalWin(int i, int j) {
        assert (i <= TOTALROWS && j <= TOTALCOLUMNS - 2);
        return grid[i][j] == Cell.SNAKE && grid[i][j + 1] == Cell.NOUGHT && grid[i][j + 2] == Cell.SNAKE;
    }
    private boolean checkVerticalWin(int i, int j){
        assert (i <= TOTALROWS - 2 && j <= TOTALCOLUMNS);
        return grid[i][j] == Cell.SNAKE && grid[i + 1][j] == Cell.NOUGHT &&grid[i + 2][j] == Cell.SNAKE;
    }


}
