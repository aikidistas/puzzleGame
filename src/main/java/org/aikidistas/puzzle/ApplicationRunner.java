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
        GameBoard model = new GameBoard();
        OutputHandler outputHandler = new OutputHandler(new PrintWriter(System.out, true));
        GameView view = new GameView(model, outputHandler);
        InputHandler inputHandler = new InputHandler(new Scanner(System.in), outputHandler);
        return new GameController(model, view, inputHandler);
    }
}
