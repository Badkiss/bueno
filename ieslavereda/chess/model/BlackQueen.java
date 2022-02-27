package es.ieslavereda.chess.model;
import static  es.ieslavereda.chess.model.ChessType.BLACK_QUEEN;
public class BlackQueen extends  Queen {
    public BlackQueen(Cell cell) {
        super(cell, BLACK_QUEEN);
        place();
    }
}

