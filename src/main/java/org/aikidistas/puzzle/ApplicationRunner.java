package org.aikidistas.puzzle;

import org.aikidistas.puzzle.controller.GameController;
import org.aikidistas.puzzle.model.GameBoard;
import org.aikidistas.puzzle.userinteraction.InputHandler;
import org.aikidistas.puzzle.userinteraction.OutputHandler;
import org.aikidistas.puzzle.view.GameView;

import java.io.PrintWriter;
import java.util.Scanner;

@java.lang.SuppressWarnings("squid:S106")
public class ApplicationRunner {

    public static void main(String[] args) {
        GameController controller = initializeGameController();
        controller.start();
    }

    private static GameController initializeGameController() {
        OutputHandler outputHandler = new OutputHandler(new PrintWriter(System.out, true));
        InputHandler inputHandler = new InputHandler(new Scanner(System.in), outputHandler);
        GameBoard model = new GameBoard();
        GameView view = new GameView(outputHandler);
        return new GameController(model, view, inputHandler);
    }
}
