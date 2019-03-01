package org.aikidistas.puzzle.view;

import org.aikidistas.puzzle.model.GameBoard;
import org.aikidistas.puzzle.model.service.GameBoardValidatorService;
import org.aikidistas.puzzle.userinteraction.OutputHandler;

import static org.aikidistas.puzzle.model.GameBoard.EMPTY_CELL;
import static org.aikidistas.puzzle.userinteraction.OutputHandler.LINE_SEPARATOR;

public class GameView {
    private static final String HEADER = "15 Puzzle game. Move around empty cell to solve it.";
    private static final String HEADER_SOLVED_BOARD = "You are the WINNER!!!!! Here is your solved board:";
    private static final String ROW_SEPARATOR = " --------------------- " + LINE_SEPARATOR;
    private static final String COLUMN_SEPARATOR = " | ";
    private OutputHandler outputHandler;
    private GameBoardValidatorService gameBoardValidatorService;

    public GameView(OutputHandler outputHandler, GameBoardValidatorService gameBoardValidatorService) {
        this.outputHandler = outputHandler;
        this.gameBoardValidatorService = gameBoardValidatorService;
    }

    public void render(GameBoard gameBoard) {
        displayHeader(gameBoard);
        displayBoard(gameBoard);
    }

    private void displayHeader(GameBoard gameBoard) {
        if (gameBoardValidatorService.isSolved(gameBoard)) {
            outputHandler.displayMessage(HEADER_SOLVED_BOARD);
        } else {
            outputHandler.displayMessage(HEADER);
        }
    }

    private void displayBoard(GameBoard gameBoard) {
        outputHandler.displayMessage(renderGameBoard(gameBoard));

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
        renderedRow
                .append(COLUMN_SEPARATOR)
                .append(LINE_SEPARATOR);
        return renderedRow.toString();
    }

    private String renderGameBoardCell(int cell) {
        return (cell != EMPTY_CELL) ? renderFullCell(cell) : renderEmptyCell();
    }

    private String renderEmptyCell() {
        return COLUMN_SEPARATOR + "  ";
    }

    private String renderFullCell(int cell) {
        return String.format("%s%2s", COLUMN_SEPARATOR, cell);
    }
}
