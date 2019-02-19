package org.aikidistas.puzzle.model.service;


import org.aikidistas.puzzle.model.Coordinate;
import org.aikidistas.puzzle.model.GameBoard;
import org.aikidistas.puzzle.model.exception.CellDoesNotExistException;

public class ActionDownService extends ActionService {
    @Override
    public GameBoard applyTo(GameBoard gameBoard) {
        try {
            Coordinate emptyCoordinate = this.getEmptyCell(gameBoard);
            Coordinate targetCoordinate = this.getCellDownFrom(emptyCoordinate, gameBoard);
            gameBoard.switchCells(emptyCoordinate, targetCoordinate);
        } catch (CellDoesNotExistException e) {
        }

        return gameBoard;
    }
}
