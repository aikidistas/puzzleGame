package org.aikidistas.puzzle.controller;

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
    void start() {
        // GIVEN
        when(inputHandler.getUserChoice(anyString(), anyList())).thenReturn("UP", "LEFT", "UP", "QUIT");

        // WHEN
        controller.start();

        // THEN
        verify(gameBoard, times(2)).moveUp();
        verify(gameBoard, times(1)).moveLeft();
        verify(gameView, times(4)).render(gameBoard);
    }
}