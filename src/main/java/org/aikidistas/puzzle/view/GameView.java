package org.aikidistas.puzzle.view;

import lombok.AllArgsConstructor;
import org.aikidistas.puzzle.model.Cell;
import org.aikidistas.puzzle.model.GameBoard;
import org.aikidistas.puzzle.userinteraction.OutputHandler;

@AllArgsConstructor
public class GameView {
    private OutputHandler outputHandler;

    public void render(GameBoard gameBoard) {
        StringBuilder output = new StringBuilder();
        for (Cell[] row : gameBoard.getBoard()) {
            for (Cell cell : row) {
                output.append(String.format(" %2s ", cell.getValue()));
            }
            output.append("\n");
        }

        outputHandler.displayMessage("Showing the game board:");
        outputHandler.displayMessage(output.toString());
    }
}
