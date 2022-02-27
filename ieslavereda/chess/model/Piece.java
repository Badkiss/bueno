package es.ieslavereda.chess.model;

import com.diogonunes.jcolor.Attribute;

import java.util.List;

import static com.diogonunes.jcolor.Ansi.colorize;

public abstract class Piece {

    private ChessType chessType;
    protected Cell cell;

    public Piece(Cell cell, ChessType chessType){
        this.cell = cell;
        this.chessType = chessType;
    }
    public void place(){
        cell.setPiece(this);
    }
    public PieceColor getColor(){
        return chessType.getColor();
    }

    public Cell getCell() {
        return cell;
    }

    public String toString(){
        Attribute background = cell.getColor().getAttribute();
        Attribute textColor = chessType.getColor().getAttribute();
        Attribute[] myFormat = new Attribute[]{background,textColor};

        return colorize(" " + chessType.getShape() + " ",myFormat);

    }

    /**
     * metodo que distingue si una pieza es igual que otra
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o){
        if(o instanceof Piece){
            Piece p = (Piece) o;
            if(p.cell == this.cell && p.chessType == this.chessType)
                return true;
            else
                return false;
        } else
            return false;
    }

    /**
     * metodo obligatorio para todas las piezas que pide sus movimentos y los guarda en una lista
     * @return
     */
    public abstract List<Coordinate> getNextMovements();

    /**
     * metodo para saber si la coordenada dada puede moverse o no a esa posicion
     * @param aux
     * @return
     */
    public boolean mover(Coordinate aux){
    if(cell==null||!cell.getBoard().containsCellAt(aux)){
        return false;
        }
    if (getNextMovements().contains(aux)){
       Board tablero = cell.getBoard();
       if (tablero.containsPieceAt(aux)){
           Piece pieza = tablero.getCellAt(aux).getPiece();
           pieza.cell= null;
           tablero.getStore().add(pieza);
       }
       cell.setPiece(null);
       cell= tablero.getCellAt(aux);
       place();

       return true;
    }else{
        return false;
    }
    }

    /**
     * metodo para saber si la coordenada es valida para guardala en la lista de movimientos
     * @param aux
     * @return
     */
    protected boolean canMoveTo(Coordinate aux){
        Board board = cell.getBoard();

        return (board.containsCellAt(aux) && !board.containsPieceAt(aux) )||
                (board.containsCellAt(aux) &&
                        board.containsPieceAt(aux) &&
                        board.getCellAt(aux).getPiece().getColor()!=getColor());
    }
    /**
     * metodo para saber si la coordenada es valida para guardala en la lista de movimientos del peon
     * @param aux
     * @return
     */
    protected boolean canMoveToPawn (Coordinate aux){
        Board board = cell.getBoard();
        return (board.containsCellAt(aux) && !board.containsPieceAt(aux));
    }
    /**
     * metodo para saber si la coordenada es valida para guardala en la lista de movimientos del peon
     * @param aux
     * @return
     */
    protected boolean canMoveToPawnKill (Coordinate aux){
        Board board = cell.getBoard();
        return (board.containsCellAt(aux) && board.containsPieceAt(aux) && board.getCellAt(aux).getPiece().getColor()!=getColor());
    }

    public  ChessType getChessType(){
        return chessType;
    }

}
