package org.aikidistas.puzzle.controller;

import org.aikidistas.puzzle.model.Action;
import org.aikidistas.puzzle.model.GameBoard;
import org.aikidistas.puzzle.userinteraction.InputHandler;
import org.aikidistas.puzzle.view.GameView;

public class GameController {
    private static final String CHOOSE_ACTION_TEXT = "Choose action:";
    private GameView view;
    private InputHandler inputHandler;
    private GameBoard gameBoard;

    public GameController(GameBoard model, GameView view, InputHandler inputHandler) {
        this.gameBoard = model;
        this.view = view;
        this.inputHandler = inputHandler;
    }

    public void start() {
        drawBoard();
        Action action = handleUserAction();

        while (action != Action.QUIT) {
            drawBoard();
            action = handleUserAction();
        }
    }

    private void drawBoard() {
        view.render(gameBoard);
    }

    private Action handleUserAction() {
        Action action = getUserAction();
        gameBoard = action.applyTo(gameBoard);
        return action;
    }

    private Action getUserAction() {
        String actionText = inputHandler.getUserChoice(
                CHOOSE_ACTION_TEXT,
                Action.getAvailableActionsAsText()
        );

        return Action.valueOf(actionText);
    }
}
