package com.chess.engine.board;

public class BoardUtils {

    private BoardUtils() {
        throw new RuntimeException("You can't instantiate me!");
    }

    public static final boolean[] FIRST_COLUMN = null;

    public static boolean isValidTileCoordinate(final int coordinate) {
        return coordinate >= 0 && coordinate < 64;
    }
    
}
