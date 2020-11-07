package view;

import logic.Game;
import utils.MyStringUtils;

public class GamePrinter {

    Game game;
    int numRows;
    int numCols;
    String[][] board;
    final String space = " ";

    /**
     * 
     * @param game instance of the current game
     * @param cols total number of columns
     * @param rows total number of rows
     */
    public GamePrinter(Game game, int cols, int rows) {
        this.game = game;
        this.numRows = rows;
        this.numCols = cols;
    }

    /**
     * Translates the arrays to an array of strings divided in cells
     * 
     * @param game instance of the current game
     * 
     */
    private void encodeGame(Game game) {
        board = new String[numRows][numCols];
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                board[i][j] = game.characterAtToString(i, j);
            }
        }
    }

    /**
     * @return the board of the game in the current cycle
     */
    public String toString() {
        encodeGame(game);
        int cellSize = 7;
        int marginSize = 2;
        String vDelimiter = "|";
        String hDelimiter = "-";
        String intersect = space;
        String vIntersect = space;
        String hIntersect = "-";
        String corner = space;

        String cellDelimiter = MyStringUtils.repeat(hDelimiter, cellSize);

        String rowDelimiter = vIntersect + MyStringUtils.repeat(cellDelimiter + intersect, numCols - 1) + cellDelimiter
                + vIntersect;
        String hEdge = corner + MyStringUtils.repeat(cellDelimiter + hIntersect, numCols - 1) + cellDelimiter + corner;

        String margin = MyStringUtils.repeat(space, marginSize);
        String lineEdge = String.format("%n%s%s%n", margin, hEdge);
        String lineDelimiter = String.format("%n%s%s%n", margin, rowDelimiter);

        StringBuilder str = new StringBuilder();

        str.append(lineEdge);
        for (int i = 0; i < numRows; i++) {
            str.append(margin).append(vDelimiter);
            for (int j = 0; j < numCols; j++)
                str.append(MyStringUtils.centre(board[i][j], cellSize)).append(vDelimiter);
            if (i != numRows - 1)
                str.append(lineDelimiter);
            else
                str.append(lineEdge);
        }

        return str.toString();
    }
}
