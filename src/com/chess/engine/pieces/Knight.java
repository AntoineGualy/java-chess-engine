package com.chess.engine.pieces;

import java.util.ArrayList;
import java.util.List;

import com.chess.engine.Alliance;
import com.chess.engine.board.Board;
import com.chess.engine.board.Move;
import com.chess.engine.board.Tile;
import com.chess.engine.board.BoardUtils;


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
        for(final int currentCandidateOffset : CANIDATE_MOVE_COORDINATES) {
            candidateDestinationCoordinate = piecePosition + currentCandidateOffset;

            if(BoardUtils.isValidTileCoordinate(candidateDestinationCoordinate)) {

                if (isFirstColumnExclusion(this.piecePosition, currentCandidateOffset)) {
                    continue;
                }

                if (isSecondColumnExclusion(this.piecePosition, currentCandidateOffset)) {
                    continue;
                }
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

    private static boolean isFirstColumnExclusion(final int currentPosition, final int candidateOffset) {
        return BoardUtils.FIRST_COLUMN[currentPosition] && ((candidateOffset == -17) || (candidateOffset == -10) || 
        (candidateOffset == 6) || (candidateOffset == 15));
    }

    private static boolean isSecondColumnExclusion(final int currentPosition, final int candidateOffset) {
        return BoardUtils.SECOND_COLUMN[currentPosition] && (( candidateOffset == -10) || candidateOffset == 6);
    }

    


}
