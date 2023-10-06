public class GameLogic {
    int TOTALROWS = 3;
    int TOTALCOLUMNS = 3;

    public enum Cell {
        EMPTY, CROSS, NOUGHT
    }

    protected Cell[][] grid;
    protected char turn;

    public enum GameState {
        PLAYING, DRAW, CROSS_WON, NOUGHT_WON
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
        turn = 'X';
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
    public void makeMove(int row, int column) {
        if (row >= 0 && row < TOTALROWS && column >= 0 && column < TOTALCOLUMNS && grid[row][column] == Cell.EMPTY) {
            grid[row][column] = (turn == 'X') ? Cell.CROSS : Cell.NOUGHT;
//            updateGameState(turn, row, column);
            turn = (turn == 'X') ? 'O' : 'X';
        }
    }

    public GameState getGameState() {
        return currentGameState;
    }


}
