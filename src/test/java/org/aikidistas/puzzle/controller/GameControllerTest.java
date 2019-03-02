package org.aikidistas.puzzle.controller;

import org.aikidistas.puzzle.model.CellOutOfBoardException;
import org.aikidistas.puzzle.model.Coordinate;
import org.aikidistas.puzzle.model.GameBoard;
import org.aikidistas.puzzle.userinteraction.InputHandler;
import org.aikidistas.puzzle.view.GameView;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class GameControllerTest {
    @InjectMocks
    private GameController controller;

    @Mock
    private GameBoard gameBoard;

    @Mock
    private GameView gameView;

    @Mock
    private InputHandler inputHandler;

    @Test
    void controller_rendersGameBoard_onceBeforeFirstUserChoice() {
        // GIVEN
        when(inputHandler.getUserChoice(anyString(), anyList())).thenReturn("QUIT");

        // WHEN
        controller.start();

        // THEN
        verify(gameView, times(1)).render(gameBoard);
    }

    @Test
    void controller_rendersGameBoard_onceBeforeFirstUserChoiceAndAfterEveryUserChoice() {
        // GIVEN
        when(inputHandler.getUserChoice(anyString(), anyList())).thenReturn("UP", "UP", "QUIT");
        when(gameBoard.getEmptyCell()).thenReturn(new Coordinate(0, 0));

        // WHEN
        controller.start();

        // THEN
        verify(gameView, times(3)).render(gameBoard);
    }

    @Test
    void controller_handlesMoveUp() throws CellOutOfBoardException {
        // GIVEN
        when(inputHandler.getUserChoice(anyString(), anyList())).thenReturn("UP", "UP", "QUIT");
        when(gameBoard.getEmptyCell()).thenReturn(new Coordinate(0, 0));

        // WHEN
        controller.start();

        // THEN
        verify(gameBoard, times(2)).switchCellsContent(eq(new Coordinate(0, 0)), eq(new Coordinate(-1, 0)));
        verify(gameBoard, times(2)).switchCellsContent(any(Coordinate.class), any(Coordinate.class));
    }

    @Test
    void controller_handlesMoveDown() throws CellOutOfBoardException {
        // GIVEN
        when(inputHandler.getUserChoice(anyString(), anyList())).thenReturn("DOWN", "DOWN", "QUIT");
        when(gameBoard.getEmptyCell()).thenReturn(new Coordinate(0, 0));

        // WHEN
        controller.start();

        // THEN
        verify(gameBoard, times(2)).switchCellsContent(eq(new Coordinate(0, 0)), eq(new Coordinate(1, 0)));
        verify(gameBoard, times(2)).switchCellsContent(any(Coordinate.class), any(Coordinate.class));
    }

    @Test
    void controller_handlesMoveLeft() throws CellOutOfBoardException {
        // GIVEN
        when(inputHandler.getUserChoice(anyString(), anyList())).thenReturn("LEFT", "LEFT", "QUIT");
        when(gameBoard.getEmptyCell()).thenReturn(new Coordinate(0, 0));

        // WHEN
        controller.start();

        // THEN
        verify(gameBoard, times(2)).switchCellsContent(eq(new Coordinate(0, 0)), eq(new Coordinate(0, -1)));
        verify(gameBoard, times(2)).switchCellsContent(any(Coordinate.class), any(Coordinate.class));
    }

    @Test
    void controller_handlesMoveRight() throws CellOutOfBoardException {
        // GIVEN
        when(inputHandler.getUserChoice(anyString(), anyList())).thenReturn("RIGHT", "RIGHT", "QUIT");
        when(gameBoard.getEmptyCell()).thenReturn(new Coordinate(0, 0));

        // WHEN
        controller.start();

        // THEN
        verify(gameBoard, times(2)).switchCellsContent(eq(new Coordinate(0, 0)), eq(new Coordinate(0, 1)));
        verify(gameBoard, times(2)).switchCellsContent(any(Coordinate.class), any(Coordinate.class));
    }

    @Test
    void controller_handlesMultipleMovesInDifferentDirections() throws CellOutOfBoardException {
        // GIVEN
        when(inputHandler.getUserChoice(anyString(), anyList())).thenReturn("UP", "LEFT", "RIGHT", "DOWN", "QUIT");
        when(gameBoard.getEmptyCell()).thenReturn(new Coordinate(0, 0));

        // WHEN
        controller.start();

        // THEN
        verify(gameBoard, times(1)).switchCellsContent(eq(new Coordinate(0, 0)), eq(new Coordinate(-1, 0)));
        verify(gameBoard, times(1)).switchCellsContent(eq(new Coordinate(0, 0)), eq(new Coordinate(1, 0)));
        verify(gameBoard, times(1)).switchCellsContent(eq(new Coordinate(0, 0)), eq(new Coordinate(0, -1)));
        verify(gameBoard, times(1)).switchCellsContent(eq(new Coordinate(0, 0)), eq(new Coordinate(0, 1)));
        verify(gameBoard, times(4)).switchCellsContent(any(Coordinate.class), any(Coordinate.class));
        verify(gameView, times(5)).render(gameBoard);
    }
}