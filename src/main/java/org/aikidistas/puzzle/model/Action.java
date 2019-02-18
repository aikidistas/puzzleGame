package org.aikidistas.puzzle.model;

import lombok.extern.log4j.Log4j2;
import org.aikidistas.puzzle.model.exception.CellDoesNotExistException;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import static org.aikidistas.puzzle.model.GameBoard.BORDER_SIZE;

@Log4j2
public enum Action {
    UP {
        public GameBoard applyTo(GameBoard gameBoard) {
            try {
                Cell emptyCell = this.getEmptyCell(gameBoard);
                Cell targetCell = this.getCellUpFrom(emptyCell, gameBoard);
                this.switchCells(emptyCell, targetCell);
            } catch (CellDoesNotExistException e) {
            }

            return gameBoard;
        }
    },
    DOWN {
        public GameBoard applyTo(GameBoard gameBoard) {
            try {
                Cell emptyCell = this.getEmptyCell(gameBoard);
                Cell targetCell = this.getCellDownFrom(emptyCell, gameBoard);
                this.switchCells(emptyCell, targetCell);
            } catch (CellDoesNotExistException e) {
            }

            return gameBoard;
        }
    },
    LEFT {
        public GameBoard applyTo(GameBoard gameBoard) {
            try {
                Cell emptyCell = this.getEmptyCell(gameBoard);
                Cell targetCell = this.getCellLeftFrom(emptyCell, gameBoard);
                this.switchCells(emptyCell, targetCell);
            } catch (CellDoesNotExistException e) {
            }

            return gameBoard;
        }
    },
    RIGHT {
        public GameBoard applyTo(GameBoard gameBoard) {
            try {
                Cell emptyCell = this.getEmptyCell(gameBoard);
                Cell targetCell = this.getCellRightFrom(emptyCell, gameBoard);
                this.switchCells(emptyCell, targetCell);
            } catch (CellDoesNotExistException e) {
            }

            return gameBoard;
        }
    },
    QUIT {
        public GameBoard applyTo(GameBoard gameBoard) {
            return gameBoard;
        }
    };

    public static List<String> getAvailableActionsAsText() {
        return Arrays.stream(Action.values()).map(Enum::toString).collect(Collectors.toList());
    }

    public static Action getRandomMove() {
        int pick = new Random().nextInt(Action.values().length - 1);
        return Action.values()[pick];
    }

    public abstract GameBoard applyTo(GameBoard gameBoard);

    protected Cell getCellUpFrom(Cell cell, GameBoard gameBoard) throws CellDoesNotExistException {
        int x = cell.getX() - 1;
        int y = cell.getY();

        checkValidCoordinates(x, y);
        return gameBoard.getBoard()[x][y];
    }

    protected Cell getCellDownFrom(Cell cell, GameBoard gameBoard) throws CellDoesNotExistException {
        int x = cell.getX() + 1;
        int y = cell.getY();

        checkValidCoordinates(x, y);
        return gameBoard.getBoard()[x][y];
    }

    protected Cell getCellLeftFrom(Cell cell, GameBoard gameBoard) throws CellDoesNotExistException {
        int x = cell.getX();
        int y = cell.getY() - 1;

        checkValidCoordinates(x, y);

        return gameBoard.getBoard()[x][y];
    }

    protected Cell getCellRightFrom(Cell cell, GameBoard gameBoard) throws CellDoesNotExistException {
        int x = cell.getX();
        int y = cell.getY() + 1;

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
