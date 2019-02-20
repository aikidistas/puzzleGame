package org.aikidistas.puzzle.model;

import lombok.extern.log4j.Log4j2;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Log4j2
public enum Action {
    UP {
        public GameBoard applyTo(GameBoard gameBoard) {
            gameBoard.moveUp();
            return gameBoard;
        }
    },
    DOWN {
        public GameBoard applyTo(GameBoard gameBoard) {
            gameBoard.moveDown();
            return gameBoard;
        }
    },
    LEFT {
        public GameBoard applyTo(GameBoard gameBoard) {
            gameBoard.moveLeft();
            return gameBoard;
        }
    },
    RIGHT {
        public GameBoard applyTo(GameBoard gameBoard) {
            gameBoard.moveRight();
            return gameBoard;
        }
    },
    QUIT {
        public GameBoard applyTo(GameBoard gameBoard) {
            return gameBoard;
        }
    };

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
