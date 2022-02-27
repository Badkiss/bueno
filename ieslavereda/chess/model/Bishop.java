package es.ieslavereda.chess.model;

import java.util.ArrayList;
import java.util.List;
//clase para el alfil
public class Bishop extends Piece {
    public Bishop(Cell cell, ChessType chessType) {
        super(cell, chessType);
    }
    //metodo para el movimiento del  alfil
    @Override
    /**
     * @param getNextMovements lista para guardar todos los movimientos de esa pieza
     */
    /**
     * @param aux coordenada auxiliar para poder guardar las coordenadas en la lista
     */
    public List<Coordinate> getNextMovements(){
        return getNextMovementsAsBishop(this);
    }
    public static List<Coordinate> getNextMovementsAsBishop(Piece pi) {
        List<Coordinate> nextMovements = new ArrayList<>();
        Coordinate position = pi.getCell().getCoordinate();
        Coordinate aux;
        boolean terminado = false;
        do {
            aux = position.up().left();
            if (canMoveTo(aux,pi)) {
                if (pi.getCell().getBoard().containsPieceAt(aux)){
                    nextMovements.add(aux);
                    terminado=true;
                }else {
                    nextMovements.add(aux);
                    position = aux;
                }
            } else {
                terminado = true;
            }


        } while (terminado == false);
        terminado=false;
        position =pi.getCell().getCoordinate();
        aux =position.up().right();
        do {
            aux = position.up().right();
            if (canMoveTo(aux,pi)) {
                if (pi.getCell().getBoard().containsPieceAt(aux)){
                    nextMovements.add(aux);
                    terminado=true;
                }else {
                    nextMovements.add(aux);
                    position = aux;
                }
            } else {
                terminado = true;
            }

        } while (terminado == false);
        terminado=false;
        position =pi.getCell().getCoordinate();
        aux =position.down().left();
        do {
            aux = position.down().left();
            if (canMoveTo(aux,pi)) {
                if (pi.getCell().getBoard().containsPieceAt(aux)){
                    nextMovements.add(aux);
                    terminado=true;
                }else {
                    nextMovements.add(aux);
                    position = aux;
                }
            } else {
                terminado = true;
            }

        } while (terminado == false);
        terminado=false;
        position =pi.getCell().getCoordinate();
        aux =position.down().right();
        do {
            aux = position.down().right();
            if (canMoveTo(aux,pi)) {
                if (pi.getCell().getBoard().containsPieceAt(aux)){
                    nextMovements.add(aux);
                    terminado=true;
                }else {
                    nextMovements.add(aux);
                    position = aux;
                }
            } else {
                terminado = true;
            }

        } while (terminado == false);

        return nextMovements;
    }

    /**
     * metodo para poder ver si con la coordenada dada es valida para el tablero
     * @param aux
     * @param pi
     * @return
     */
    protected static boolean canMoveTo(Coordinate aux,Piece pi){
        Board board = pi.getCell().getBoard();

        return (board.containsCellAt(aux) && !board.containsPieceAt(aux) )||
                (board.containsCellAt(aux) &&
                        board.containsPieceAt(aux) &&
                        board.getCellAt(aux).getPiece().getColor()!=pi.getColor());
    }

}