package org.aikidistas.puzzle.view;

import org.aikidistas.puzzle.model.GameBoard;
import org.aikidistas.puzzle.userinteraction.OutputHandler;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class GameViewTest {

    @Test
    void render() {
        // GIVEN
        OutputHandler outputHandlerMock = Mockito.mock(OutputHandler.class);
        GameView view = new GameView(outputHandlerMock);

        GameBoard board = new GameBoard();
        board.setBoard(new int[][]{});
        view.render(board);

        // TODO: continue here
    }
}