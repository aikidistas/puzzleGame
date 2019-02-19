package org.aikidistas.puzzle.view;

import lombok.AllArgsConstructor;
import org.aikidistas.puzzle.model.GameBoard;
import org.aikidistas.puzzle.userinteraction.OutputHandler;

import static org.aikidistas.puzzle.model.GameBoard.EMPTY_CELL;

@AllArgsConstructor
public class GameView {
    public static final String HEADER = "15 Puzzle game. Move around empty cell to solve it.";
    public static final String HEADER_SOLVED_BOARD = "You are the WINNER!!!!! Here is your solved board:";
    public static final String ROW_SEPARATOR = " --------------------- \n";
    public static final String COLUMN_SEPARATOR = " | ";
    private OutputHandler outputHandler;

    public void render(GameBoard gameBoard) {
        displayHeader(gameBoard);
        displayBoard(gameBoard);
    }

    private void displayBoard(GameBoard gameBoard) {
        outputHandler.displayMessage(renderGameBoard(gameBoard));

    }

    private void displayHeader(GameBoard gameBoard) {
        if (gameBoard.isSolved()) {
            outputHandler.displayMessage(HEADER_SOLVED_BOARD);
        } else {
            outputHandler.displayMessage(HEADER);
        }
    }

    private String renderGameBoard(GameBoard gameBoard) {
        StringBuilder renderedGameBoard = new StringBuilder();
        renderedGameBoard.append(ROW_SEPARATOR);
        for (int[] row : gameBoard.getBoard()) {
            renderedGameBoard.append(renderGameBoardRow(row));
            renderedGameBoard.append(ROW_SEPARATOR);
        }
        return renderedGameBoard.toString();
    }

    private String renderGameBoardRow(int[] row) {
        StringBuilder renderedRow = new StringBuilder();
        for (int cell : row) {
            renderedRow.append(renderGameBoardCell(cell));
        }
        renderedRow.append(COLUMN_SEPARATOR + "\n");
        return renderedRow.toString();
    }

    private String renderGameBoardCell(int cell) {
        return (cell != EMPTY_CELL) ? String.format(COLUMN_SEPARATOR + "%2s", cell) : COLUMN_SEPARATOR + "  ";
    }
}
