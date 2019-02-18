package org.aikidistas.puzzle.model.service;

import lombok.extern.log4j.Log4j2;
import org.aikidistas.puzzle.model.Cell;
import org.aikidistas.puzzle.model.GameBoard;
import org.aikidistas.puzzle.model.exception.CellDoesNotExistException;

import static org.aikidistas.puzzle.model.GameBoard.BORDER_SIZE;

@Log4j2
public abstract class ActionService {
    public abstract GameBoard applyTo(GameBoard gameBoard);


    protected Cell getCellUpFrom(Cell cell, GameBoard gameBoard) throws CellDoesNotExistException {
        int x = cell.getCoordinateXInBoard() - 1;
        int y = cell.getCoordinateYInBoard();

        checkValidCoordinates(x, y);
        return gameBoard.getBoard()[x][y];
    }

    protected Cell getCellDownFrom(Cell cell, GameBoard gameBoard) throws CellDoesNotExistException {
        int x = cell.getCoordinateXInBoard() + 1;
        int y = cell.getCoordinateYInBoard();

        checkValidCoordinates(x, y);
        return gameBoard.getBoard()[x][y];
    }

    protected Cell getCellLeftFrom(Cell cell, GameBoard gameBoard) throws CellDoesNotExistException {
        int x = cell.getCoordinateXInBoard();
        int y = cell.getCoordinateYInBoard() - 1;

        checkValidCoordinates(x, y);

        return gameBoard.getBoard()[x][y];
    }

    protected Cell getCellRightFrom(Cell cell, GameBoard gameBoard) throws CellDoesNotExistException {
        int x = cell.getCoordinateXInBoard();
        int y = cell.getCoordinateYInBoard() + 1;

        checkValidCoordinates(x, y);

        return gameBoard.getBoard()[x][y];
    }

    protected void checkValidCoordinates(int x, int y) throws CellDoesNotExistException {
        if ((x < 0) || (x >= BORDER_SIZE) || (y < 0) || (y >= BORDER_SIZE)) {
            throw new CellDoesNotExistException();
        }
    }


    protected void switchCells(Cell cell1, Cell cell2) {
        int value = cell1.getValue();
        cell1.setValue(cell2.getValue());
        cell2.setValue(value);
    }

    protected Cell getEmptyCell(GameBoard gameBoard) {
        for (Cell[] row : gameBoard.getBoard()) {
            for (Cell cell : row) {
                if (cell.isEmpty()) {
                    return cell;
                }
            }
        }

        log.error("Unable to find empty cell in the board: " + gameBoard);
        throw new IllegalArgumentException();
    }
}
