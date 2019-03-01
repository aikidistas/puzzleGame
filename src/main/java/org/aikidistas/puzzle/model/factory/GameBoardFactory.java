package org.aikidistas.puzzle.model.factory;

import org.aikidistas.puzzle.model.Coordinate;
import org.aikidistas.puzzle.model.GameBoard;

import static org.aikidistas.puzzle.model.GameBoard.EMPTY_CELL;

public class GameBoardFactory {

    private GameBoardFactory() {

    }

    public static GameBoard createFrom2DArrayAndEmptyCellCoordinate(int[][] newBoard, Coordinate emptyCell) {
        return new GameBoard(newBoard, emptyCell);
    }

    public static GameBoard createSolvedGameBoard() {
        return new GameBoard(new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, EMPTY_CELL}
        });
    }

    public static GameBoard createShuffledGameBoard() {
        return createSolvedGameBoard().shuffle();
    }
}
