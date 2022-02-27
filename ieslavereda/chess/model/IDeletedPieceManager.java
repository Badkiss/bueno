package es.ieslavereda.chess.model;

public interface IDeletedPieceManager {
    void add(Piece piece);
    Piece getFirst();
    void remove(Piece piece);
    int count(ChessType chessType);

}
