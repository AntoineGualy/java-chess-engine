package com.chess.engine.pieces;

import java.util.ArrayList;
import java.util.List;

import com.chess.engine.Alliance;
import com.chess.engine.board.Board;
import com.chess.engine.board.Move;
import com.chess.engine.board.Tile;

public class Knight extends Piece {


    private final static int[] CANIDATE_MOVE_COORDINATES = {-17, -15, -10, -6, 6, 10, 15, 17};

    // This is the constructor for Knight and at the moment the only attributes are the super attributes from the Piece class
    Knight(final int piecePosition, final Alliance pieceAlliance) {
        super(piecePosition, pieceAlliance);
        //TODO Auto-generated constructor stub
    }

    //This methods overrides the calculateLegalMoves method from the Piece class
    @Override
    public List<Move> calculateLegalMoves(Board board) {
        // candidateDestinationCoordinate is the exact tile the knight can move on based on the piece position plus the CANIDATE_MOVE_COORDINATES
        int candidateDestinationCoordinate;
        final List<Move> legalMoves = new ArrayList<>();

        // this loops through CANIDATE_MOVE_COORDINATES. and gives all the possible moves 
        for(final int currentCandidate : CANIDATE_MOVE_COORDINATES) {
            candidateDestinationCoordinate = piecePosition + currentCandidate;

            if(candidateDestinationCoordinate >= 0 && candidateDestinationCoordinate < 64) {
                // stores the locate on the board 
                final Tile candidateDestinationTile = board.getTile(candidateDestinationCoordinate);

                if(! candidateDestinationTile.isTileOccupied()) {
                    legalMoves.add(new Move());
                }
                else {
                    final Piece pieceAtDestination = candidateDestinationTile.getPiece();
                    final Alliance pieceAlliance = pieceAtDestination.getPieceAlliance();

                    if(this.pieceAlliance != pieceAlliance) {
                        legalMoves.add(new Move());
                    }
                }
            }
        }
        // I am not using java so I can't us the immutableList method. 
        return List.copyOf(legalMoves);
    }

}
