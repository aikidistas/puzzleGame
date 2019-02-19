package org.aikidistas.puzzle.model.service;

import lombok.extern.log4j.Log4j2;
import org.aikidistas.puzzle.model.Coordinate;
import org.aikidistas.puzzle.model.GameBoard;
import org.aikidistas.puzzle.model.exception.CellDoesNotExistException;

import static org.aikidistas.puzzle.model.GameBoard.BORDER_SIZE;
import static org.aikidistas.puzzle.model.GameBoard.EMPTY_CELL;

@Log4j2
@SuppressWarnings("squid:S1610")
public abstract class ActionService {
    public abstract GameBoard applyTo(GameBoard gameBoard);

    Coordinate getCellUpFrom(Coordinate coordinate, GameBoard gameBoard) throws CellDoesNotExistException {
        int x = coordinate.getX() - 1;
        int y = coordinate.getY();

        checkValidCoordinates(x, y);
        return new Coordinate(x, y);
    }

    Coordinate getCellDownFrom(Coordinate coordinate, GameBoard gameBoard) throws CellDoesNotExistException {
        int x = coordinate.getX() + 1;
        int y = coordinate.getY();

        checkValidCoordinates(x, y);
        return new Coordinate(x, y);
    }

    Coordinate getCellLeftFrom(Coordinate coordinate, GameBoard gameBoard) throws CellDoesNotExistException {
        int x = coordinate.getX();
        int y = coordinate.getY() - 1;

        checkValidCoordinates(x, y);

        return new Coordinate(x, y);
    }

    Coordinate getCellRightFrom(Coordinate coordinate, GameBoard gameBoard) throws CellDoesNotExistException {
        int x = coordinate.getX();
        int y = coordinate.getY() + 1;

        checkValidCoordinates(x, y);

        return new Coordinate(x, y);
    }

    private void checkValidCoordinates(int x, int y) throws CellDoesNotExistException {
        if ((x < 0) || (x >= BORDER_SIZE) || (y < 0) || (y >= BORDER_SIZE)) {
            throw new CellDoesNotExistException();
        }
    }

    Coordinate getEmptyCell(GameBoard gameBoard) {
        int[][] board = gameBoard.getBoard();
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[x].length; y++) {
                if (board[x][y] == EMPTY_CELL) {
                    return new Coordinate(x, y);
                }
            }
        }

        log.error("Unable to find empty cell in the board: " + gameBoard);
        throw new IllegalArgumentException();
    }
}
