import java.util.ArrayList;

public class ChessBoard {
    private ArrayList<ArrayList<String>> board;


    public ChessBoard() {
        board = new ArrayList<ArrayList<String>>();
        createEmptyBoard();

    }

    private void createEmptyBoard() {
        for (int row = 0; row < 8; row++) {
            ArrayList<String> currentRow = new ArrayList<String>();

            for (int col = 0; col < 8; col++) {
                currentRow.add(".");

            }

            board.add(currentRow);
        }


    }

    private void setUpPieces() {
        board.set(0, makeRow( new String[]{"r", "b", "n", "q", "k", "n", "b", "r"}));

    }

    
}
