package org.aikidistas.puzzle.model.service;

import org.aikidistas.puzzle.model.Coordinate;
import org.aikidistas.puzzle.model.GameBoard;
import org.aikidistas.puzzle.model.exception.CellDoesNotExistException;

public class ActionRightService extends ActionService {
    @Override
    public GameBoard applyTo(GameBoard gameBoard) {
        try {
            Coordinate emptyCoordinate = this.getEmptyCell(gameBoard);
            Coordinate targetCoordinate = this.getCellRightFrom(emptyCoordinate, gameBoard);
            gameBoard.switchCells(emptyCoordinate, targetCoordinate);
        } catch (CellDoesNotExistException e) {
        }

        return gameBoard;
    }
}
