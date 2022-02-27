package es.ieslavereda.chess.model;

import java.util.ArrayList;
import java.util.List;
public abstract class Tower extends Piece {
    public Tower(Cell cell, ChessType chessType) {
        super(cell, chessType);
    }

    /**
     * guarda los movimientos de la torre en una lista
     * @return
     */
    @Override
    public List<Coordinate> getNextMovements(){
        return getNextMovementsAsRook(this);
    }
    /**
     * decide si se puede guardar o no los diferentes  movimientos de la torre en una lista
     * @return
     */
    public static List<Coordinate> getNextMovementsAsRook(Piece pi) {
        List<Coordinate> nextMovements = new ArrayList<>();
        Coordinate position = pi.getCell().getCoordinate();
        Coordinate aux;
        boolean terminado=false;
        do {
            aux = position.up();
            if (canMoveTo(aux,pi)){
                if (pi.getCell().getBoard().containsPieceAt(aux)){
                    nextMovements.add(aux);
                    terminado=true;
                }else {
                    nextMovements.add(aux);
                    position = aux;
                }
            }else{
                terminado = true;
            }
        }while(terminado==false);
        terminado=false;
        position =pi.getCell().getCoordinate();
        aux =position.down();
        do {
            aux = position.down();
            if (canMoveTo(aux,pi)){
                if (pi.getCell().getBoard().containsPieceAt(aux)){
                    nextMovements.add(aux);
                    terminado=true;
                }else {
                    nextMovements.add(aux);
                    position = aux;
                }
            }else{
                terminado = true;
            }
        }while(terminado==false);
        terminado=false;
        position =pi.getCell().getCoordinate();
        aux =position.left();
        do {
            aux = position.left();
            if (canMoveTo(aux,pi)){
                if (pi.getCell().getBoard().containsPieceAt(aux)){
                    nextMovements.add(aux);
                    terminado=true;
                }else {
                    nextMovements.add(aux);
                    position = aux;
                }
            }else{
                terminado = true;
            }
        }while(terminado==false);
        terminado=false;
        position =pi.getCell().getCoordinate();
        aux =position.right();
        do {
            aux = position.right();
            if (canMoveTo(aux,pi)){
                if (pi.getCell().getBoard().containsPieceAt(aux)){
                    nextMovements.add(aux);
                    terminado=true;
                }else {
                    nextMovements.add(aux);
                    position = aux;
                }
            }else{
                terminado = true;
            }
        }while(terminado==false);
        return nextMovements;
    }
    protected static boolean canMoveTo(Coordinate aux,Piece pi){
        Board board = pi.getCell().getBoard();

        return (board.containsCellAt(aux) && !board.containsPieceAt(aux) )||
                (board.containsCellAt(aux) &&
                        board.containsPieceAt(aux) &&
                        board.getCellAt(aux).getPiece().getColor()!=pi.getColor());
    }
}
