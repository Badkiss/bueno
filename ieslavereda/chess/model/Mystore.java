package es.ieslavereda.chess.model;

import java.util.List;

public class Mystore  implements  IDeletedPieceManager{
    private List<Piece> pieces;

    /**
     * metodo para añadir a la lista
     * @param piece
     */
    @Override
    public void add(Piece piece) {
        pieces.add(piece);
    }
    /**
     * metodo para seleccionar al primero de la lista
     *
     */
    @Override
    public Piece getFirst() {
        return pieces.get(0);
    }
    /**
     * metodo para quitar de la lista
     * @param piece
     */
    @Override
    public void remove(Piece piece) {
    pieces.remove(piece);
    }
    /**
     * metodo para contrar  la lista
     *
     */
    @Override
    public int count(ChessType chessType) {
        return (int) pieces.stream().filter(p ->p.getChessType()==chessType).count();

    }
}
