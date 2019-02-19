package org.aikidistas.puzzle.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Coordinate {
    public static final int EMPTY_VALUE = 0;
    private final int x;
    private final int y;

    private Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static Coordinate fromCoordinates(int coordinateXInBoard, int coordinateYInBoard) {
        return new Coordinate(coordinateXInBoard, coordinateYInBoard);
    }
}
