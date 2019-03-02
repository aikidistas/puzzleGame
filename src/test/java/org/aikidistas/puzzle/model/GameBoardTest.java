package org.aikidistas.puzzle.model;


import org.aikidistas.puzzle.model.service.GameBoardModifierService;
import org.aikidistas.puzzle.model.service.GameBoardValidatorService;
import org.junit.jupiter.api.Test;

import static org.aikidistas.puzzle.model.GameBoard.EMPTY_CELL;
import static org.junit.jupiter.api.Assertions.*;

// TODO: move some tests to other separate test classes
@SuppressWarnings("squid:S00100")
class GameBoardTest {
    @Test
    void createFrom2DArrayAndEmptyCellCoordinate() {
        // GIVEN
        int[][] expectedBoard = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, EMPTY_CELL},
                {13, 14, 15, 12}
        };

        // WHEN
        GameBoard board = new CustomGameBoardFactory().createFrom2DArrayAndEmptyCellCoordinate(expectedBoard, new Coordinate(2, 3));

        // THEN
        assertArrayEquals(expectedBoard, board.getBoard());
    }

    @Test
    void createFrom2DArrayAndEmptyCellCoordinate_shouldMarkProvidedCellAsEmpty() {
        // GIVEN
        int[][] boardWithoutEmptyCell = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };

        // WHEN
        GameBoard board = new CustomGameBoardFactory().createFrom2DArrayAndEmptyCellCoordinate(boardWithoutEmptyCell, new Coordinate(3, 3));

        // THEN
        int[][] expectedBoardWithEmptyCell = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, EMPTY_CELL}
        };
        assertArrayEquals(expectedBoardWithEmptyCell, board.getBoard());
    }

    @Test
    void createShuffledGameBoard() {
        // WHEN
        GameBoard board = new ShuffledGameBoardFactory(new GameBoardModifierService(), new GameBoardValidatorService())
                .createShuffledGameBoard();

        // THEN
        for (int i = 0; i < 1; i++) {
            assertFalse(new GameBoardValidatorService().isSolved(board));
        }
    }

    @Test
    void isSolved() {
        // GIVEN
        int[][] solvedBoard = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, EMPTY_CELL}
        };
        GameBoard board = new CustomGameBoardFactory().createFrom2DArrayAndEmptyCellCoordinate(
                solvedBoard, new Coordinate(3, 3)
        );

        // THEN
        assertTrue(new GameBoardValidatorService().isSolved(board));
    }

    @Test
    void moveUp() {
        // GIVEN
        int[][] originalBoard = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, EMPTY_CELL}
        };
        GameBoard board = new CustomGameBoardFactory().createFrom2DArrayAndEmptyCellCoordinate(
                originalBoard, new Coordinate(3, 3)
        );

        // WHEN
        new GameBoardModifierService().moveUp(board);

        // THEN
        int[][] expectedBoard = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, EMPTY_CELL},
                {13, 14, 15, 12}
        };
        assertArrayEquals(expectedBoard, board.getBoard());
    }

    @Test
    void moveUp_whenActionIsIllegal_DoNotMove() {
        // GIVEN
        int[][] originalBoard = {
                {1, 2, 3, EMPTY_CELL},
                {5, 6, 7, 4},
                {9, 10, 11, 8},
                {13, 14, 15, 12}
        };
        GameBoard board = new CustomGameBoardFactory().createFrom2DArrayAndEmptyCellCoordinate(
                originalBoard, new Coordinate(0, 3)
        );

        // WHEN
        new GameBoardModifierService().moveUp(board);

        // THEN
        int[][] expectedBoard = {
                {1, 2, 3, EMPTY_CELL},
                {5, 6, 7, 4},
                {9, 10, 11, 8},
                {13, 14, 15, 12}
        };
        assertArrayEquals(expectedBoard, board.getBoard());
    }

    @Test
    void moveDown() {
        // GIVEN
        int[][] originalBoard = {
                {1, 2, 3, EMPTY_CELL},
                {5, 6, 7, 4},
                {9, 10, 11, 8},
                {13, 14, 15, 12}
        };
        GameBoard board = new CustomGameBoardFactory().createFrom2DArrayAndEmptyCellCoordinate(
                originalBoard, new Coordinate(0, 3)
        );

        // WHEN
        new GameBoardModifierService().moveDown(board);

        // THEN
        int[][] expectedBoard = {
                {1, 2, 3, 4},
                {5, 6, 7, EMPTY_CELL},
                {9, 10, 11, 8},
                {13, 14, 15, 12}
        };
        assertArrayEquals(expectedBoard, board.getBoard());
    }

    @Test
    void moveDown_whenActionIsIllegal_DoNotMove() {
        // GIVEN
        int[][] originalBoard = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, EMPTY_CELL}
        };
        GameBoard board = new CustomGameBoardFactory().createFrom2DArrayAndEmptyCellCoordinate(
                originalBoard, new Coordinate(3, 3)
        );

        // WHEN
        new GameBoardModifierService().moveDown(board);

        // THEN
        int[][] expectedBoard = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, EMPTY_CELL}
        };
        assertArrayEquals(expectedBoard, board.getBoard());
    }

    @Test
    void moveLeft() {
        // GIVEN
        int[][] originalBoard = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, EMPTY_CELL}
        };
        GameBoard board = new CustomGameBoardFactory().createFrom2DArrayAndEmptyCellCoordinate(
                originalBoard, new Coordinate(3, 3)
        );

        // WHEN
        new GameBoardModifierService().moveLeft(board);

        // THEN
        int[][] expectedBoard = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, EMPTY_CELL, 15}
        };
        assertArrayEquals(expectedBoard, board.getBoard());
    }

    @Test
    void moveLeft_whenActionIsIllegal_DoNotMove() {
        // GIVEN
        int[][] originalBoard = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {EMPTY_CELL, 13, 14, 15}
        };
        GameBoard board = new CustomGameBoardFactory().createFrom2DArrayAndEmptyCellCoordinate(
                originalBoard, new Coordinate(3, 0)
        );

        // WHEN
        new GameBoardModifierService().moveLeft(board);

        // THEN
        int[][] expectedBoard = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {EMPTY_CELL, 13, 14, 15}
        };
        assertArrayEquals(expectedBoard, board.getBoard());
    }

    @Test
    void moveRight() {
        // GIVEN
        int[][] originalBoard = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {EMPTY_CELL, 13, 14, 15}
        };
        GameBoard board = new CustomGameBoardFactory().createFrom2DArrayAndEmptyCellCoordinate(
                originalBoard, new Coordinate(3, 0)
        );

        // WHEN
        new GameBoardModifierService().moveRight(board);

        // THEN
        int[][] expectedBoard = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, EMPTY_CELL, 14, 15}
        };
        assertArrayEquals(expectedBoard, board.getBoard());
    }

    @Test
    void moveRight_whenActionIsIllegal_DoNotMove() {
        // GIVEN
        int[][] originalBoard = {
                {1, 2, 3, EMPTY_CELL},
                {5, 6, 7, 4},
                {9, 10, 11, 8},
                {13, 14, 15, 12}
        };
        GameBoard board = new CustomGameBoardFactory().createFrom2DArrayAndEmptyCellCoordinate(
                originalBoard, new Coordinate(0, 3)
        );

        // WHEN
        new GameBoardModifierService().moveRight(board);

        // THEN
        int[][] expectedBoard = {
                {1, 2, 3, EMPTY_CELL},
                {5, 6, 7, 4},
                {9, 10, 11, 8},
                {13, 14, 15, 12}
        };
        assertArrayEquals(expectedBoard, board.getBoard());
    }

    @Test
    void getBoard_returnsCopyOfItsInternalState_soThatChangingReturnedValueOutsideDoesntChangeBoardsInternalState() {
        // GIVEN
        int[][] internalBoardState = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, EMPTY_CELL}
        };
        GameBoard board = new CustomGameBoardFactory().createFrom2DArrayAndEmptyCellCoordinate(
                internalBoardState, new Coordinate(3, 3)
        );

        // WHEN
        int[][] externallyAvailableCopyOfBoardState = board.getBoard();
        externallyAvailableCopyOfBoardState[0][0] = 1234;

        // THEN
        int[][] expectedBoardWithEmptyCell = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, EMPTY_CELL}
        };
        assertArrayEquals(expectedBoardWithEmptyCell, board.getBoard());
    }
}