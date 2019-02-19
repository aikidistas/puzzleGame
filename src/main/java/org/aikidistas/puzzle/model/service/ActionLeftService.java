package org.aikidistas.puzzle.model.service;

import org.aikidistas.puzzle.model.Coordinate;
import org.aikidistas.puzzle.model.GameBoard;
import org.aikidistas.puzzle.model.exception.CellDoesNotExistException;

public class ActionLeftService extends ActionService {
    @Override
    public GameBoard applyTo(GameBoard gameBoard) {
        try {
            Coordinate emptyCoordinate = this.getEmptyCell(gameBoard);
            Coordinate targetCoordinate = this.getCellLeftFrom(emptyCoordinate, gameBoard);
            gameBoard.switchCells(emptyCoordinate, targetCoordinate);
        } catch (CellDoesNotExistException e) {
        }

        return gameBoard;
    }
}
