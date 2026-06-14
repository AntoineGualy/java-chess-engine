public abstract class Tile {

    private int tileCoordinate;

    Tile(int tileCoordinate) {
        this.tileCoordinate = tileCoordinate;
    }
    
    // This method checks if the tile is Occupied 
    public abstract boolean isTileOccupied();

    // This method checks for which peiece is on the square
    public abstract Piece getPiece();

    public static final class EmptyTile extends Tile {
        EmptyTile(int coordinate) {
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
        Piece pieceOnTile;

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
