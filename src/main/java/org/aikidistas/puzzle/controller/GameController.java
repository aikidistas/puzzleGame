package org.aikidistas.puzzle.controller;

import org.aikidistas.puzzle.model.GameBoard;
import org.aikidistas.puzzle.userinteraction.InputHandler;
import org.aikidistas.puzzle.view.GameView;

public class GameController {
    private GameBoard model;
    private GameView view;
    private InputHandler inputHandler;

    public GameController(GameBoard model, GameView view, InputHandler inputHandler) {
        this.model = model;
        this.view = view;
        this.inputHandler = inputHandler;
    }

    public void start() {

    }

}
