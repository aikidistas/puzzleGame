package org.aikidistas.puzzle.view;

import lombok.AllArgsConstructor;
import org.aikidistas.puzzle.model.GameBoard;
import org.aikidistas.puzzle.userinteraction.OutputHandler;

@AllArgsConstructor
public class GameView {
    private OutputHandler outputHandler;

    public void render(GameBoard gameBoard) {
        outputHandler.displayMessage("Showing the game board...");
    }
}
