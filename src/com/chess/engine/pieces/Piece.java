package com.chess.engine.pieces;

import com.chess.engine.Alliance;
import com.chess.engine.board.Move;
import com.chess.engine.board.Board;
import java.util.List;



public abstract class Piece {

    protected final int piecePosition;
    protected final Alliance pieceAlliance;

    Piece (final int piecePosition, final Alliance pieceAlliance){
        this.piecePosition = piecePosition;
        this.pieceAlliance = pieceAlliance;
    }

    // Takes a given board and calculates the given legal Moves for each piece
    public abstract List<Move> calculateLegalMoves(final Board board);

    
}
