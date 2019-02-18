package org.aikidistas.puzzle.model.service;

import org.aikidistas.puzzle.model.Cell;
import org.aikidistas.puzzle.model.GameBoard;
import org.aikidistas.puzzle.model.exception.CellDoesNotExistException;

public class ActionLeftService extends ActionService {
    @Override
    public GameBoard applyTo(GameBoard gameBoard) {
        try {
            Cell emptyCell = this.getEmptyCell(gameBoard);
            Cell targetCell = this.getCellLeftFrom(emptyCell, gameBoard);
            this.switchCells(emptyCell, targetCell);
        } catch (CellDoesNotExistException e) {
        }

        return gameBoard;
    }
}
