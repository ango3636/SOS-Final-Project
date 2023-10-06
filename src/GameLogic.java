public class GameLogic {
    protected static final int TOTALROWS = 3;
    protected static final int TOTALCOLUMNS = 3;

    public enum Cell {
        EMPTY, CROSS, NOUGHT
    }

    protected Cell[][] grid;
    protected char turn;

    public enum GameState {
        PLAYING, DRAW, CROSS_WON, NOUGHT_WON
    }
    protected GameState currentGameState;
    GameOptions userOptions;

    public GameLogic(GameOptions userOptions) {
        this.userOptions = userOptions;
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

}
