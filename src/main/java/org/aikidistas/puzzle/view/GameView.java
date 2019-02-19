package org.aikidistas.puzzle.view;

import lombok.AllArgsConstructor;
import org.aikidistas.puzzle.model.Cell;
import org.aikidistas.puzzle.model.GameBoard;
import org.aikidistas.puzzle.userinteraction.OutputHandler;

@AllArgsConstructor
public class GameView {
    public static final String HEADER = "Showing the game board:";
    private OutputHandler outputHandler;

    public void render(GameBoard gameBoard) {
        outputHandler.displayMessage(HEADER);
        outputHandler.displayMessage(renderGameBoard(gameBoard));
    }

    private String renderGameBoard(GameBoard gameBoard) {
        StringBuilder renderedGameBoard = new StringBuilder();
        for (Cell[] row : gameBoard.getBoard()) {
            renderedGameBoard.append(renderGameBoardRow(row));
        }
        return renderedGameBoard.toString();
    }

    private String renderGameBoardRow(Cell[] row) {
        StringBuilder renderedRow = new StringBuilder();
        for (Cell cell : row) {
            renderedRow.append(renderGameBoardCell(cell));
        }
        renderedRow.append("\n");
        return renderedRow.toString();
    }

    private String renderGameBoardCell(Cell cell) {
        return String.format(" %2s ", cell.getValue());
    }
}
