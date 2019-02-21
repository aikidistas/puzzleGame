package org.aikidistas.puzzle.view;

import org.aikidistas.puzzle.model.Coordinate;
import org.aikidistas.puzzle.model.GameBoard;
import org.aikidistas.puzzle.userinteraction.OutputHandler;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.PrintWriter;
import java.io.StringWriter;

import static org.aikidistas.puzzle.model.GameBoard.EMPTY_CELL;
import static org.aikidistas.puzzle.userinteraction.OutputHandler.LINE_SEPARATOR;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SuppressWarnings("squid:S1192")
class GameViewTest {

    StringWriter output;
    GameView view;

    @BeforeEach
    void setUp() {
        output = new StringWriter();
        OutputHandler outputHandler = new OutputHandler(new PrintWriter(output));
        view = new GameView(outputHandler);
    }

    @Test
    void renderSolvedBoard() {
        // GIVEN
        GameBoard board = GameBoard.createFrom2DArrayAndEmptyCellCoordinate(new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, EMPTY_CELL}
        }, new Coordinate(3, 3));

        // WHEN
        view.render(board);

        // THEN
        String expectedOutput = "You are the WINNER!!!!! Here is your solved board:" + LINE_SEPARATOR +
                " --------------------- " + LINE_SEPARATOR +
                " |  1 |  2 |  3 |  4 | " + LINE_SEPARATOR +
                " --------------------- " + LINE_SEPARATOR +
                " |  5 |  6 |  7 |  8 | " + LINE_SEPARATOR +
                " --------------------- " + LINE_SEPARATOR +
                " |  9 | 10 | 11 | 12 | " + LINE_SEPARATOR +
                " --------------------- " + LINE_SEPARATOR +
                " | 13 | 14 | 15 |    | " + LINE_SEPARATOR +
                " --------------------- " + LINE_SEPARATOR +
                LINE_SEPARATOR;
        Assertions.
                assertEquals(expectedOutput, output.toString());
    }

    @Test
    void renderRandomBoard() {
        // GIVEN
        GameBoard board = GameBoard.createFrom2DArrayAndEmptyCellCoordinate(new int[][]{
                {10, 3, 5, 6},
                {EMPTY_CELL, 4, 7, 9},
                {1, 2, 12, 8},
                {13, 14, 11, 15}
        }, new Coordinate(1, 0));

        // WHEN
        view.render(board);

        // THEN
        String expectedOutput = "15 Puzzle game. Move around empty cell to solve it." + LINE_SEPARATOR +
                " --------------------- " + LINE_SEPARATOR +
                " | 10 |  3 |  5 |  6 | " + LINE_SEPARATOR +
                " --------------------- " + LINE_SEPARATOR +
                " |    |  4 |  7 |  9 | " + LINE_SEPARATOR +
                " --------------------- " + LINE_SEPARATOR +
                " |  1 |  2 | 12 |  8 | " + LINE_SEPARATOR +
                " --------------------- " + LINE_SEPARATOR +
                " | 13 | 14 | 11 | 15 | " + LINE_SEPARATOR +
                " --------------------- " + LINE_SEPARATOR +
                LINE_SEPARATOR;
        assertEquals(expectedOutput, output.toString());
    }
}