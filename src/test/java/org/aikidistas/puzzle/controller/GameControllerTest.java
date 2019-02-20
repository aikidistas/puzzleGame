package org.aikidistas.puzzle.controller;

import org.aikidistas.puzzle.model.GameBoard;
import org.aikidistas.puzzle.userinteraction.InputHandler;
import org.aikidistas.puzzle.view.GameView;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GameControllerTest {
    @InjectMocks
    private GameController controller;
    //
    @Mock
    private GameBoard gameBoard;
    //
    @Mock
    private GameView gameView;
    //
    @Mock
    private InputHandler inputHandler;

    @Test
    void start() {
        // GIVEN
        when(inputHandler.getUserChoice(anyString(), anyList())).thenReturn("UP", "UP", "QUIT");

        // WHEN
        controller.start();

        // THEN
        BDDMockito.verify(gameBoard, BDDMockito.atLeast(2)).moveUp();


//        verify(mockBar, times(2)).doSomething(...)
//        ArgumentCaptor<Person> peopleCaptor = ArgumentCaptor.forClass(Person.class);
//        verify(mock, times(2)).doSomething(peopleCaptor.capture());
//
//        List<Person> capturedPeople = peopleCaptor.getAllValues();
//        assertEquals("John", capturedPeople.get(0).getName());
//        assertEquals("Jane", capturedPeople.get(1).getName());
    }
}