package org.aikidistas.puzzle.model;

import org.aikidistas.puzzle.model.service.GameBoardModifierService;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public enum Action {
    UP {
        public GameBoard applyTo(GameBoard gameBoard) {
            gameBoardModifierService.moveUp(gameBoard);
            return gameBoard;
        }
    },
    DOWN {
        public GameBoard applyTo(GameBoard gameBoard) {
            gameBoardModifierService.moveDown(gameBoard);
            return gameBoard;
        }
    },
    LEFT {
        public GameBoard applyTo(GameBoard gameBoard) {
            gameBoardModifierService.moveLeft(gameBoard);
            return gameBoard;
        }
    },
    RIGHT {
        public GameBoard applyTo(GameBoard gameBoard) {
            gameBoardModifierService.moveRight(gameBoard);
            return gameBoard;
        }
    },
    QUIT {
        public GameBoard applyTo(GameBoard gameBoard) {
            return gameBoard;
        }
    };

    private static GameBoardModifierService gameBoardModifierService = new GameBoardModifierService();

    public static List<String> getAvailableActionsAsText() {
        return Arrays.stream(Action.values())
                .map(Enum::toString)
                .collect(Collectors.toList());
    }

    public static Action getRandomMove() {
        int randomMoveActionIndex = new Random().nextInt(getNumberOfActionsExcludingLastQuitAction());
        return Action.values()[randomMoveActionIndex];
    }

    private static int getNumberOfActionsExcludingLastQuitAction() {
        return Action.values().length - 1;
    }

    public abstract GameBoard applyTo(GameBoard gameBoard);
}
