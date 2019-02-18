package org.aikidistas.puzzle.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Action {
    UP {
        public GameBoard applyTo(GameBoard gameBoard) {
            return gameBoard;
        }
    },
    DOWN {
        public GameBoard applyTo(GameBoard gameBoard) {
            return gameBoard;
        }
    },
    LEFT {
        public GameBoard applyTo(GameBoard gameBoard) {
            return gameBoard;
        }
    },
    RIGHT {
        public GameBoard applyTo(GameBoard gameBoard) {
            return gameBoard;
        }
    },
    QUIT {
        public GameBoard applyTo(GameBoard gameBoard) {
            return gameBoard;
        }
    };

    public static List<String> getAvailableActionsAsText() {
        return Arrays.stream(Action.values()).map(Enum::toString).collect(Collectors.toList());
    }

    public abstract GameBoard applyTo(GameBoard gameBoard);
}
