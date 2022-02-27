package es.ieslavereda.chess.model.dynamicStructure;

import es.ieslavereda.chess.model.ChessType;
import es.ieslavereda.chess.model.IDeletedPieceManager;
import es.ieslavereda.chess.model.Piece;

import java.util.LinkedList;
import java.util.List;

public class Recolector implements IDeletedPieceManager {

    List<Piece> recolector;

    public Recolector(){
        recolector=new LinkedList<>();
    }


    @Override
    public void add(Piece piece) {
        recolector.add(piece);
    }

    @Override
    public Piece getFirst() {
        return  recolector.get(0);
    }

    @Override
    public void remove(Piece piece) {
        recolector.remove(piece);
    }

    @Override
    public int count(ChessType chessType) {
        return (int) recolector.stream().filter
                (piece -> piece.getChessType()==chessType).count();
    }
}
