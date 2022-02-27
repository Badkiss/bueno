package es.ieslavereda.view;

import es.ieslavereda.chess.model.Board;
import es.ieslavereda.chess.model.ChessType;
import es.ieslavereda.chess.model.Coordinate;
import com.diogonunes.jcolor.Attribute;
import  es.ieslavereda.chess.model.*;
import static com.diogonunes.jcolor.Ansi.colorize;

public class Screen {
    /**
     * enseña el tablero
     * @param board
     */
    public static void show(Board board){

        String salida="";
        System.out.print("   A ");
        System.out.print(" B ");
        System.out.print(" C ");
        System.out.print(" D ");
        System.out.print(" E ");
        System.out.print(" F ");
        System.out.print(" G ");
        System.out.print(" H ");
        System.out.println();
        Coordinate c;
        for (int row=0;row<8;row++){
            salida+=(row + 1 )+" ";
            for (int col=0;col<8;col++){
                c = new Coordinate((char)('A'+col),row+1);
                salida+=board.getCellAt(c).toString();
            }
            salida+="\n";
        }
        System.out.println(salida);
    }

    /**
     * guarda todas las piezas que hay en el tablero
     * @param tablero
     * @param pieza
     * @return
     */
    public static long TodasPiezas(Board tablero, ChessType pieza){
       return tablero.getAllCells().stream().
                filter(p ->  p.getPiece() != null  && p.getPiece().getChessType() == pieza )
                .count();
    }

    /**
     * enseña todas las piezas que hay en el tablero
     * @param tablero
     * @return
     */
    public static String  CajaVivas(Board tablero){
        String vivas="           Caja Vivas \n";
        for(ChessType pieza : ChessType.values()){
          vivas += colorize(" "+ pieza.getShape()+" ", Cell.CellColor.BLACK_CELL.getColor(), pieza.getColor().getAttribute());
        }
        vivas +='\n';
        for(ChessType pieza : ChessType.values()){
            vivas += colorize(" "+ TodasPiezas(tablero,pieza)+" ", Cell.CellColor.WHITE_CELL.getColor(),Attribute.TEXT_COLOR(0,0,0));
        }
        return vivas;
    }
    /**
     * enseña todas las piezas que no hay en el tablero
     *
     * @return
     */
    public static String CajaMuertas(IDeletedPieceManager store){
        String muertas ="           Caja Muertas \n";
        for(ChessType pieza: ChessType.values()){
        muertas += colorize(" "+pieza.getShape()+" ", Cell.CellColor.BLACK_CELL.getColor(), pieza.getColor().getAttribute());
        }
        muertas+= '\n';
        for (ChessType pieza: ChessType.values()){
            muertas+= colorize(" "+store.count(pieza)+" ", Cell.CellColor.WHITE_CELL.getColor(),Attribute.TEXT_COLOR(0,0,0));
        }
        return muertas;
    }
}
