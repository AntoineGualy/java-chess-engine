package com.chess.engine.board;

import java.util.HashMap;
import java.util.Map;

import com.chess.engine.pieces.Piece;

public abstract class Tile {

    protected final int tileCoordinate;

    Tile(int tileCoordinate) {
        this.tileCoordinate = tileCoordinate;
    }
    
    // This method checks if the tile is Occupied 
    public abstract boolean isTileOccupied();
    
    // A Map stores data in key-value pairs. every key is unique and leads to an exact value 
    private static final Map<Integer, EmptyTile> EMPTY_TILES = createAllPossibleEmptyTiles(); 

    private static Map<Integer, EmptyTile> createAllPossibleEmptyTiles() {

        final Map<Integer, EmptyTile> emptyTileMap = new HashMap<>();

        for(int i = 0; i < 64; i++) {
            // Format Map.put(key, value)
            emptyTileMap.put(i, new EmptyTile(i));
        }
        return Map.copyOf(emptyTileMap);
    }
    
    // ternary operator. shorter version of an if-else statement
    public static Tile createTile(final int tileCoordinate, final Piece piece) {
        return piece != null ? new OccupiedTile(tileCoordinate, piece) : EMPTY_TILES.get(tileCoordinate);
    }
    /* public static Tile createTile(final int tileCoordinate, final Piece piece) {
    if (piece != null) {
        return new OccupiedTile(tileCoordinate, piece);
    } else {
        return EMPTY_TILES.get(tileCoordinate);
    }*/


    // This method checks for which peiece is on the square
    public abstract Piece getPiece();

    

    public static final class EmptyTile extends Tile {
        EmptyTile(final int coordinate) {
            super(coordinate);
        }
        
        @Override
        public boolean isTileOccupied() {
            return false;
        }

        @Override 
        public Piece getPiece() {
            return null;
        }
    }


    public static final class OccupiedTile extends Tile {
        private final  Piece pieceOnTile;

        OccupiedTile(int tileCoordinate, Piece pieceOnTile) {
            super(tileCoordinate);
            this.pieceOnTile = pieceOnTile;
        }

        @Override
        public boolean isTileOccupied() {
            return true;
        }

        @Override
        public Piece getPiece() {
            return pieceOnTile;
        }
    }


    
}
