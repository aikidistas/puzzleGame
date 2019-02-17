package org.aikidistas.puzzle.view;

import org.aikidistas.puzzle.model.GameBoard;
import org.aikidistas.puzzle.userinteraction.OutputHandler;

public class GameView {
    private GameBoard gameBoard;
    private OutputHandler outputHandler;

    public GameView(GameBoard gameBoard, OutputHandler outputHandler) {
        this.gameBoard = gameBoard;
        this.outputHandler = outputHandler;
    }
}
