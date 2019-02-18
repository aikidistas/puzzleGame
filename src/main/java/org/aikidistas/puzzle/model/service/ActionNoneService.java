package org.aikidistas.puzzle.model.service;


import org.aikidistas.puzzle.model.GameBoard;

public class ActionNoneService extends ActionService {
    @Override
    public GameBoard applyTo(GameBoard gameBoard) {
        return gameBoard;
    }
}
