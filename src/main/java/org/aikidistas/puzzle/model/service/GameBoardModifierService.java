package org.aikidistas.puzzle.model.service;

import org.aikidistas.puzzle.model.Action;
import org.aikidistas.puzzle.model.CellOutOfBoardException;
import org.aikidistas.puzzle.model.Coordinate;
import org.aikidistas.puzzle.model.GameBoard;

public class GameBoardModifierService {
    private static final int NUMBER_OF_RANDOM_MOVES = 200;

    public GameBoard shuffle(GameBoard gameBoard) {
        for (int i = 0; i < NUMBER_OF_RANDOM_MOVES; i++) {
            applyRandomMove(gameBoard);
        }
        return gameBoard;
    }

    private void applyRandomMove(GameBoard gameBoard) {
        Action.getRandomMove().applyTo(gameBoard);
    }

    public void moveUp(GameBoard gameBoard) {
        move(gameBoard, gameBoard.getEmptyCell().getNeighbourUp());
    }

    public void moveDown(GameBoard gameBoard) {
        move(gameBoard, gameBoard.getEmptyCell().getNeighbourDown());
    }

    public void moveLeft(GameBoard gameBoard) {
        move(gameBoard, gameBoard.getEmptyCell().getNeighbourLeft());
    }

    public void moveRight(GameBoard gameBoard) {
        move(gameBoard, gameBoard.getEmptyCell().getNeighbourRight());
    }

    private void move(GameBoard gameBoard, Coordinate targetCell) {
        try {
            gameBoard.switchCellsContent(gameBoard.getEmptyCell(), targetCell);
            gameBoard.setEmptyCell(targetCell);
        } catch (CellOutOfBoardException e) {
            // We do nothing here. It is ok to just ignore users move outside board
        }
    }
}
