package org.aikidistas.puzzle.controller;

import org.aikidistas.puzzle.model.Action;
import org.aikidistas.puzzle.model.GameBoard;
import org.aikidistas.puzzle.model.service.GameBoardService;
import org.aikidistas.puzzle.userinteraction.InputHandler;
import org.aikidistas.puzzle.view.GameView;

public class GameController {
    private static final String CHOOSE_ACTION_TEXT = "Choose action:";
    private GameBoard gameBoard;
    private GameView view;
    private InputHandler inputHandler;
    private GameBoardService gameBoardService;

    public GameController(GameView view, InputHandler inputHandler, GameBoardService gameBoardService) {
        this.view = view;
        this.inputHandler = inputHandler;
        this.gameBoardService = gameBoardService;
    }

    public void start() {
        generateRandomBoard();
        drawBoard();
        Action action = handleUserAction();

        while (action != Action.QUIT) {
            drawBoard();
            action = handleUserAction();
        }
    }

    private void generateRandomBoard() {
        gameBoard = gameBoardService.getShuffledGameBoard();
    }

    private Action handleUserAction() {
        Action action = getUserAction();
        gameBoard = action.applyTo(gameBoard);
        return action;
    }

    private void drawBoard() {
        view.render(gameBoard);
    }

    private Action getUserAction() {
        String actionText = inputHandler.getUserChoice(
                CHOOSE_ACTION_TEXT,
                Action.getAvailableActionsAsText()
        );

        return Action.valueOf(actionText);
    }
}
